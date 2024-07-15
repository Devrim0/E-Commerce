package com.ecommerce.demo.service.impl;

import com.ecommerce.demo.entities.Card;
import com.ecommerce.demo.entities.CardItem;
import com.ecommerce.demo.entities.Customer;
import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.model.CardDto;
import com.ecommerce.demo.model.CardMapper;
import com.ecommerce.demo.repository.CardItemRepository;
import com.ecommerce.demo.repository.CardRepository;
import com.ecommerce.demo.repository.ProductRepository;
import com.ecommerce.demo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final ProductRepository productRepository;
    private final CardItemRepository cardItemRepository;
    private final CardMapper cardMapper;

    @Override
    public CardDto getCard(Long customerId) {
        Card card = cardRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return cardMapper.toCardDto(card);
    }

    @Override
    public CardDto updateCard(Long customerId, CardDto cardDto) {
        CardDto getCardDto = getCard(customerId);
        getCardDto.setTotalPrice(cardDto.getTotalPrice());
        Card card = cardMapper.toCard(getCardDto);
        cardRepository.save(card);
        return cardMapper.toCardDto(card);
    }

    @Override
    public void emptyCard(Long customerId) {
        CardDto cardDto = getCard(customerId);
        cardDto.getCardItems().clear();
        cardDto.setTotalPrice(0d);
        Card card = cardMapper.toCard(cardDto);
        cardRepository.save(card);
    }

    @Override
    public CardDto addProductToCard(Long customerId, Long productId, Integer quantity) {
       Card card = cardRepository.findByCustomerId(customerId).orElseGet(()-> createCardForCustomer(customerId));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        CardItem cardItem = card.getCardItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseGet(() -> new CardItem(card, product));

        cardItem.setQuantity(cardItem.getQuantity() + quantity);
        cardItem.setPrice(product.getPrice() * cardItem.getQuantity());

        card.getCardItems().add(cardItem);
        card.setTotalPrice(card.getCardItems().stream().mapToDouble(CardItem::getPrice).sum());

        product.setStock(product.getStock() - quantity);

        cardRepository.save(card);
        productRepository.save(product);

        return cardMapper.toCardDto(card);
    }

    @Override
    public CardDto removeProductFromCard(Long customerId, Long productId) {
        Card card = cardMapper.toCard(getCard(customerId));
        CardItem cartItem = card.getCardItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found in cart"));

        card.getCardItems().remove(cartItem);
        card.setTotalPrice(card.getCardItems().stream().mapToDouble(CardItem::getPrice).sum());

        cardRepository.save(card);

        return cardMapper.toCardDto(card);
    }


    private Card createCardForCustomer(Long customerId) {
        Card card = new Card();
        card.setCustomer(new Customer(customerId));
        card.setTotalPrice(0d);
        return card;
    }
}

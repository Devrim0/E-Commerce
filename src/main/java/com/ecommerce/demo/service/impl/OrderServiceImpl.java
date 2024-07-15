package com.ecommerce.demo.service.impl;

import com.ecommerce.demo.entities.Card;
import com.ecommerce.demo.entities.Order;
import com.ecommerce.demo.entities.OrderItem;
import com.ecommerce.demo.repository.CardRepository;
import com.ecommerce.demo.repository.OrderRepository;
import com.ecommerce.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CardRepository cartRepository;

    @Override
    public Order placeOrder(Long customerId) {
        Card card = cartRepository.findByCustomerId(customerId).orElseThrow(() -> new RuntimeException("Cart not found"));

        if (card.getCardItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();
        order.setCustomer(card.getCustomer());
        order.setTotalAmount(card.getTotalPrice());

        List<OrderItem> orderItems = card.getCardItems().stream()
                .map(cartItem -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setOrder(order);
                    orderItem.setProduct(cartItem.getProduct());
                    orderItem.setQuantity(cartItem.getQuantity());
                    orderItem.setPrice(cartItem.getPrice());
                    return orderItem;
                })
                .collect(Collectors.toList());

        order.setOrderItems(orderItems);
        orderRepository.save(order);

        // Clear the cart
        card.getCardItems().clear();
        card.setTotalPrice(0d);
        cartRepository.save(card);

        return order;
    }

    @Override
    public Order getOrderForCode(String orderCode) {
        return orderRepository.findById(Long.parseLong(orderCode)).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

}

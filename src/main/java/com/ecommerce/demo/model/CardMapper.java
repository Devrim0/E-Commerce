package com.ecommerce.demo.model;

import com.ecommerce.demo.entities.Card;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardMapper {
    private final ModelMapper modelMapper = new ModelMapper();

   public Card toCard(CardDto cardDto) {
        return modelMapper.map(cardDto, Card.class);
    }

   public CardDto toCardDto(Card card) {
        return modelMapper.map(card, CardDto.class);
    }
}

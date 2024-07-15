package com.ecommerce.demo.model;

import com.ecommerce.demo.entities.CardItem;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CardItemMapper {
    private final ModelMapper modelMapper = new ModelMapper();
    public CardItem toCardItem(CardItemDto cardItemDto) {
        return modelMapper.map(cardItemDto, CardItem.class);
    }

    public CardItemDto toCardItemDto(CardItem cardItem) {
        return modelMapper.map(cardItem, CardItemDto.class);
    }
}

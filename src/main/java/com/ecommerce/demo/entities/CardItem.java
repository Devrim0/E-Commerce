package com.ecommerce.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class CardItem extends BaseEntity{
    @ManyToOne
    private Card card;

    @ManyToOne
    private Product product;

    private int quantity;
    private double price;

    public CardItem(Card card, Product product) {
    }
}

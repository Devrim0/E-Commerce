package com.ecommerce.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Card extends BaseEntity{
    @OneToOne
    private Customer customer;
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardItem> cardItems;

}

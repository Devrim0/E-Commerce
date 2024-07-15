package com.ecommerce.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class OrderItem extends BaseEntity{
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private int quantity;
    private double price;
}

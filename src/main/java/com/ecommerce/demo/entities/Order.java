package com.ecommerce.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "orders")
public class Order  extends BaseEntity{
    @ManyToOne
    private Customer customer;

    private LocalDateTime orderDate;
    private Double totalAmount;

    @OneToMany
    private List<OrderItem> orderItems;

    private String status;
}

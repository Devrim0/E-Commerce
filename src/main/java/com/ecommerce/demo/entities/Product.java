package com.ecommerce.demo.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Product extends  BaseEntity{
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private String category;
}

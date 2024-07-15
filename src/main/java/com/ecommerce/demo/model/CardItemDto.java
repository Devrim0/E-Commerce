package com.ecommerce.demo.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CardItemDto {
    private Long id;

    @NotNull(message = "Product name cannot be null")
    @Size(min = 1, max = 200, message = "Product name must be between 1 and 200 characters")
    private String productName;

    @NotNull(message = "Quantity cannot be null")
    private int quantity;

    @NotNull(message = "Price cannot be null")
    private double price;

}
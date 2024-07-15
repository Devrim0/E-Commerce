package com.ecommerce.demo.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class CardDto {
    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;
    private Double totalPrice;
    @Valid // Her bir CardItemDTO'nun kendi doğrulamalarını yapmasını sağlar
    private List<CardItemDto> cardItems;
}

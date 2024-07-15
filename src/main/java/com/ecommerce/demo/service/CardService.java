package com.ecommerce.demo.service;

import com.ecommerce.demo.model.CardDto;
import org.springframework.http.ResponseEntity;

public interface CardService {
    CardDto getCard(Long customerId);
    CardDto updateCard(Long customerId, CardDto cardDto);

    void emptyCard(Long costumerId);

    CardDto addProductToCard(Long customerId, Long productId, Integer quantity);

    CardDto removeProductFromCard(Long customerId, Long productId);
}

package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.CardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CardController {
    ResponseEntity<CardDto> getCard(@PathVariable Long customerId);
    ResponseEntity<CardDto> updateCard(@PathVariable Long customerId,@RequestBody CardDto cardDto);
    ResponseEntity<Void> emptyCard(@PathVariable Long customerId);
     ResponseEntity<CardDto> addProductToCard(@PathVariable Long customerId, @RequestParam Long productId, @RequestParam Integer quantity);
    ResponseEntity<CardDto> removeProductFromCard(@PathVariable Long customerId, @RequestParam Long productId);
}

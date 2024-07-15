package com.ecommerce.demo.controller.impl;

import com.ecommerce.demo.controller.CardController;
import com.ecommerce.demo.model.CardDto;
import com.ecommerce.demo.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardControllerImpl implements CardController {
    private final CardService cardService;

    @Override
    @Operation(summary = "get card by customer Id")
    @GetMapping("/{customerId}")
    public ResponseEntity<CardDto> getCard(Long customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.getCard(customerId));
    }

    @Override
    @Operation(summary = "update card")
    @PutMapping("/{customerId}")
    public ResponseEntity<CardDto> updateCard(Long customerId,CardDto cardDto) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.updateCard(customerId, cardDto));
    }

    @Override
    @Operation(summary = "clear card")
    @DeleteMapping("/{customerId}/empty")
    public ResponseEntity<Void> emptyCard(Long customerId) {
        cardService.emptyCard(customerId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Operation(summary = "add product to card")
    @PostMapping("/{customerId}/add")
    public ResponseEntity<CardDto> addProductToCard(Long customerId, Long productId, Integer quantity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cardService.addProductToCard(customerId,productId, quantity));
    }

    @Override
    @Operation(summary = "remove customer")
    @DeleteMapping("/{customerId}/remove")
    public ResponseEntity<CardDto> removeProductFromCard(Long customerId, Long productId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardService.removeProductFromCard(customerId, productId));
    }
}

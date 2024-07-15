package com.ecommerce.demo.controller.impl;

import com.ecommerce.demo.controller.ProductController;
import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.model.ProductDto;
import com.ecommerce.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;
    @Override
    @GetMapping("/{id}")
    @Operation(summary = "get product")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(id));
    }

    @Override
    @PostMapping
    @Operation(summary = "create product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));
    }

    @Override
    @PutMapping("/{id}")
    @Operation(summary = "update product")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, productDto));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "delete product")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

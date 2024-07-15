package com.ecommerce.demo.controller;

import com.ecommerce.demo.entities.Product;
import com.ecommerce.demo.model.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductController {
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id);

    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto);

    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto);

    public ResponseEntity<Void> deleteProduct(@PathVariable Long id);
}

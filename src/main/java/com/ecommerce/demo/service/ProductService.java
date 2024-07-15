package com.ecommerce.demo.service;


import com.ecommerce.demo.model.ProductDto;

public interface ProductService {
    ProductDto getProduct(Long id);

    ProductDto createProduct(ProductDto productDto);

    ProductDto updateProduct(Long id, ProductDto productDto);

    void deleteProduct(Long id);
}

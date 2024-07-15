package com.ecommerce.demo.controller;

import com.ecommerce.demo.model.CustomerDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CustomerController {
    ResponseEntity<CustomerDto> addCustomer(@Valid @RequestBody CustomerDto customerDto);
}

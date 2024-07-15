package com.ecommerce.demo.controller.impl;

import com.ecommerce.demo.controller.CustomerController;
import com.ecommerce.demo.model.CustomerDto;
import com.ecommerce.demo.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerControllerImpl implements CustomerController {
    private final CustomerService customerService;
    @PostMapping("/add")
    @Operation(summary = "Add a new customer")
    @Override
    public ResponseEntity<CustomerDto> addCustomer(CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customerDto));
    }
}

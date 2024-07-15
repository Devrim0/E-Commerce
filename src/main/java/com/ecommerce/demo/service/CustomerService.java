package com.ecommerce.demo.service;

import com.ecommerce.demo.model.CustomerDto;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    CustomerDto addCustomer(CustomerDto customerDto);
}

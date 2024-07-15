package com.ecommerce.demo.service.impl;

import com.ecommerce.demo.entities.Customer;
import com.ecommerce.demo.model.CustomerDto;
import com.ecommerce.demo.model.CustomerMapper;
import com.ecommerce.demo.repository.CustomerRepository;
import com.ecommerce.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toCustomer(customerDto);
        customerRepository.save(customer);
        return customerMapper.toCustomerDto(customer);
    }
}

package com.ecommerce.demo.model;

import com.ecommerce.demo.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public Customer toCustomer(CustomerDto customerDto){
        return modelMapper.map(customerDto, Customer.class);
    }

    public  CustomerDto toCustomerDto(Customer customer){
        return modelMapper.map(customer, CustomerDto.class);
    }
}

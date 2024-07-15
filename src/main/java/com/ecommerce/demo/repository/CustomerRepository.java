package com.ecommerce.demo.repository;

import com.ecommerce.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

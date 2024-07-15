package com.ecommerce.demo.controller;

import com.ecommerce.demo.entities.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderControlller {
    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId);

    public ResponseEntity<Order> getOrderForCode(@PathVariable String orderCode);

    public ResponseEntity<List<Order>> getAllOrdersForCustomer(@PathVariable Long customerId);
}

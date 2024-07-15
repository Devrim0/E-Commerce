package com.ecommerce.demo.service;

import com.ecommerce.demo.entities.Order;

import java.util.List;

public interface OrderService {
     Order placeOrder(Long customerId);
     Order getOrderForCode(String orderCode);

    List<Order> getAllOrdersForCustomer(Long customerId);
}

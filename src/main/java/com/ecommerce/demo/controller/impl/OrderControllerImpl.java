package com.ecommerce.demo.controller.impl;

import com.ecommerce.demo.controller.OrderControlller;
import com.ecommerce.demo.entities.Order;
import com.ecommerce.demo.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderControllerImpl implements OrderControlller {
    private final OrderService orderService;
    @PostMapping("/{customerId}/place")
    @Operation(summary = "place order")
    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId) {
        Order placedOrder = orderService.placeOrder(customerId);
        return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{orderCode}")
    @Operation(summary = "get order for code")
    public ResponseEntity<Order> getOrderForCode(@PathVariable String orderCode) {
        Order order = orderService.getOrderForCode(orderCode);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/customer/{customerId}")
    @Operation(summary = "ger all order for customer")
    public ResponseEntity<List<Order>> getAllOrdersForCustomer(@PathVariable Long customerId) {
        List<Order> orders = orderService.getAllOrdersForCustomer(customerId);
        return ResponseEntity.ok(orders);
    }
}

package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.DTO.OrderDto;
import com.att.tdp.bisbis10.entity.OrderResponse;
import com.att.tdp.bisbis10.entity.Orders;
import com.att.tdp.bisbis10.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderDto orderDto) {
        UUID orderId = orderService.placeOrder(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(new OrderResponse(orderId));
    }
}
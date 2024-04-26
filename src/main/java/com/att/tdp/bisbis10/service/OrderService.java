package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.DTO.OrderDto;
import com.att.tdp.bisbis10.entity.OrderItem;
import com.att.tdp.bisbis10.entity.Orders;
import com.att.tdp.bisbis10.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public UUID placeOrder(OrderDto orderDto) {
        Orders order = new Orders();
        order.setRestaurantId(orderDto.getRestaurantId());
        List<OrderItem> orderItems = orderDto.getOrderItems().stream()
                .map(item -> {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setDishId(item.getDishId());
                    orderItem.setAmount(item.getAmount());
                    return orderItem;
                })
                .collect(Collectors.toList());
        order.setOrderItems(orderItems);
        Orders savedOrder = orderRepository.save(order);
        return savedOrder.getOrderId();
    }
}
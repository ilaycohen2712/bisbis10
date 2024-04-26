package com.att.tdp.bisbis10.DTO;

import com.att.tdp.bisbis10.entity.OrderItem;

import java.util.List;

public class OrderDto {
    private Long restaurantId;
    private List<OrderItemDto> orderItems;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
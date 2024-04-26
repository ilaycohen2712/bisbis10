package com.att.tdp.bisbis10.entity;

import jakarta.persistence.*;
import com.att.tdp.bisbis10.entity.OrderItem;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Orders {
    @Id @GeneratedValue
    UUID orderId;
    Long restaurantId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItem> orderItems = new ArrayList<>();
    public Orders(){}
    public void setId(UUID id) {
        this.orderId = id;
    }
    public UUID getId() {
        return orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

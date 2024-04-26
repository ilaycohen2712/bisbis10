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

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    Restaurant restaurant;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

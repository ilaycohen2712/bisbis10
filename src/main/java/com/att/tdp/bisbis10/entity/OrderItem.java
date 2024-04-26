package com.att.tdp.bisbis10.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id @GeneratedValue
    Long orderItemId;
    Long dishId;
    Integer amount;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Orders order;

    public OrderItem() {}


    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}

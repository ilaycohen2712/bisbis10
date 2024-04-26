package com.att.tdp.bisbis10.DTO;

public class OrderItemDto {
    private Long dishId;
    private Integer amount;

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
}
package com.att.tdp.bisbis10.entity;

import java.util.UUID;

public class OrderResponse {
    public UUID orderId;
    public OrderResponse(UUID orderId){
        this.orderId=orderId;
    }
}

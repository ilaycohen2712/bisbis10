package com.att.tdp.bisbis10.repository;

import com.att.tdp.bisbis10.entity.Orders;
import com.att.tdp.bisbis10.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Orders,Long> {
    Boolean findOrdersByRestaurantId(Long restaurantId);
}

package com.att.tdp.bisbis10.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Dish {
    @Id @GeneratedValue
    Long dishId;
    String dishName;
    String description;
    Double price;
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    @JsonIgnore
    Restaurant restaurant;
    public Dish(){}
    public Long getDishId() {return dishId;}
    public String getDishName() {return dishName;}
    public void setDishName(String dishName) {this.dishName = dishName;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Double getPrice() {return price;}
    public void setPrice(Double price) {this.price = price;}

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

package com.att.tdp.bisbis10.DTO;

import java.util.Set;

public class RestaurantDto {
    Long id;
    private static Set<String> cuisines;

    String name;

    Double averageRating;

    Boolean isKosher;


    public Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public Boolean getIsKosher() {
        return isKosher;
    }
}

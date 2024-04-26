package com.att.tdp.bisbis10.DTO;

import java.util.Set;

public class RestaurantDto {
    private static Set<String> cuisines;

    public static Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }
}

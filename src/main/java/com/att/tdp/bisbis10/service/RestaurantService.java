package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        restaurants = restaurants.stream().filter(restaurant -> restaurant.getCuisines().contains(cuisine)).collect(Collectors.toList());
        return restaurants;
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new IllegalStateException("Restaurant with id " + id + " does not exist"));
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Transactional
    public Restaurant updateRestaurant(Long restaurantId, Set<String> cuisines) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalStateException("Restaurant with id " + restaurantId + " does not exist"));
        restaurant.setCuisines(cuisines);
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long restaurantId) {
        if (!restaurantRepository.existsById(restaurantId))
            throw new IllegalStateException("Restaurant with id " + restaurantId + " does not exist");
        restaurantRepository.deleteById(restaurantId);
    }
}
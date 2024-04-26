package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.DTO.RestaurantDto;
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

    public void createRestaurant(RestaurantDto restaurantDto) {
        Restaurant r = new Restaurant();
        r.setAverageRating(restaurantDto.getAverageRating());
        r.setCuisines(restaurantDto.getCuisines());
        r.setIsKosher(restaurantDto.getIsKosher());
        r.setName(restaurantDto.getName());
        restaurantRepository.save(r);
    }
    public void updateRestaurant(Long restaurantId, RestaurantDto restaurantDto) {
        Restaurant r = restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalStateException("Restaurant with id " + restaurantId + " does not exist"));
        if (restaurantDto.getAverageRating() != null)
            r.setAverageRating(restaurantDto.getAverageRating());
        if(restaurantDto.getCuisines()!= null)
            r.setCuisines(restaurantDto.getCuisines());
        if (!restaurantDto.getIsKosher())
            r.setIsKosher(restaurantDto.getIsKosher());
        if (restaurantDto.getName()!=null)
            r.setName(restaurantDto.getName());
        restaurantRepository.save(r);
    }

    public void deleteRestaurant(Long restaurantId) {
        if (!restaurantRepository.existsById(restaurantId))
            throw new IllegalStateException("Restaurant with id " + restaurantId + " does not exist");
        restaurantRepository.deleteById(restaurantId);
    }
}
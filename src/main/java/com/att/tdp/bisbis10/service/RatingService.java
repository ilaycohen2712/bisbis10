package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.DTO.RatingDto;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRating(RatingDto ratingDto) {
        Long restaurantId = ratingDto.getRestaurantId();
        Double rating = ratingDto.getAverageRating();

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalStateException("Restaurant with id " + restaurantId + " does not exist"));
        restaurant.setAverageRating(rating);
        restaurantRepository.save(restaurant);
    }
}
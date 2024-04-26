package com.att.tdp.bisbis10.controller;
import com.att.tdp.bisbis10.DTO.RestaurantDto;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping(params = "cuisine")
    public ResponseEntity<List<Restaurant>> getRestaurantsByCuisine(@RequestParam("cuisine") String cuisine) {
        return ResponseEntity.ok(restaurantService.getRestaurantsByCuisine(cuisine));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRestaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable("id") Long restaurantId, @RequestBody RestaurantDto updateRestaurantDto) {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantId, RestaurantDto.getCuisines());
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
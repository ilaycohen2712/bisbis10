package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        return  ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable("id") Long id){
        return null;
    }
    @GetMapping("/{cuisine}")
    public List<Restaurant> getRestaurantsByCuisine(@PathVariable("cuisine") String cuisine){
        return ResponseEntity.ok(restaurantService.getRestaurantsByCuisine(cuisine)).getBody();
    }
    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestBody Restaurant r){
        restaurantService.createRestaurant(r);
        return ResponseEntity.status(201).body(null);
    }

    @PutMapping(path = "{id}")
    public void updateRestaurant(@PathVariable("id") Long restaurantId, @RequestParam(required= true) Set<String> cuisines){
        restaurantService.updateRestaurant(restaurantId, cuisines);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

}

package com.att.tdp.bisbis10.controller;

import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.repository.DishRepository;
import com.att.tdp.bisbis10.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurants")
public class DishController {

    @Autowired
    DishService dishService;
    @PostMapping("/{id}/dishes")
    public ResponseEntity<?> addDish(@PathVariable Long id,@RequestBody Dish dish, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        Dish savedDish = dishService.saveDish(id, dish);
        return ResponseEntity.status(201).body(savedDish);
    }
    @PutMapping("/{restaurantId}/dishes/{dishId}")
    public ResponseEntity<Dish> updateDish(@PathVariable Long restaurantId, @PathVariable Long dishId, @RequestBody Dish dishDetails) {
        return dishService.updateDish(dishId, dishDetails)
                .map(dish -> ResponseEntity.ok().body(dish))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{restaurantId}/dishes/{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable Long dishId) {
        dishService.deleteDish(dishId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/dishes")
    public ResponseEntity<List<Dish>> getDishesByRestaurant(@PathVariable Long id) {
        List<Dish> dishes = dishService.getDishesByRestaurant(id);
        return ResponseEntity.ok(dishes);
    }


}

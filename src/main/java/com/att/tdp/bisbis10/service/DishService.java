package com.att.tdp.bisbis10.service;

import com.att.tdp.bisbis10.entity.Dish;
import com.att.tdp.bisbis10.entity.Restaurant;
import com.att.tdp.bisbis10.repository.DishRepository;
import io.micrometer.observation.ObservationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    @Autowired
    DishRepository dishRepository;
    @Autowired
    RestaurantService restaurantService;
    public Dish saveDish(Long restaurantId, Dish dish) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        if (restaurant.getId() != null) {
            dish.setRestaurant(restaurant);
            return dishRepository.save(dish);
        } else {
            throw new RuntimeException("Restaurant not found");
        }
    }public Optional<Dish> updateDish(Long dishId, Dish updatedDish) {
        return dishRepository.findById(dishId)
                .map(dish -> {
                    dish.setDishName(updatedDish.getDishName() == null ?
                            dish.getDishName() : updatedDish.getDishName());
                    dish.setDescription(updatedDish.getDescription() == null ?
                            dish.getDescription() : updatedDish.getDescription());
                    dish.setPrice(updatedDish.getPrice() == 0 ?
                            dish.getPrice() : updatedDish.getPrice());
                    return dishRepository.save(dish);
                });
    }

    public void deleteDish(Long dishId) {
        dishRepository.deleteById(dishId);
    }

    public List<Dish> getDishesByRestaurant(Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId);
    }
}

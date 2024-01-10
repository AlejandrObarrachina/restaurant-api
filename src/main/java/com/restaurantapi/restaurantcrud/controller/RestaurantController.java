package com.restaurantapi.restaurantcrud.controller;

import com.restaurantapi.restaurantcrud.model.Restaurant;
import com.restaurantapi.restaurantcrud.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    @GetMapping(value = "/restaurants", produces = "application/json")
    public List<Restaurant> getAllRestaurants() {
        return service.getAllRestaurants();
    }

    @GetMapping(value = "/restaurants/{id}", produces = "application/json")
    public Optional<Restaurant> getAllRestaurants(@PathVariable Long id) throws Exception {
        return service.getRestaurantById(id);
    }

    @PostMapping(value = "/restaurants", produces = "application/json")
    public void getAllRestaurants(@RequestBody Restaurant restaurant) throws Exception {
        service.addRestaurant(restaurant);
    }

}

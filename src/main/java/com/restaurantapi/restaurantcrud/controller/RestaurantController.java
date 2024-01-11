package com.restaurantapi.restaurantcrud.controller;

import com.restaurantapi.restaurantcrud.model.Restaurant;
import com.restaurantapi.restaurantcrud.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public Optional<Restaurant> getRestaurant(@PathVariable Long id) throws Exception {
        return service.getRestaurantById(id);
    }

    @PostMapping(value = "/restaurants", produces = "application/json")
    public ResponseEntity<Void> addRestaurant(@RequestBody Restaurant restaurant) throws Exception {

        Long newRestaurant = service.addRestaurant(restaurant).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newRestaurant)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/restaurants/{id}")
    public void updateRestaurant(@PathVariable Long id, @RequestBody Restaurant updatedRestaurant) throws Exception {
        service.updateRestaurant(id, updatedRestaurant);
    }

    @DeleteMapping(value = "/restaurants/{id}")
    public void deleteRestaurant(@PathVariable Long id) throws Exception {
        service.deleteRestaurant(id);
    }

}

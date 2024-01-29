package com.restaurantapi.restaurantcrud.controller;

import com.restaurantapi.restaurantcrud.mappers.RestaurantMapper;
import com.restaurantapi.restaurantcrud.model.Restaurant;
import com.restaurantapi.restaurantcrud.model.entities.RestaurantEntity;
import com.restaurantapi.restaurantcrud.model.exceptions.IdNotFoundException;
import com.restaurantapi.restaurantcrud.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestaurantController {

    private final RestaurantService service;
    private final RestaurantMapper restaurantMapper;

    public RestaurantController(RestaurantService service, RestaurantMapper restaurantMapper) {
        this.service = service;
        this.restaurantMapper = restaurantMapper;
    }

    @GetMapping(value = "/restaurants", produces = "application/json")
    public List<Restaurant> getAllRestaurants() throws Exception {
        return restaurantMapper.restaurantsEntityListToEntityModel(service.getAllRestaurants());
    }

    @GetMapping(value = "/restaurants/{id}", produces = "application/json")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) throws Exception {
        RestaurantEntity restaurant = service.getRestaurantById(id).orElseThrow(()-> new IdNotFoundException(id));
        Restaurant body = restaurantMapper.restaurantEntityToModel(restaurant);
        return ResponseEntity.ok(body);
    }

    @PostMapping(value = "/restaurants", produces = "application/json")
    public ResponseEntity<Void> addRestaurant(@Valid @RequestBody Restaurant restaurant) throws Exception {
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

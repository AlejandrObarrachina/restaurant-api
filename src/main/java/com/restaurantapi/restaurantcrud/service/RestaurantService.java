package com.restaurantapi.restaurantcrud.service;

import com.restaurantapi.restaurantcrud.model.Restaurant;
import com.restaurantapi.restaurantcrud.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }
    public List<Restaurant> getAllRestaurants(){
       return repository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id) throws Exception {
        try {
            return repository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void addRestaurant(Restaurant restaurant) throws Exception {
        try {
            repository.save(restaurant);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

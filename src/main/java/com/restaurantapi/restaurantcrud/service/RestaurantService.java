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

    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id) throws Exception {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Restaurant addRestaurant(Restaurant restaurant) throws Exception {
        try {
            return repository.save(restaurant);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateRestaurant(Long id, Restaurant updatedRestaurant) throws Exception {
        try {
            Restaurant oldRestaurant = repository.findById(id).orElseThrow(() -> new Exception("Restaurant Not found"));

            oldRestaurant.setName(updatedRestaurant.getName());
            oldRestaurant.setAddress(updatedRestaurant.getAddress());
            oldRestaurant.setGastronomy(updatedRestaurant.getGastronomy());
            oldRestaurant.setPrice(updatedRestaurant.getPrice());
            oldRestaurant.setRating(updatedRestaurant.getRating());

            repository.save(updatedRestaurant);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void deleteRestaurant(Long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

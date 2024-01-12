package com.restaurantapi.restaurantcrud.service;

import com.restaurantapi.restaurantcrud.mappers.RestaurantMapper;
import com.restaurantapi.restaurantcrud.model.Restaurant;
import com.restaurantapi.restaurantcrud.model.entities.RestaurantEntity;
import com.restaurantapi.restaurantcrud.model.exceptions.IdNotFoundException;
import com.restaurantapi.restaurantcrud.model.exceptions.RestaurantAlreadyExistException;
import com.restaurantapi.restaurantcrud.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository repository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantService(RestaurantRepository repository, RestaurantMapper restaurantMapper) {
        this.repository = repository;
        this.restaurantMapper = restaurantMapper;
    }

    public List<RestaurantEntity> getAllRestaurants() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Optional<RestaurantEntity> getRestaurantById(Long id) throws IdNotFoundException {
        if (repository.existsById(id)) {
            return repository.findById(id);
        } else {
            throw new IdNotFoundException(id);
        }
    }

    public RestaurantEntity addRestaurant(Restaurant restaurant) throws Exception {
        if (!repository.existsByName(restaurant.getName())) {
            RestaurantEntity restaurantEntity = restaurantMapper.restaurantModelToEntity(restaurant);
            return repository.save(restaurantEntity);
        } else {
            throw new RestaurantAlreadyExistException(restaurant.getName());
        }
    }

    public void updateRestaurant(Long id, Restaurant updatedRestaurant) throws Exception {
        try {
            RestaurantEntity oldRestaurant = repository.findById(id).orElseThrow(() -> new IdNotFoundException(id));

            oldRestaurant.setName(updatedRestaurant.getName());
            oldRestaurant.setAddress(restaurantMapper.addressEntityToModel(updatedRestaurant.getAddress()));
            oldRestaurant.setGastronomy(updatedRestaurant.getGastronomy());
            oldRestaurant.setPrice(updatedRestaurant.getPrice());
            oldRestaurant.setRating(updatedRestaurant.getRating());

            repository.save(oldRestaurant);
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

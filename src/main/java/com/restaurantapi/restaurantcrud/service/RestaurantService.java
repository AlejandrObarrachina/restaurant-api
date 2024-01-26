package com.restaurantapi.restaurantcrud.service;

import com.restaurantapi.restaurantcrud.mappers.RestaurantMapper;
import com.restaurantapi.restaurantcrud.model.Restaurant;
import com.restaurantapi.restaurantcrud.model.entities.RestaurantEntity;
import com.restaurantapi.restaurantcrud.model.exceptions.IdNotFoundException;
import com.restaurantapi.restaurantcrud.model.exceptions.RestaurantAlreadyExistException;
import com.restaurantapi.restaurantcrud.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
            setRestaurantTypeIcon(restaurant);
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
            repository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
            repository.deleteById(id);
        } catch (IdNotFoundException e) {
            throw new IdNotFoundException(id);
        }
    }

    private static void setRestaurantTypeIcon(Restaurant restaurant) {
        if (Objects.equals(restaurant.getGastronomy(), "Indian")) {
            restaurant.setImageUrl("https://cdn1.iconfinder.com/data/icons/fast-food-and-restaurant-meals-1/128/Indian_Curry-512.png");
        } else if (Objects.equals(restaurant.getGastronomy(), "Burger")) {
            restaurant.setImageUrl("https://cdn3.iconfinder.com/data/icons/restaurant-91/512/rest_burger-512.png");
        } else if(Objects.equals(restaurant.getGastronomy(), "Sushi")) {
            restaurant.setImageUrl("https://cdn2.iconfinder.com/data/icons/food-desserts-drinks-and-sweets/512/sushi-512.png");
        } else if(Objects.equals(restaurant.getGastronomy(), "Vegan")) {
            restaurant.setImageUrl("https://cdn4.iconfinder.com/data/icons/food-serving-part-2/128/food-plate-09-512.png");
        } else if(Objects.equals(restaurant.getGastronomy(), "Italian")) {
            restaurant.setImageUrl("https://cdn4.iconfinder.com/data/icons/food-serving-part-2/128/food-plate-09-512.png");
        } else if(Objects.equals(restaurant.getGastronomy(), "Mexican")) {
            restaurant.setImageUrl("https://cdn1.iconfinder.com/data/icons/restaurants-and-food/103/taco-512.png");
        } else if(Objects.equals(restaurant.getGastronomy(), "Spanish")){
            restaurant.setImageUrl("https://cdni.iconscout.com/illustration/premium/thumb/spanish-food-6771837-5650000.png?f=webp");
        }
    }

}

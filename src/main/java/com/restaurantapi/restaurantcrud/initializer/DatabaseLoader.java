package com.restaurantapi.restaurantcrud.initializer;

import com.restaurantapi.restaurantcrud.model.Address;
import com.restaurantapi.restaurantcrud.model.Restaurant;
import com.restaurantapi.restaurantcrud.model.entities.AddressEntity;
import com.restaurantapi.restaurantcrud.model.entities.RestaurantEntity;
import com.restaurantapi.restaurantcrud.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final RestaurantRepository repository;

    public DatabaseLoader(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        this.repository.save(new RestaurantEntity("Jaleby Baby", new AddressEntity("C/ Verdi", 15, "Barcelona", "08025") , "Indian", 4, 3));
    }
}

package com.restaurantapi.restaurantcrud.repository;

import com.restaurantapi.restaurantcrud.model.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    boolean existsByName(String name);
}

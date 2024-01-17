package com.restaurantapi.restaurantcrud.mappers;

import com.restaurantapi.restaurantcrud.model.Address;
import com.restaurantapi.restaurantcrud.model.Restaurant;
import com.restaurantapi.restaurantcrud.model.entities.AddressEntity;
import com.restaurantapi.restaurantcrud.model.entities.RestaurantEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class RestaurantMapper {

    public AddressEntity addressEntityToModel(Address address){
        AddressEntity entity = new AddressEntity();
        entity.setId(address.getId());
        entity.setCity(address.getCity());
        entity.setNumber(address.getNumber());
        entity.setPostCode(address.getPostCode());
        entity.setStreet(address.getStreet());

        return entity;

    }

    public Address addressModelToEntity(AddressEntity address){
        Address model = new Address();
        model.setId(address.getId());
        model.setCity(address.getCity());
        model.setNumber(address.getNumber());
        model.setPostCode(address.getPostCode());
        model.setStreet(address.getStreet());

        return model;

    }
    public RestaurantEntity restaurantModelToEntity(Restaurant model){
        RestaurantEntity entity = new RestaurantEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setAddress(addressEntityToModel(model.getAddress()));
        entity.setGastronomy(model.getGastronomy());
        entity.setRating(model.getRating());
        entity.setPrice(model.getPrice());
        entity.setImageUrl(model.getImageUrl());

        return entity;
    }

    public Restaurant restaurantEntityToModel(RestaurantEntity entity){
        Restaurant model = new Restaurant();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setAddress(addressModelToEntity(entity.getAddress()));
        model.setGastronomy(entity.getGastronomy());
        model.setRating(entity.getRating());
        model.setPrice(entity.getPrice());
        model.setImageUrl(entity.getImageUrl());

        return model;
    }

    public List<Restaurant> restaurantsEntityListToEntityModel(List<RestaurantEntity> listEntity) {
       return listEntity.stream().map(this::restaurantEntityToModel).toList();
    }
}

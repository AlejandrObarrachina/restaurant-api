package com.restaurantapi.restaurantcrud.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RestaurantAlreadyExistException extends Exception{
    public RestaurantAlreadyExistException(String name) {
        super("Restaurant with name " + name + " already exist.");
    }
}

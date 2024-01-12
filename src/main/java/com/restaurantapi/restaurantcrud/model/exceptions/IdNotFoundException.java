package com.restaurantapi.restaurantcrud.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNotFoundException extends Exception{
    public IdNotFoundException(Long id) {
        super("Restaurant with id " + id + " not found.");
    }
}

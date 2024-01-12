package com.restaurantapi.restaurantcrud.config.handler;

import com.restaurantapi.restaurantcrud.model.exceptions.IdNotFoundException;
import com.restaurantapi.restaurantcrud.model.exceptions.RestaurantAlreadyExistException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidInputMovie(MethodArgumentNotValidException exception) {
        Map<String, String> map =  new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            map.put("code",HttpStatus.BAD_REQUEST.toString());
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        return map;
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<Object> handleIdNotFoundException(Exception e) {
        Map<String,Object> body = new HashMap<>();
        body.put("message", e.getMessage());
        body.put("code", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.CONFLICT)

    @ExceptionHandler(RestaurantAlreadyExistException.class)
    public ResponseEntity<Object> handleAlreadyExistRestaurant(Exception e) {
        Map<String,Object> body = new HashMap<>();
        body.put("message", e.getMessage());
        body.put("code", HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }




}

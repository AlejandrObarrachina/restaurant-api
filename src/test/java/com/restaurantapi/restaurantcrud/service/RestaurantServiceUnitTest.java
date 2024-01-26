package com.restaurantapi.restaurantcrud.service;

import com.restaurantapi.restaurantcrud.mappers.RestaurantMapper;
import com.restaurantapi.restaurantcrud.model.entities.RestaurantEntity;
import com.restaurantapi.restaurantcrud.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceUnitTest {
    @Mock
    RestaurantRepository repository;
    @Mock
    RestaurantMapper mapper;
    @InjectMocks
    RestaurantService service;

    @Test
    public void isGetAllRestaurants_FetchingAllRestaurants_OK() throws Exception {
        // Given
        Stream<RestaurantEntity> list = Stream.of(new RestaurantEntity());
        List<RestaurantEntity> restaurantEntitiesList = list.toList();

        // When
        when(repository.findAll()).thenReturn(restaurantEntitiesList);

        List<RestaurantEntity> result = service.getAllRestaurants();
        // Assert
        assertEquals(result.size(), restaurantEntitiesList.size());
    }
}

package com.restaurantapi.restaurantcrud.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Restaurant {
    private Long id;
    @NotBlank(message = "Name not found")
    private String name;
    private Address address;
    @NotBlank(message = "Gastronomy type not found")
    private String gastronomy = "Undefined";

    @NotNull(message = "Rating not found")
    private Integer rating;

    @NotNull(message = "Price not found")
    private Integer price;
    private String imageUrl;
    public Restaurant() {
    }

    public Restaurant(String name, Address address, String gastronomy, Integer rating, Integer price, String imageUrl) {
        this.name = name;
        this.address = address;
        this.gastronomy = gastronomy;
        this.rating = rating;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getGastronomy() {
        return gastronomy;
    }

    public void setGastronomy(String gastronomy) {
        this.gastronomy = gastronomy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

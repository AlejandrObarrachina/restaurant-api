package com.restaurantapi.restaurantcrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "Restaurant")
public class Restaurant {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @NotNull(message = "We need an address to save this restaurant")
    private Address address;
    private String gastronomy = "Undefined";
    @NotNull(message = "We need a rating to save this restaurant")
    private Integer rating;

    private Integer price;

    public Restaurant(){};

    public Restaurant(String name, Address address, String gastronomy, Integer rating, Integer price) {
        this.name = name;
        this.address = address;
        this.gastronomy = gastronomy;
        this.rating = rating;
        this.price = price;
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

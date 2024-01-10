package com.restaurantapi.restaurantcrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private Long id;
    @NotBlank(message = "We need a street to save this restaurant")

    private String street;
    private Integer number;
    private String city;
    private String postCode;

    public Address() {
    }

    public Address(String street, Integer number, String city, String postCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}

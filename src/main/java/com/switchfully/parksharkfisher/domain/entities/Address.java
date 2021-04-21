package com.switchfully.parksharkfisher.domain.entities;

import java.util.UUID;

public class Address {
    private UUID id;
    private String streetName;
    private String number;
    private String postalCode;
    private String city;

    public Address(String streetName, String number, String postalCode, String city) {
        this.id = UUID.randomUUID();
        this.streetName = streetName;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

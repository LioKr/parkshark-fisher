package com.switchfully.parksharkfisher.api.dtos;

import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.Category;
import com.switchfully.parksharkfisher.domain.entities.ContactPerson;
import com.switchfully.parksharkfisher.domain.entities.Division;

public class ParkingLotDTO {

    private int id;
    private String name;
    private int maxCapacity;
    private ContactPerson contactPerson;
    private Address address;
    private long price;
    private Category category;
    private Division division;

    public ParkingLotDTO() {
    }

    public Category getCategory() {
        return category;
    }

    public ParkingLotDTO setId(int id) {
        this.id = id;
        return this;
    }

    public ParkingLotDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ParkingLotDTO setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public ParkingLotDTO setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public ParkingLotDTO setAddress(Address address) {
        this.address = address;
        return this;
    }

    public ParkingLotDTO setPrice(long price) {
        this.price = price;
        return this;
    }

    public ParkingLotDTO setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Division getDivision() {
        return division;
    }

    public ParkingLotDTO setDivision(Division division) {
        this.division = division;
        return this;
    }

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }



    public int getMaxCapacity() {
        return maxCapacity;
    }



    public ContactPerson getContactPerson() {
        return contactPerson;
    }



    public Address getAddress() {
        return address;
    }



    public long getPrice() {
        return price;
    }


}

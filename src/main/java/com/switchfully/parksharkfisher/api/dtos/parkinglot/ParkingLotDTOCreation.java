package com.switchfully.parksharkfisher.api.dtos.parkinglot;

import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.Division;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.Category;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ContactPerson;

public class ParkingLotDTOCreation {

    private String name;
    private int maxCapacity;
    private ContactPerson contactPerson;
    private Address address;
    private long price;
    private Category category;
    private Division division;

    public ParkingLotDTOCreation() {
    }

    public Category getCategory() {
        return category;
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

    public Division getDivision() {
        return division;
    }

    public ParkingLotDTOCreation setDivision(Division division) {
        this.division = division;
        return this;
    }

    public ParkingLotDTOCreation setName(String name) {
        this.name = name;
        return this;
    }

    public ParkingLotDTOCreation setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public ParkingLotDTOCreation setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
        return this;
    }

    public ParkingLotDTOCreation setAddress(Address address) {
        this.address = address;
        return this;
    }

    public ParkingLotDTOCreation setPrice(long price) {
        this.price = price;
        return this;
    }

    public ParkingLotDTOCreation setCategory(Category category) {
        this.category = category;
        return this;
    }
}
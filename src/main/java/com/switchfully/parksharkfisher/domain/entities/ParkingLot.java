package com.switchfully.parksharkfisher.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parkinglots")
public class ParkingLot {
    private static int idCounter = 1;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "maxcapacity")
    private int maxCapacity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactperson_id", referencedColumnName = "id")
    private ContactPerson contactPerson;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;
    @Column(name = "price")
    private long price;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    public ParkingLot(String name, int maxCapacity, ContactPerson contactPerson, Address address, long price, Category category) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.price = price;
        this.category = category;
    }

    public ParkingLot() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final ParkingLot that = (ParkingLot) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

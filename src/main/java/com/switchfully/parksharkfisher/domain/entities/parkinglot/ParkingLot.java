package com.switchfully.parksharkfisher.domain.entities.parkinglot;

import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.Division;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parkinglots")
public class ParkingLot {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkinglot_seq")
    @SequenceGenerator(name = "parkinglot_seq", sequenceName = "parkinglot_seq", initialValue = 1, allocationSize = 1)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "maxcapacity")
    private int maxCapacity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactperson_id", referencedColumnName = "id")
    private ContactPerson contactPerson;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column(name = "price")
    private long price;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;
    @Column(name = "spots_in_use")
    private int spotsInUse;

    public ParkingLot(String name, int maxCapacity, ContactPerson contactPerson,
                      Address address, long price, Category category, Division division) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.price = price;
        this.category = category;
        this.division = division;
        this.spotsInUse = 0;
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

    public Division getDivision() {
        return division;
    }

    public ParkingLot setDivision(Division division) {
        this.division = division;
        return this;
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

    public int getSpotsInUse() {
        return spotsInUse;
    }

    public ParkingLot setSpotsInUse(int spotsInUse) {
        this.spotsInUse = spotsInUse;
        return this;
    }

    public boolean areThereFreeSpotsLeft() {
        return maxCapacity - spotsInUse > 0;
    }

    public void changeSpotsInUse(int changedAmount) {
        spotsInUse += changedAmount;
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

package com.switchfully.parksharkfisher.domain.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @Column(name = "id")
    private final UUID id;
    @Column(name = "firstname")
    private final String firstname;
    @Column(name = "lastname")
    private final String lastname;
    @Column(name = "phone_number")
    private final String phoneNumber;

    @ManyToOne()
    @JoinColumn(name = "id")
    private final Address address;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plate_number")
    private final LicensePlate licensePlate;


    @Column(name = "registrationDate")
    private final LocalDate registrationDate;

    public Member(String firstname, String lastname, String phoneNumber, Address address, LicensePlate licensePlate, LocalDate registrationDate) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}

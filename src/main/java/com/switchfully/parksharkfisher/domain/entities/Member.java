package com.switchfully.parksharkfisher.domain.entities;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_plate_platenumber", referencedColumnName = "plate_number")
    private LicensePlate licensePlate;
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public Member(String firstname, String lastname, String phoneNumber, Address address, LicensePlate licensePlate, LocalDate registrationDate) {
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }

    public Member() {
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

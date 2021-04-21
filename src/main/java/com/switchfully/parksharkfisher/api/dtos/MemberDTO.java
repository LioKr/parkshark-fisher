package com.switchfully.parksharkfisher.api.dtos;

import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.LicensePlate;

import java.time.LocalDate;
import java.util.UUID;

public class MemberDTO {
    private UUID id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private Address address;
    private LicensePlate licensePlate;
    private LocalDate registrationDate;

    public MemberDTO() {
    }

    public MemberDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public MemberDTO setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public MemberDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public MemberDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public MemberDTO setAddress(Address address) {
        this.address = address;
        return this;
    }

    public MemberDTO setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public MemberDTO setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
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

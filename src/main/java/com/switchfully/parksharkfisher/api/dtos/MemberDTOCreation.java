package com.switchfully.parksharkfisher.api.dtos;

import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.LicensePlate;
import com.switchfully.parksharkfisher.domain.entities.Membership;

import java.time.LocalDate;

public class MemberDTOCreation {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String mail;
    private Address address;
    private LicensePlate licensePlate;
    private LocalDate registrationDate;
    private Membership membership;

    public MemberDTOCreation() {
    }

    public MemberDTOCreation setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public MemberDTOCreation setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public MemberDTOCreation setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public MemberDTOCreation setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public MemberDTOCreation setAddress(Address address) {
        this.address = address;
        return this;
    }

    public MemberDTOCreation setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public MemberDTOCreation setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public MemberDTOCreation setMembership(Membership membership) {
        this.membership = membership;
        return this;
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

    public String getMail() {
        return mail;
    }

    public Membership getMembership() {
        return membership;
    }
}

package com.switchfully.parksharkfisher.api.dtos.member;

import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.member.LicensePlate;
import com.switchfully.parksharkfisher.domain.entities.member.Membership;

import java.time.LocalDate;
import java.util.UUID;

public class MemberDTO {
    private UUID id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String mail;
    private Address address;
    private LicensePlate licensePlate;
    private LocalDate registrationDate;
    private Membership membership;

    public MemberDTO() {
    }

    public String getMail() {
        return mail;
    }

    public MemberDTO setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public Membership getMembership() {
        return membership;
    }

    public MemberDTO setMembership(Membership membership) {
        this.membership = membership;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public MemberDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public MemberDTO setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public MemberDTO setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public MemberDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public MemberDTO setAddress(Address address) {
        this.address = address;
        return this;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public MemberDTO setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
        return this;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public MemberDTO setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }
}

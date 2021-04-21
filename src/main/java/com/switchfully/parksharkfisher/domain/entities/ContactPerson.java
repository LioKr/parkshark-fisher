package com.switchfully.parksharkfisher.domain.entities;

import java.util.UUID;

import org.apache.commons.validator.routines.EmailValidator;

public class ContactPerson {
    private UUID id;
    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String telephone;
    private String emailAdress;
    private Address address;


    public ContactPerson(String firstName, String lastName, String mobilePhone, String telephone, String emailAdress, Address address) {
        assertValidEmailAdress(emailAdress);
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.telephone = telephone;
        this.emailAdress = emailAdress;
        this.address = address;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private static void assertValidEmailAdress(String emailAdress) {
        if (emailAdress == null) {
            throw new IllegalArgumentException("Email adress is null");
        }
        if (!EmailValidator.getInstance().isValid(emailAdress)) {
            throw new IllegalArgumentException("Email address is invalid");
        }

    }
}

package com.switchfully.parksharkfisher.domain.entities.parkinglot;

import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.infrastructure.utils.MailAddressValidator;
import com.switchfully.parksharkfisher.infrastructure.utils.PhoneNumberValidator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "contactpersons")
public class ContactPerson {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "mobilephone")
    private String mobilePhone;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "emailaddress")
    private String emailAdress;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


    public ContactPerson() {
    }

    public ContactPerson(String firstName, String lastName, String mobilePhone, String telephone, String emailAdress, Address address) {
        MailAddressValidator.assertValidEmailAdress(emailAdress);
        PhoneNumberValidator.assertValidPhoneNumber(mobilePhone);
        PhoneNumberValidator.assertValidPhoneNumber(telephone);
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


}


package com.switchfully.parksharkfisher.domain.entities;


import com.switchfully.parksharkfisher.infrastructure.utils.MailAdressValidator;
import com.switchfully.parksharkfisher.infrastructure.utils.PhoneNumberValidator;

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
    @Column(name = "mail")
    private String mail;
    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_plate_platenumber", referencedColumnName = "plate_number")
    private LicensePlate licensePlate;
    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public Member(String firstname, String lastname, String phoneNumber, String mail, Address address, LicensePlate licensePlate, LocalDate registrationDate) {
        if (!validateInput(firstname, lastname, phoneNumber, mail, address, licensePlate, registrationDate))
            throw new IllegalArgumentException("Wrong argument provided");
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }

    private boolean validateInput(String firstname, String lastname, String phoneNumber, String mail, Address address, LicensePlate licensePlate, LocalDate registrationDate) {
        MailAdressValidator.assertValidEmailAdress(mail);
        PhoneNumberValidator.assertValidPhoneNumber(phoneNumber);
        if (firstname == null || firstname.isEmpty() || firstname.isBlank()) {
            return false;
        }
        if (lastname == null || lastname.isEmpty() || lastname.isBlank()) {
            return false;
        }
        if (address == null) {
            return false;
        }
        if (licensePlate == null) {
            return false;
        }


        return true;
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

    public String getMail() {
        return mail;
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

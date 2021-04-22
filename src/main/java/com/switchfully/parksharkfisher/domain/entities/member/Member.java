package com.switchfully.parksharkfisher.domain.entities.member;


import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.infrastructure.utils.MailAddressValidator;
import com.switchfully.parksharkfisher.infrastructure.utils.PhoneNumberValidator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
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
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_plate_platenumber", referencedColumnName = "plate_number")
    private LicensePlate licensePlate;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "membership")
    private Membership membership;

    public Member(String firstname, String lastname, String phoneNumber, String mail, Address address, LicensePlate licensePlate, LocalDate registrationDate, Membership membership) {
        validateInput(firstname, lastname, phoneNumber, mail, address, licensePlate, registrationDate);
        this.id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.address = address;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
        this.membership = Objects.requireNonNullElse(membership, Membership.BRONZE);
    }

    public Member() {
    }

    private void validateInput(String firstname, String lastname, String phoneNumber, String mail, Address address, LicensePlate licensePlate, LocalDate registrationDate) {
        MailAddressValidator.assertValidEmailAdress(mail);
        PhoneNumberValidator.assertValidPhoneNumber(phoneNumber);
        if (firstname == null) {
            throw new IllegalArgumentException("Wrong argument provided, firstname is null");
        }
        if (firstname.isEmpty() || firstname.isBlank()) {
            throw new IllegalArgumentException("Wrong argument provided, firstname is empty");
        }
        if (lastname == null) {
            throw new IllegalArgumentException("Wrong argument provided, lastname is null");
        }
        if (lastname.isEmpty() || lastname.isBlank()) {
            throw new IllegalArgumentException("Wrong argument provided, lastname is empty");
        }
        if (address == null) {
            throw new IllegalArgumentException("Wrong argument provided, address is null");
        }
        if (licensePlate == null) {
            throw new IllegalArgumentException("Wrong argument provided, licensePlate is null");
        }
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

    public Membership getMembership() {
        return membership;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

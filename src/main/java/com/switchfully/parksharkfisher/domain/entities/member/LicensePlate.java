package com.switchfully.parksharkfisher.domain.entities.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "license_plate")
public class LicensePlate {
    @Id
    @Column(name = "plate_number")
    private String licensePlateNumber;
    @Column(name = "issuing_country")
    private String issuingCountry;

    public LicensePlate() {
    }

    public LicensePlate(String licensePlateNumber, String issuingCountry) {
        this.licensePlateNumber = licensePlateNumber;
        this.issuingCountry = issuingCountry;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }


}

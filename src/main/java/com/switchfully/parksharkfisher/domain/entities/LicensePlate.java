package com.switchfully.parksharkfisher.domain.entities;

public class LicensePlate {
    private String licensePlateNumber;
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

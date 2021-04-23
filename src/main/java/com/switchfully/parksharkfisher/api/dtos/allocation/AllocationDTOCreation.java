package com.switchfully.parksharkfisher.api.dtos.allocation;

import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;

import java.time.LocalDate;

public class AllocationDTOCreation {

    private Member member;
    private ParkingLot parkingLot;
    private String licensePlateNumber;

    public AllocationDTOCreation() {
    }

    public Member getMember() {
        return member;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public AllocationDTOCreation setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
        return this;
    }

    public AllocationDTOCreation setMember(Member member) {
        this.member = member;
        return this;
    }

    public AllocationDTOCreation setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        return this;
    }
}

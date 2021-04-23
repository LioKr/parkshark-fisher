package com.switchfully.parksharkfisher.api.dtos.allocation;

import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;

import java.time.LocalDate;

public class AllocationDTOCreation {

    private LocalDate startTime;
    private LocalDate stopTime;
    private Member member;
    private ParkingLot parkingLot;

    public AllocationDTOCreation() {
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getStopTime() {
        return stopTime;
    }

    public Member getMember() {
        return member;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public AllocationDTOCreation setStartTime(LocalDate startTime) {
        this.startTime = startTime;
        return this;
    }

    public AllocationDTOCreation setStopTime(LocalDate stopTime) {
        this.stopTime = stopTime;
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

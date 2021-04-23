package com.switchfully.parksharkfisher.api.dtos.allocation;

import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;

import java.time.LocalDate;

public class AllocationDTO {
    private int id;
    private LocalDate startTime;
    private LocalDate stopTime;
    private Member member;
    private ParkingLot parkingLot;

    public AllocationDTO() {
    }

    public int getId() {
        return id;
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

    public AllocationDTO setId(int id) {
        this.id = id;
        return this;
    }

    public AllocationDTO setStartTime(LocalDate startTime) {
        this.startTime = startTime;
        return this;
    }

    public AllocationDTO setStopTime(LocalDate stopTime) {
        this.stopTime = stopTime;
        return this;
    }

    public AllocationDTO setMember(Member member) {
        this.member = member;
        return this;
    }

    public AllocationDTO setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        return this;
    }
}

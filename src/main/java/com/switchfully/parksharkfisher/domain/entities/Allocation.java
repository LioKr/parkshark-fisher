package com.switchfully.parksharkfisher.domain.entities;

import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "allocations")
public class Allocation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allocations_seq")
    @SequenceGenerator(name = "allocations_seq", sequenceName = "allocations_seq", initialValue = 1, allocationSize = 1)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    @ManyToOne(optional = false)
    @JoinColumn(name = "parkinglot_id", nullable = false)
    private ParkingLot parkingLot;
    @Column(name = "start_time")
    private LocalDate startTime;
    @Column(name = "stop_time")
    private LocalDate stopTime;

    public Allocation() {
    }

    public Allocation(Member member, ParkingLot parkingLot, LocalDate startTime, LocalDate stopTime) {
        this.member = member;
        this.parkingLot = parkingLot;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getStopTime() {
        return stopTime;
    }
}

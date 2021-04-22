package com.switchfully.parksharkfisher.domain.entities.membership;

public abstract class Membership {
    private int monthlyCost;
    private double parkingLotReduction;
    private int maxAllowedParkingTime;

    public Membership(int monthlyCost, double parkingLotReduction, int maxAllowedParkingTime) {
        this.monthlyCost = monthlyCost;
        this.parkingLotReduction = parkingLotReduction;
        this.maxAllowedParkingTime = maxAllowedParkingTime;
    }
}

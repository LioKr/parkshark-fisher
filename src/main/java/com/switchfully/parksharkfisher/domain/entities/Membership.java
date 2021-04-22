package com.switchfully.parksharkfisher.domain.entities;

public enum Membership {
    BRONZE(0, 0, 4),
    SILVER(10, 0.2, 6),
    GOLD(40, 0.3, 24);
    private double monthlyCost;
    private double parkingLotReduction;
    private int maxAllowedParkingTime;

    Membership(double monthlyCost, double parkingLotReduction, int maxAllowedParkingTime) {
        this.monthlyCost = monthlyCost;
        this.parkingLotReduction = parkingLotReduction;
        this.maxAllowedParkingTime = maxAllowedParkingTime;
    }

}

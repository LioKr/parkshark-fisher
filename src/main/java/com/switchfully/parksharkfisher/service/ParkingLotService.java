package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;

import java.util.List;

public interface ParkingLotService {
    ParkingLot save(ParkingLot parkingLot);


    List<ParkingLot> getAll();

    void toggleUsedSpot(ParkingLot parkingLot, int changedAmount);
}

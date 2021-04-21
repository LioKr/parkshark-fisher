package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.ParkingLot;

import java.util.List;

public interface ParkingLotService {
    ParkingLot save(ParkingLot parkingLot);


    List<ParkingLot> getAll();
}

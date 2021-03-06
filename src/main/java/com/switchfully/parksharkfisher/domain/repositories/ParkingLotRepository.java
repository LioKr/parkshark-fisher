package com.switchfully.parksharkfisher.domain.repositories;

import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, UUID> {


    ParkingLot getParkingLotsByName(String parkingName);
    ParkingLot getParkingLotById(int id);
}


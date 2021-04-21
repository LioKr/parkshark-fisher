package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.ParkingLot;
import com.switchfully.parksharkfisher.domain.repositories.ParkingLotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ParkingLotServiceImplementation implements ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;

    public ParkingLotServiceImplementation(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingLot save(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }
}

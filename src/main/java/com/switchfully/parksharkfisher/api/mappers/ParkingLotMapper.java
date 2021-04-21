package com.switchfully.parksharkfisher.api.mappers;

import com.switchfully.parksharkfisher.api.dtos.ParkingLotDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.ParkingLot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParkingLotMapper {
    private static final Logger logger = LoggerFactory.getLogger(ParkingLotMapper.class);


    public ParkingLot toEntity(ParkingLotDTOCreation parkingLotDTOCreation) {
        logger.info("Mapping ParkingLotDTOCreation to ParkingLotEntity");
        return new ParkingLot(parkingLotDTOCreation.getName(),
                parkingLotDTOCreation.getMaxCapacity(),
                parkingLotDTOCreation.getContactPerson(),
                parkingLotDTOCreation.getAddress(),
                parkingLotDTOCreation.getPrice(),
                parkingLotDTOCreation.getCategory());

    }


}

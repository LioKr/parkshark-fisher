package com.switchfully.parksharkfisher.api.mappers;

import com.switchfully.parksharkfisher.api.dtos.parkinglot.ParkingLotDTO;
import com.switchfully.parksharkfisher.api.dtos.parkinglot.ParkingLotDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingLotMapper {
    private static final Logger logger = LoggerFactory.getLogger(ParkingLotMapper.class);


    public ParkingLot toEntity(ParkingLotDTOCreation parkingLotDTOCreation) {
        logger.info("Mapping ParkingLotDTOCreation to ParkingLotEntity");
        return new ParkingLot(parkingLotDTOCreation.getName(),
                parkingLotDTOCreation.getMaxCapacity(),
                parkingLotDTOCreation.getContactPerson(),
                parkingLotDTOCreation.getAddress(),
                parkingLotDTOCreation.getPrice(),
                parkingLotDTOCreation.getCategory(),
                parkingLotDTOCreation.getDivision());

    }

    public ParkingLotDTO toDTO(ParkingLot parkingLot) {
        logger.info("Mapping ParkingLotEntity to ParkingLotDTOCreation");
        return new ParkingLotDTO().setName(parkingLot.getName())
                .setPrice(parkingLot.getPrice())
                .setAddress(parkingLot.getAddress())
                .setCategory(parkingLot.getCategory())
                .setId(parkingLot.getId())
                .setContactPerson(parkingLot.getContactPerson())
                .setMaxCapacity(parkingLot.getMaxCapacity())
                .setDivision(parkingLot.getDivision());
    }

    public List<ParkingLotDTO> toDTOList(List<ParkingLot> parkingLotList) {
        logger.info("Mapping ParkingLotEntity to List of ParkingLotDTOs");
        return parkingLotList.stream().map(this::toDTO).collect(Collectors.toList());
    }

}

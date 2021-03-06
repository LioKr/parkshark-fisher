package com.switchfully.parksharkfisher.api.controllers;



import com.switchfully.parksharkfisher.api.dtos.parkinglot.ParkingLotDTO;
import com.switchfully.parksharkfisher.api.dtos.parkinglot.ParkingLotDTOCreation;
import com.switchfully.parksharkfisher.api.mappers.ParkingLotMapper;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;
import com.switchfully.parksharkfisher.service.ParkingLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parkinglots")
public class ParkingLotController {
    private static final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);
    private final ParkingLotService parkingLotService;
    private final ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDTO createParkingLot(@RequestBody ParkingLotDTOCreation parkingLotDTOCreation) {
        logger.info("ParkingLot Created");
        ParkingLot parkingLot = parkingLotMapper.toEntity(parkingLotDTOCreation);
        return parkingLotMapper.toDTO(parkingLotService.save(parkingLot));

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingLotDTO> getAllParkingLots(){
        logger.info("Query for all parkinglots: ");
        return parkingLotMapper.toDTOList(parkingLotService.getAll());
    }


}

package com.switchfully.parksharkfisher.api.controllers;


import com.switchfully.parksharkfisher.api.dtos.ParkingLotDTO;
import com.switchfully.parksharkfisher.api.dtos.ParkingLotDTOCreation;
import com.switchfully.parksharkfisher.api.mappers.ParkingLotMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parkinglot")
public class ParkingLotController {
    private static final Logger logger = LoggerFactory.getLogger(ParkingLotController.class);
    private final ParkingLotService parkingLotService;
    private final ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }
@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDTO createParkingLot(@RequestBody ParkingLotDTOCreation parkingLotDTOCreation){


}

}

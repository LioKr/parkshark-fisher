package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.dtos.allocation.AllocationDTO;
import com.switchfully.parksharkfisher.api.dtos.allocation.AllocationDTOCreation;
import com.switchfully.parksharkfisher.api.mappers.AllocationMapper;
import com.switchfully.parksharkfisher.domain.entities.Allocation;
import com.switchfully.parksharkfisher.infrastructure.utils.AllocationValidator;
import com.switchfully.parksharkfisher.service.AllocationService;
import com.switchfully.parksharkfisher.service.ParkingLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {
    private static final Logger logger = LoggerFactory.getLogger(AllocationController.class);
    private final AllocationService allocationService;
    private final AllocationMapper allocationMapper;
    private final AllocationValidator allocationValidator;
    private final ParkingLotService parkingLotService;

    public AllocationController(AllocationService allocationService, AllocationMapper allocationMapper, AllocationValidator allocationValidator, ParkingLotService parkingLotService) {
        this.allocationService = allocationService;
        this.allocationMapper = allocationMapper;
        this.allocationValidator = allocationValidator;
        this.parkingLotService = parkingLotService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<AllocationDTO> getAllAllocations() {
        logger.info("Query for all Allocations: ");
        return allocationMapper.toDTOList(allocationService.getAll());

    }

    @PostMapping(path = "/start", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public AllocationDTO startAllocation(@RequestBody AllocationDTOCreation allocationDTOCreation) {
        logger.info("Parking spot allocation started: ");
       // allocationValidator.checkAllocation(allocationDTOCreation);
        Allocation allocation = allocationMapper.toEntity(allocationDTOCreation);
        Allocation savedAllocation = allocationService.save(allocation);
        parkingLotService.toggleUsedSpot(savedAllocation.getParkingLot(), 1);
        return allocationMapper.toDTO(savedAllocation);
    }

}

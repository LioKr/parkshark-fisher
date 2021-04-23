package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.mappers.AllocationMapper;
import com.switchfully.parksharkfisher.service.AllocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/allocations")
public class AllocationController {
    private static final Logger logger = LoggerFactory.getLogger(AllocationController.class);
    private final AllocationService allocationService;
    private final AllocationMapper allocationMapper;

    public AllocationController(AllocationService allocationService, AllocationMapper allocationMapper) {
        this.allocationService = allocationService;
        this.allocationMapper = allocationMapper;
    }
}

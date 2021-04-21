package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.dtos.DivisionDTO;
import com.switchfully.parksharkfisher.api.dtos.DivisionDTOCreation;
import com.switchfully.parksharkfisher.api.mappers.DivisionMapper;
import com.switchfully.parksharkfisher.domain.entities.Division;
import com.switchfully.parksharkfisher.service.DivisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/divisions")
public class DivisionController {
    private static final Logger logger = LoggerFactory.getLogger(DivisionController.class);
    private final DivisionService divisionService;
    private final DivisionMapper divisionMapper;

    @Autowired
    public DivisionController(DivisionService divisionService, DivisionMapper divisionMapper) {
        this.divisionService = divisionService;
        this.divisionMapper = divisionMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDTO createDivision(@RequestBody DivisionDTOCreation divisionDTOCreation) {
        logger.info("Division Created: ");
        Division division = divisionMapper.toEntity(divisionDTOCreation);
        return divisionMapper.toDTO(divisionService.save(division));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDTO> getAllDivisions(){
        logger.info("Query for all divisions: ");
        return divisionMapper.toDTOList(divisionService.getAll());
    }
}

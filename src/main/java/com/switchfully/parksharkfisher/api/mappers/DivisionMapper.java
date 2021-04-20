package com.switchfully.parksharkfisher.api.mappers;

import com.switchfully.parksharkfisher.api.dtos.DivisionDTO;
import com.switchfully.parksharkfisher.api.dtos.DivisionDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.Division;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DivisionMapper {
    private static final Logger logger = LoggerFactory.getLogger(DivisionMapper.class);


    public Division toEntity(DivisionDTOCreation divisionDTOCreation) {
        logger.info("Mapping DivisionDTOCreation to Division Entity");
        return new Division(divisionDTOCreation.getDivisionName(),
                divisionDTOCreation.getOriginalName(),
                divisionDTOCreation.getDirector());
    }

    public DivisionDTO toDTO(Division division) {
        logger.info("Mapping Division Entity to DivisionDTOCreation");
        return new DivisionDTO()
                .setDivisionName(division.getDivisionName())
                .setDirector(division.getDirector())
                .setOriginalName(division.getOriginalName())
                .setId(division.getId());

    }


}

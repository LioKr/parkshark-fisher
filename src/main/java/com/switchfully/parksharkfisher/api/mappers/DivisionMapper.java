package com.switchfully.parksharkfisher.api.mappers;

import com.switchfully.parksharkfisher.api.dtos.division.DivisionDTO;
import com.switchfully.parksharkfisher.api.dtos.division.DivisionDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.Division;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<DivisionDTO> toDTOList(List<Division> divisionList) {
        logger.info("Mapping Division Entity to List of DivisionDTO's");
        return divisionList.stream().map(this::toDTO).collect(Collectors.toList());
    }

}

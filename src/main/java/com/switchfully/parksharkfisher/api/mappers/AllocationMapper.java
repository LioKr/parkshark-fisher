package com.switchfully.parksharkfisher.api.mappers;

import com.switchfully.parksharkfisher.api.dtos.allocation.AllocationDTO;
import com.switchfully.parksharkfisher.api.dtos.allocation.AllocationDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.Allocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AllocationMapper {
    private static final Logger logger = LoggerFactory.getLogger(AllocationMapper.class);

    public Allocation toEntity(AllocationDTOCreation allocationDTOCreation) {
        logger.info("Mapping AllocationDTOCreation to Allocation entity");
        return new Allocation(allocationDTOCreation.getMember(),
                allocationDTOCreation.getParkingLot(),
                allocationDTOCreation.getStartTime(),
                allocationDTOCreation.getStopTime());
    }

    public AllocationDTO toDTO(Allocation allocation) {
        logger.info("Mapping AllocationEntity to AllocationDTOCreation");
        return new AllocationDTO().setMember(allocation.getMember())
                .setParkingLot(allocation.getParkingLot())
                .setStartTime(allocation.getStartTime())
                .setStopTime(allocation.getStopTime());
    }

    public List<AllocationDTO>toDTOList(List<Allocation>allocationList){
        logger.info("Mapping AllocationEntity to List of AllocationDTOs");
        return allocationList.stream().map(this::toDTO).collect(Collectors.toList());
    }
}

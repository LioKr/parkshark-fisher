package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.Allocation;

public interface AllocationService {
    Allocation save(Allocation allocation);
    //TODO need to add 1 to usedParkingspots !!
}

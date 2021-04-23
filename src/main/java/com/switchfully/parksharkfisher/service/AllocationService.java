package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.Allocation;

import java.util.List;

public interface AllocationService {
    Allocation save(Allocation allocation);

    List<Allocation> getAll();


}

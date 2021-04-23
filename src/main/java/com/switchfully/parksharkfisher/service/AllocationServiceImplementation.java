package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.Allocation;
import com.switchfully.parksharkfisher.domain.repositories.AllocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service

public class AllocationServiceImplementation implements AllocationService {
    private final AllocationRepository allocationRepository;

    public AllocationServiceImplementation(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    @Override
    public Allocation save(Allocation allocation) {
        return allocationRepository.save(allocation);
    }
}

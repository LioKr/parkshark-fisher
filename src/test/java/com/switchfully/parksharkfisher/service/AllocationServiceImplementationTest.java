package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.repositories.AllocationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AllocationServiceImplementationTest {
    @Mock
    private AllocationRepository allocationRepository;
    @InjectMocks
    private AllocationServiceImplementation allocationServiceImplementation;

    @Test
    void getAllAllocation_thenVerifyTheConnectionOfRepository() {
        allocationServiceImplementation.getAll();
        Mockito.verify(allocationRepository).findAll();

    }
}
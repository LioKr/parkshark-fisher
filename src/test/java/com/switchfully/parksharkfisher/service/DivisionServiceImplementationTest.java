package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.repositories.DivisionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DivisionServiceImplementationTest {

    @Mock
    private DivisionRepository divisionRepository;
    @InjectMocks
    private DivisionServiceImplementation divisionServiceImplementation;


    @Test
    void givenAddDivisionGetAddedDivision() {
        divisionServiceImplementation.save(any());
        Mockito.verify(divisionRepository).save(any());
    }

}
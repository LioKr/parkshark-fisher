package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.mappers.DivisionMapper;
import com.switchfully.parksharkfisher.service.DivisionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DivisionControllerTest {
    @Mock
    private DivisionService divisionService;
    @Mock
    private DivisionMapper divisionMapper;
    @InjectMocks
    private DivisionController divisionController;

    @Test
    void createDivision_GivenCorrectParameter_ThenReturnAddedDivision() {
        divisionController.createDivision(any());
        Mockito.verify(divisionService).save(any());
        Mockito.verify(divisionMapper).toDTO(any());

    }

}
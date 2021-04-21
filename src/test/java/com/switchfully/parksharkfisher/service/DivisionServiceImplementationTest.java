package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.Division;
import com.switchfully.parksharkfisher.domain.repositories.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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


    @Test
    void getAll() {
        //GIVEN
        List dummyEntityList = List.of(new Division("divNameTest", "orginalNameTest", "directorTest"),
                new Division("divNameTest1", "orginalNameTest1", "directorTest1"));
        Mockito.when(divisionRepository.findAll()).thenReturn(dummyEntityList);
        //WHEN
        List<Division> actual = divisionServiceImplementation.getAll();
        //THEN
        Assertions.assertThat(actual).isEqualTo(dummyEntityList);
    }
}
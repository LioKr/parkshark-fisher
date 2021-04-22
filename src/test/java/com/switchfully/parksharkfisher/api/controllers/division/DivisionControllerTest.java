package com.switchfully.parksharkfisher.api.controllers.division;

import com.switchfully.parksharkfisher.api.controllers.DivisionController;
import com.switchfully.parksharkfisher.api.dtos.division.DivisionDTO;
import com.switchfully.parksharkfisher.api.mappers.DivisionMapper;
import com.switchfully.parksharkfisher.domain.entities.Division;
import com.switchfully.parksharkfisher.service.DivisionService;
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

    @Test
    public void getAllDivisions_thenVerifyTheConnectionOfServiceAndMapper() {
        divisionController.getAllDivisions();
        Mockito.verify(divisionService).getAll();
        Mockito.verify(divisionMapper).toDTOList(any());
    }

    @Test
    public void getAllDivisions_whenGetAll_thenReturnListOfListOfDivisionDto() {
        //given
        List dummyEntityList = List.of(new Division("divNameTest", "orginalNameTest", "directorTest"),
                new Division("divNameTest1", "orginalNameTest1", "directorTest1"));
        List dummyDtoList = List.of(new DivisionDTO().setDivisionName("divNameDTOTest").setOriginalName("divNameDTOTest").setDirector("dirNameDtoTest"),
                new DivisionDTO().setDivisionName("divNameDTOTest,").setOriginalName("divNameDTOTest,").setDirector("dirNameDtoTest,"));
        Mockito.when(divisionService.getAll()).thenReturn(dummyEntityList);
        Mockito.when(divisionMapper.toDTOList(dummyEntityList)).thenReturn(dummyDtoList);
        //when
        List<DivisionDTO> actual = divisionController.getAllDivisions();
        //then
        Assertions.assertThat(actual).isEqualTo(dummyDtoList);
    }
}
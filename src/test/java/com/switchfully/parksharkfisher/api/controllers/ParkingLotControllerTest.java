package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.dtos.ParkingLotDTO;
import com.switchfully.parksharkfisher.api.mappers.ParkingLotMapper;
import com.switchfully.parksharkfisher.domain.entities.*;
import com.switchfully.parksharkfisher.service.ParkingLotService;
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
class ParkingLotControllerTest {
    @Mock
    private ParkingLotService parkingLotService;
    @Mock
    private ParkingLotMapper parkingLotMapper;
    @InjectMocks
    private ParkingLotController parkingLotController;

    @Test
    void createParkingLot_GivenCorrectParameters_ThenReturnAddedParkingLot() {
        parkingLotController.createParkingLot(any());
        Mockito.verify(parkingLotService).save(any());
        Mockito.verify(parkingLotMapper).toDTO(any());
    }

    @Test
    public void getAllParkingLots_thenVerifyTheConnectionOfServiceAndMapper() {
        parkingLotController.getAllParkingLots();
        Mockito.verify(parkingLotService).getAll();
        Mockito.verify(parkingLotMapper).toDTOList(any());
    }

    @Test
    public void getAllParkingLots_whenGetAll_thenReturnListOfParkingLotsDto() {
        Address address1 = new Address("Street", "2", "3200", "Leuven");
        ContactPerson person1 = new ContactPerson("Jos", "Peters", "04949494",
                "4567891", "jos.peters@gmail.com", address1);
        Division division1 = new Division("Div1","origName","GM");
        List dummyParkingLotsEntityList = List.of(new ParkingLot("Parking1", 50, person1, address1, 5L,
                Category.ABOVE_GROUND_BUILDING,division1));
        List dummyParkingLotsDTOList =
                List.of(new ParkingLotDTO().setName("Parking1")
                        .setPrice(5L)
                        .setAddress(address1)
                        .setCategory(Category.ABOVE_GROUND_BUILDING)
                        .setContactPerson(person1)
                        .setMaxCapacity(50)
                .setDivision(division1));
        Mockito.when(parkingLotService.getAll()).thenReturn(dummyParkingLotsEntityList);
        Mockito.when(parkingLotMapper.toDTOList(dummyParkingLotsEntityList)).thenReturn(dummyParkingLotsDTOList);
        List<ParkingLotDTO>actual = parkingLotController.getAllParkingLots();
        Assertions.assertThat(actual).isEqualTo(dummyParkingLotsDTOList);
    }
}
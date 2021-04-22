package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.*;
import com.switchfully.parksharkfisher.domain.repositories.ParkingLotRepository;
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
class ParkingLotServiceImplementationTest {
    @Mock
    private ParkingLotRepository parkingLotRepository;
    @InjectMocks
    private ParkingLotServiceImplementation parkingLotServiceImplementation;


    @Test
    void givenAddParkingLotGetAddedPArkingLot() {
        parkingLotServiceImplementation.save(any());
        Mockito.verify(parkingLotRepository).save(any());
    }


    @Test
    void getAll() {
        //GIVEN
        Address address1 = new Address("Street", "2", "3200", "Leuven");
        ContactPerson person1 = new ContactPerson("Jos", "Peters", "04949494",
                "4567891", "jos.peters@gmail.com", address1);
        Division division1 = new Division("Div1","origName","GM");
        List dummyParkingLotsEntityList = List.of(new ParkingLot("Parking1", 50, person1, address1, 5L,
                Category.ABOVE_GROUND_BUILDING,division1));
        Mockito.when(parkingLotRepository.findAll()).thenReturn(dummyParkingLotsEntityList);
        //WHEN
        List<ParkingLot> actual = parkingLotServiceImplementation.getAll();
        //THEN
        Assertions.assertThat(actual).isEqualTo(dummyParkingLotsEntityList);
    }

}
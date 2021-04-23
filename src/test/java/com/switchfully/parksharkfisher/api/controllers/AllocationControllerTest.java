package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.dtos.allocation.AllocationDTO;
import com.switchfully.parksharkfisher.api.mappers.AllocationMapper;
import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.Allocation;
import com.switchfully.parksharkfisher.domain.entities.Division;
import com.switchfully.parksharkfisher.domain.entities.member.LicensePlate;
import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.entities.member.Membership;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.Category;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ContactPerson;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;
import com.switchfully.parksharkfisher.service.AllocationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.assertj.core.api.Assertions;


import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AllocationControllerTest {
    @Mock
    private AllocationService allocationService;
    @Mock
    private AllocationMapper allocationMapper;
    @InjectMocks
    private AllocationController allocationController;

    @Test
    void getAllAllocation_thenVerifyTheConnectionOfServiceAndMapper() {
        allocationController.getAllAllocations();
        Mockito.verify(allocationService).getAll();
        Mockito.verify(allocationMapper).toDTOList(any());
    }

    @Test
    void getAllAllocation_thenReturnListOfAllocationDTO() {
        //given
        Address address1 = new Address("Street", "2", "3000", "Leuven");
        LicensePlate licensePlate1 = new LicensePlate("aaa111bbb", "Belgium");
        Member member1 = new Member("Jos", "Peters", "0494933494", "jos.peters@gmail.com", address1, licensePlate1, LocalDate.of(2020, 1, 1), Membership.BRONZE);
        ContactPerson person1 = new ContactPerson("Jos", "Peters", "04949494",
                "4567891", "jos.peters@gmail.com", address1);
        Division division1 = new Division("Div1", "origName", "GM");
        ParkingLot parkingLot1 = new ParkingLot("Parking1", 50, person1, address1, 5L,
                Category.ABOVE_GROUND_BUILDING, division1);

        List<Allocation> dummyAllocationEntityList = List.of(new Allocation(member1,
                parkingLot1,
                LocalDate.of(2020, 2, 1),
                LocalDate.of(2020, 2, 2)));
        List<AllocationDTO> dummyAllocationDTOList = List.of(new AllocationDTO()
                .setMember(member1)
                .setStartTime(LocalDate.of(2020, 2, 2))
                .setStopTime(LocalDate.of(2020, 2, 2))
                .setParkingLot(parkingLot1));
        //when
        Mockito.when(allocationService.getAll()).thenReturn(dummyAllocationEntityList);
        Mockito.when(allocationMapper.toDTOList(dummyAllocationEntityList)).thenReturn(dummyAllocationDTOList);
        List<AllocationDTO> actual = allocationController.getAllAllocations();

        //then
        Assertions.assertThat(actual).isEqualTo(dummyAllocationDTOList);


    }
}
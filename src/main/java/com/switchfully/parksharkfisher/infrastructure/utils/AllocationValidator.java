package com.switchfully.parksharkfisher.infrastructure.utils;

import com.switchfully.parksharkfisher.api.dtos.allocation.AllocationDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.entities.member.Membership;
import com.switchfully.parksharkfisher.domain.entities.parkinglot.ParkingLot;
import com.switchfully.parksharkfisher.domain.repositories.MemberRepository;
import com.switchfully.parksharkfisher.domain.repositories.ParkingLotRepository;
import org.springframework.stereotype.Component;

@Component
public class AllocationValidator {
    private final MemberRepository memberRepository;
    private final ParkingLotRepository parkingLotRepository;

    public AllocationValidator(MemberRepository memberRepository, ParkingLotRepository parkingLotRepository) {
        this.memberRepository = memberRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public void checkAllocation(AllocationDTOCreation allocationDTOCreation) {
        Member memberToCheck = memberRepository.getMemberById(allocationDTOCreation.getMember().getId());
        checkMemberExcists(memberToCheck);
        checkIfLicenscePlateMatches(allocationDTOCreation, memberToCheck);

        ParkingLot parkingLotToCheck = parkingLotRepository.getParkingLotById(allocationDTOCreation.getParkingLot().getId());
        checkParkingLotExcists(parkingLotToCheck);
        checkAvailableSpots(parkingLotToCheck);
    }

    private void checkAvailableSpots(ParkingLot parkingLotToCheck) {
        if (!parkingLotToCheck.areThereFreeSpotsLeft()) {
            throw new IllegalArgumentException("No more free spots left on the parking lot");
        }
    }

    private void checkParkingLotExcists(ParkingLot parkingLotToCheck) {
        if (parkingLotToCheck == null) {
            throw new IllegalArgumentException("The provided parking lot doesn't excist");
        }
    }

    private void checkIfLicenscePlateMatches(AllocationDTOCreation allocationDTOCreation, Member memberToCheck) {
        if (!(memberToCheck.getLicensePlate().getLicensePlateNumber().equals(allocationDTOCreation.getLicensePlateNumber())
                && memberToCheck.getMembership().equals(Membership.GOLD))) {
            throw new IllegalArgumentException("The provided license plate doesn't belong to this member");
        }
    }

    private void checkMemberExcists(Member memberToCheck) {
        if (memberToCheck == null) {
            throw new IllegalArgumentException("The provided member does not excist");
        }
    }
}

package com.switchfully.parksharkfisher.infrastructure.utils;

import com.switchfully.parksharkfisher.api.dtos.allocation.AllocationDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.member.Member;
import com.switchfully.parksharkfisher.domain.repositories.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class AllocationValidator {
    private final MemberRepository memberRepository;

    public AllocationValidator(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void checkAllocation(AllocationDTOCreation allocationDTOCreation) {
        //check member id
        Member check = memberRepository.getMemberById(allocationDTOCreation.getMember().getId());
        if (check == null) {
            throw new IllegalArgumentException("The provided member does not excist");
        }
        //check plate = member.plate

        //check parking lot
        //check capacity
    }
}

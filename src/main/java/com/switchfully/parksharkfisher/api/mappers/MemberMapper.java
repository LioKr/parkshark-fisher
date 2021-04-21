package com.switchfully.parksharkfisher.api.mappers;

import com.switchfully.parksharkfisher.api.dtos.MemberDTO;
import com.switchfully.parksharkfisher.api.dtos.MemberDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    private static final Logger logger = LoggerFactory.getLogger(MemberMapper.class);

    public Member toEntity(MemberDTOCreation memberDTOCreation) {
        logger.info("Mapping MemberDTOCreation to Member entity");
        return new Member(
                memberDTOCreation.getFirstname(),
                memberDTOCreation.getLastname(),
                memberDTOCreation.getPhoneNumber(),
                memberDTOCreation.getAddress(),
                memberDTOCreation.getLicensePlate(),
                memberDTOCreation.getRegistrationDate()
        );
    }

    public MemberDTO toDTO(Member member) {
        logger.info("Mapping Member entity to MemberDTOCreation");
        return new MemberDTO()
                .setId(member.getId())
                .setFirstname(member.getFirstname())
                .setLastname(member.getLastname())
                .setPhoneNumber(member.getPhoneNumber())
                .setAddress(member.getAddress())
                .setLicensePlate(member.getLicensePlate())
                .setRegistrationDate(member.getRegistrationDate());
    }
}

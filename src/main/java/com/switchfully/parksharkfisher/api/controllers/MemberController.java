package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.dtos.MemberDTO;
import com.switchfully.parksharkfisher.api.dtos.MemberDTOCreation;
import com.switchfully.parksharkfisher.api.mappers.MemberMapper;
import com.switchfully.parksharkfisher.domain.entities.Member;
import com.switchfully.parksharkfisher.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/members")
public class MemberController {
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
    private final MemberMapper memberMapper;
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberMapper memberMapper, MemberService memberService) {
        this.memberMapper = memberMapper;
        this.memberService = memberService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDTO createMember(@RequestBody MemberDTOCreation memberDTOCreation) {
        logger.info("Division Created: ");
        Member member = memberMapper.toEntity(memberDTOCreation);
        return memberMapper.toDTO(memberService.save(member));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDTO> getAllMembers() {
        logger.info("Query for all members");
        return memberMapper.toDTOList(memberService.getAll());
    }

}

package com.switchfully.parksharkfisher.api.controllers.member;

import com.switchfully.parksharkfisher.api.controllers.MemberController;
import com.switchfully.parksharkfisher.api.mappers.MemberMapper;
import com.switchfully.parksharkfisher.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MemberControllerTest {

    @Mock
    private MemberService memberService;
    @Mock
    private MemberMapper memberMapper;
    @InjectMocks
    private MemberController memberController;

    @Test
    void createMember_givenCorrectParameter_thenVerifyTheConnectionOfServiceAndMapper() {
        memberController.createMember(any());
        Mockito.verify(memberService).save(any());
        Mockito.verify(memberMapper).toDTO(any());
    }

    @Test
    void getAllMember_thenVerifyTheConnectionOfServiceAndMapper() {
        memberController.getAllMembers();
        Mockito.verify(memberService).getAll();
        Mockito.verify(memberMapper).toDTOList(any());
    }

}
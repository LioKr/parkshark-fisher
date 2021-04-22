package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MemberServiceImplementationTest {

    @Mock
    private MemberRepository memberRepository;
    @InjectMocks
    private MemberServiceImplementation memberServiceImplementation;

    @Test
    void createMember_givenCorrectParameter_thenVerifyTheConnectionOfServiceAndMapper() {
        memberServiceImplementation.save(any());
        Mockito.verify(memberRepository).save(any());
    }

}
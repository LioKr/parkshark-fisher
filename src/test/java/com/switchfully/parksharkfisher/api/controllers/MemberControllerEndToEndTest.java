package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.MyTestConfiguration;
import com.switchfully.parksharkfisher.api.dtos.MemberDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.LicensePlate;
import com.switchfully.parksharkfisher.domain.entities.Membership;
import com.switchfully.parksharkfisher.domain.repositories.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Import(MyTestConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class MemberControllerEndToEndTest {
    @LocalServerPort
    private int port;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void givenCorrectParameter_whenAddingMember_thenOneMoreIsPresent_webTestClient() {

        //GIVEN
        Address address1 = new Address("Street", "2", "3000", "Leuven");
        LicensePlate licensePlate1 = new LicensePlate("aaa111bbb", "Belgium");
        MemberDTOCreation memberDTOCreation = new MemberDTOCreation()
                .setFirstname("firstnameDummy")
                .setLastname("lastnameDummy")
                .setPhoneNumber("0032456000000")
                .setMail("fake@mail.com")
                .setAddress(address1)
                .setLicensePlate(licensePlate1)
                .setRegistrationDate(LocalDate.of(2020, 1, 1))
                .setMembership(Membership.GOLD);

        WebTestClient testClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();

        //WHEN
        WebTestClient.ResponseSpec response = testClient.post().uri("/members")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(memberDTOCreation), MemberDTOCreation.class)
                .exchange();

        //THEN
        response.expectStatus().isCreated();
        Assertions.assertThat(memberRepository.findAll())
                .contains(memberRepository.getMemberByMail("fake@mail.com"));


    }

}
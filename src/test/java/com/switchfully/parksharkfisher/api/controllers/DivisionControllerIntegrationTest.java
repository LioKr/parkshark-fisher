package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.MyTestConfiguration;
import com.switchfully.parksharkfisher.api.dtos.DivisionDTOCreation;
import com.switchfully.parksharkfisher.domain.repositories.DivisionRepository;
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

import static org.assertj.core.api.Assertions.assertThat;


@Import(MyTestConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class DivisionControllerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DivisionRepository divisionRepository;

    @Test
    void givenCorrectParameter_whenAddingDivision_thenOneMoreIsPresent_webTestClient() {
        //GIVEN
        WebTestClient testClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
        DivisionDTOCreation divisionDTOCreation = new DivisionDTOCreation()
                .setDivisionName("divisionName")
                .setOriginalName("originalName")
                .setDirector("director1");
        //WHEN
        WebTestClient.ResponseSpec response = testClient.post().uri("/divisions")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(divisionDTOCreation), DivisionDTOCreation.class)
                .exchange();
        //THEN
        response.expectStatus().isCreated();
        assertThat(divisionRepository.findAll())
                .contains(divisionRepository.getDivisionByDirector("director1"));
    }

}
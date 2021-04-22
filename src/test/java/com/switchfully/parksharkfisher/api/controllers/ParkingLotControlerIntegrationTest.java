package com.switchfully.parksharkfisher.api.controllers;

import com.switchfully.parksharkfisher.api.MyTestConfiguration;
import com.switchfully.parksharkfisher.api.dtos.ParkingLotDTOCreation;
import com.switchfully.parksharkfisher.domain.entities.Address;
import com.switchfully.parksharkfisher.domain.entities.Category;
import com.switchfully.parksharkfisher.domain.entities.ContactPerson;
import com.switchfully.parksharkfisher.domain.repositories.ParkingLotRepository;
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
public class ParkingLotControlerIntegrationTest {
    @LocalServerPort
    private int port;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    void givenCorrectParameter_whenAddingParkingLot_thenOneMoreIsPresent_webTestClient() {
        //GIVEN
        WebTestClient testClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
        Address address1 = new Address("Street", "2", "3000", "Leuven");
        Address address2 = new Address("Corner", "4", "3200", "Aarschot");
        ContactPerson person1 = new ContactPerson("Jos", "Peters", "04949494",
                "4567891", "jos.peters@gmail.com", address1);
        ParkingLotDTOCreation parkingLotDTOCreation = new ParkingLotDTOCreation()
                .setName("parkingName")
                .setMaxCapacity(50)
                .setPrice(5L)
                .setCategory(Category.ABOVE_GROUND_BUILDING)
                .setAddress(address2)
                .setContactPerson(person1);
        //WHEN
        WebTestClient.ResponseSpec response = testClient.post().uri("/parkinglots")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(parkingLotDTOCreation), ParkingLotDTOCreation.class)
                .exchange();
        //THEN
        response.expectStatus().isCreated();
        assertThat(parkingLotRepository.findAll())
                .contains(parkingLotRepository.getParkingLotsByName("parkingName"));
    }

}

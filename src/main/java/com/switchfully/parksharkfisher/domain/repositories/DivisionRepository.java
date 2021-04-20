package com.switchfully.parksharkfisher.domain.repositories;


import com.switchfully.parksharkfisher.domain.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DivisionRepository extends JpaRepository<Division, UUID> {


    Division getDivisionByDirector(String director);
}

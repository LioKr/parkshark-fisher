package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.Division;
import com.switchfully.parksharkfisher.domain.repositories.DivisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DivisionServiceImplementation implements DivisionService {
    private final DivisionRepository divisionRepository;

    public DivisionServiceImplementation(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    @Override
    public Division save(Division division) {
        return divisionRepository.save(division);
    }
}

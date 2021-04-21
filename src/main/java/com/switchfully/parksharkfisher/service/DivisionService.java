package com.switchfully.parksharkfisher.service;

import com.switchfully.parksharkfisher.domain.entities.Division;

import java.util.List;


public interface DivisionService {

    Division save(Division division);

    List<Division> getAll();
}

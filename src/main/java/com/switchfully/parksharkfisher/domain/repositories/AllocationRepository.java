package com.switchfully.parksharkfisher.domain.repositories;

import com.switchfully.parksharkfisher.domain.entities.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AllocationRepository extends JpaRepository<Allocation, UUID> {
}

package com.switchfully.parksharkfisher.api.dtos;

import java.util.UUID;

public class DivisionDTO {
    private String divisionName;
    private String originalName;
    private String director;
    private UUID id;

    public DivisionDTO() {
    }

    public String getDivisionName() {
        return divisionName;
    }

    public DivisionDTO setDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public DivisionDTO setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public DivisionDTO setDirector(String director) {
        this.director = director;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public DivisionDTO setId(UUID id) {
        this.id = id;
        return this;
    }
}

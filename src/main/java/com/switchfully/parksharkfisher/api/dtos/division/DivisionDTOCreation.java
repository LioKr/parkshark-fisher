package com.switchfully.parksharkfisher.api.dtos.division;

public class DivisionDTOCreation {
    private String divisionName;
    private String originalName;
    private String director;

    public DivisionDTOCreation() {
    }

    public String getDivisionName() {
        return divisionName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getDirector() {
        return director;
    }

    public DivisionDTOCreation setDivisionName(String divisionName) {
        this.divisionName = divisionName;
        return this;
    }

    public DivisionDTOCreation setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public DivisionDTOCreation setDirector(String director) {
        this.director = director;
        return this;
    }
}

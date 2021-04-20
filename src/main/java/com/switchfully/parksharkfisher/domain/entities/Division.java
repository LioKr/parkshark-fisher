package com.switchfully.parksharkfisher.domain.entities;


import java.util.UUID;

public class Division {
    private final String divisionName;
    private final String originalName;
    private final String director;
    private final UUID id;

    public Division(String divisionName, String originalName, String director) {
        this.divisionName = divisionName;
        this.originalName = originalName;
        this.director = director;
        this.id = UUID.randomUUID();
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

    public UUID getId() {
        return id;
    }
}

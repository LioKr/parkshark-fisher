package com.switchfully.parksharkfisher.domain.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "divisions")
public class Division {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "division_name")
    private String divisionName;
    @Column(name = "original_name")
    private String originalName;
    @Column(name = "director")
    private String director;

    public Division() {
    }

    public Division(String divisionName, String originalName, String director) {
        this.divisionName = divisionName;
        this.originalName = originalName;
        this.director = director;
        this.id = UUID.randomUUID();
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

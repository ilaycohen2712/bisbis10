package com.att.tdp.bisbis10.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Set;

@Entity
public class Restaurant {

    @Id @GeneratedValue
    Long id;
    String name;
    @JsonProperty("averageRating")
    Double averageRating;

    @JsonProperty("isKosher")
    Boolean isKosher;

    @ElementCollection
    Set<String> cuisines;
    public Restaurant() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return averageRating;
    }

    public void setRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Boolean getKosher() {
        return isKosher;
    }

    public void setKosher(Boolean iskosher) {
        this.isKosher = iskosher;
    }

    public Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }
}

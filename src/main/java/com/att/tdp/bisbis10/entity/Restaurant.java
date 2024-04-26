package com.att.tdp.bisbis10.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Restaurant {

    @Id @GeneratedValue
    Long id;
    String name;

    Double averageRating;

    Boolean isKosher;
    @ElementCollection
    Set<String> cuisines;

    @OneToMany(mappedBy = "restaurant")
    List<Dish> dishesList;
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

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Boolean getIsKosher() {
        return isKosher;
    }

    public void setIsKosher(Boolean iskosher) {
        this.isKosher = iskosher;
    }

    public Set<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(Set<String> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Dish> getDishesList() {
        return dishesList;
    }

    public void setDishesList(List<Dish> dishesList) {
        this.dishesList = dishesList;
    }
}

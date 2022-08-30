package com.example.springintroapp.models.services;

import javax.persistence.Column;
import java.time.LocalDate;

public class ExerciseServiceModel {

    private Long id;
    private String name;
    private LocalDate startedOn;
    private LocalDate dueDAte;

    public ExerciseServiceModel() {
    }

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

    public LocalDate getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDate startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDate getDueDAte() {
        return dueDAte;
    }

    public void setDueDAte(LocalDate dueDAte) {
        this.dueDAte = dueDAte;
    }
}

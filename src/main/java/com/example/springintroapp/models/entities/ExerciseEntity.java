package com.example.springintroapp.models.entities;

import org.springframework.data.auditing.DateTimeProvider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "exercises")
public class ExerciseEntity extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "started_on")
    private LocalDate startedOn;
    @Column(name = "due_date")
    private LocalDate dueDAte;

    public ExerciseEntity() {
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

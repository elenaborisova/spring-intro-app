package com.example.springintroapp.models.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "homeworks")
public class HomeworkEntity extends BaseEntity {
    @Column(name = "added_on")
    private LocalDateTime addedOn;
    @Column(name = "git_address")
    private String gitAddress;
    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private ExerciseEntity exercise;

    public HomeworkEntity() {
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public ExerciseEntity getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseEntity exercise) {
        this.exercise = exercise;
    }
}

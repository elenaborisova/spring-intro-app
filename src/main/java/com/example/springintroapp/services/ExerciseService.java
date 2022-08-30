package com.example.springintroapp.services;

import com.example.springintroapp.models.entities.ExerciseEntity;
import com.example.springintroapp.models.services.ExerciseServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {
    void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllNames();

    boolean checkIsLate(String exercise);

    ExerciseEntity findByName(String name);
}

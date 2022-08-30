package com.example.springintroapp.services;

import com.example.springintroapp.models.services.ExerciseServiceModel;
import org.springframework.stereotype.Service;

public interface ExerciseService {
    void addExercise(ExerciseServiceModel exerciseServiceModel);
}

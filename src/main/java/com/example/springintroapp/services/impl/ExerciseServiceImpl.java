package com.example.springintroapp.services.impl;

import com.example.springintroapp.models.entities.ExerciseEntity;
import com.example.springintroapp.models.services.ExerciseServiceModel;
import com.example.springintroapp.repositories.ExerciseRepository;
import com.example.springintroapp.services.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        exerciseRepository.save(
                modelMapper.map(exerciseServiceModel, ExerciseEntity.class)
        );
    }
}

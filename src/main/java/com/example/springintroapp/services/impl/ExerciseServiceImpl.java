package com.example.springintroapp.services.impl;

import com.example.springintroapp.models.entities.ExerciseEntity;
import com.example.springintroapp.models.services.ExerciseServiceModel;
import com.example.springintroapp.repositories.ExerciseRepository;
import com.example.springintroapp.services.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<String> findAllNames() {
        return exerciseRepository.findAllNames();
    }

    @Override
    public boolean checkIsLate(String exercise) {
        ExerciseEntity exerciseEntity = exerciseRepository
                .findByName(exercise)
                .orElse(null);

        return exerciseEntity
                .getDueDate()
                .isBefore(ChronoLocalDate.from(LocalDateTime.now()));
    }

    @Override
    public ExerciseEntity findByName(String name) {
        return exerciseRepository
                .findByName(name)
                .orElse(null);
    }
}

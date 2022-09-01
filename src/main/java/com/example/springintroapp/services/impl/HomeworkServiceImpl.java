package com.example.springintroapp.services.impl;

import com.example.springintroapp.models.entities.HomeworkEntity;
import com.example.springintroapp.models.services.HomeworkServiceModel;
import com.example.springintroapp.repositories.HomeworkRepository;
import com.example.springintroapp.security.CurrentUser;
import com.example.springintroapp.services.ExerciseService;
import com.example.springintroapp.services.HomeworkService;
import com.example.springintroapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExerciseService exerciseService, CurrentUser currentUser, UserService userService, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {
        HomeworkEntity homework = new HomeworkEntity();
        homework.setGitAddress(gitAddress);
        homework.setAddedOn(LocalDateTime.now());
        homework.setExercise(exerciseService.findByName(exercise));
        homework.setAuthor(userService.findById(currentUser.getId()));

        homeworkRepository.save(homework);
    }

    @Override
    public HomeworkServiceModel findHomeworkForGrading() {
        return homeworkRepository
                .findTop1ByOrderByCommentsSet()
                .map(homework -> modelMapper.map(homework, HomeworkServiceModel.class))
                .orElse(null);
    }

    @Override
    public HomeworkEntity findById(Long homeworkId) {
        return homeworkRepository
                .findById(homeworkId)
                .orElse(null);
    }
}

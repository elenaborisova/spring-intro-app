package com.example.springintroapp.services;

import com.example.springintroapp.models.entities.HomeworkEntity;
import com.example.springintroapp.models.services.HomeworkServiceModel;
import org.springframework.stereotype.Service;

public interface HomeworkService {
    void addHomework(String exercise, String gitAddress);

    HomeworkServiceModel findHomeworkForGrading();

    HomeworkEntity findById(Long homeworkId);
}


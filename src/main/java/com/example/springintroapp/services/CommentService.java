package com.example.springintroapp.services;

import com.example.springintroapp.models.services.CommentServiceModel;

import java.util.List;
import java.util.Map;

public interface CommentService {
    void add(CommentServiceModel commentServiceModel, Long homeworkId);

    List<String> findTopStudentsByAvgScore();

    Double findAvgScore();

    Map<Integer, Integer> findScoreMap();
}


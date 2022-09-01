package com.example.springintroapp.services;

import com.example.springintroapp.models.services.CommentServiceModel;

public interface CommentService {
    void add(CommentServiceModel commentServiceModel, Long homeworkId);
}


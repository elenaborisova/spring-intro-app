package com.example.springintroapp.services.impl;

import com.example.springintroapp.models.entities.CommentEntity;
import com.example.springintroapp.models.services.CommentServiceModel;
import com.example.springintroapp.repositories.CommentRepository;
import com.example.springintroapp.security.CurrentUser;
import com.example.springintroapp.services.CommentService;
import com.example.springintroapp.services.HomeworkService;
import com.example.springintroapp.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final HomeworkService homeworkService;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, CurrentUser currentUser, HomeworkService homeworkService, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.currentUser = currentUser;
        this.homeworkService = homeworkService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(CommentServiceModel commentServiceModel, Long homeworkId) {
        CommentEntity commentEntity = modelMapper
                .map(commentServiceModel, CommentEntity.class);

        commentEntity.setAuthor(userService.findById(currentUser.getId()));
        commentEntity.setHomework(homeworkService.findById(homeworkId));

        commentRepository.save(commentEntity);
    }
}

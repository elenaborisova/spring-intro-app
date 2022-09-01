package com.example.springintroapp.web.controllers;

import com.example.springintroapp.security.CurrentUser;
import com.example.springintroapp.services.CommentService;
import com.example.springintroapp.services.ExerciseService;
import com.example.springintroapp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ExerciseService exerciseService;
    private final CommentService commentService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, ExerciseService exerciseService, CommentService commentService, UserService userService) {
        this.currentUser = currentUser;
        this.exerciseService = exerciseService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {

        if (currentUser.isAnonymous()) {
            return "index";
        }

        model.addAttribute("exercises", exerciseService.findAllNames());
        model.addAttribute("students", commentService.findTopStudentsByAvgScore());
        model.addAttribute("avg", commentService.findAvgScore());
        model.addAttribute("usersCount", userService.findUsersCount());
        model.addAttribute("scoreMap", commentService.findScoreMap());

        return "home";
    }
}

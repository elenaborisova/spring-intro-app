package com.example.springintroapp.web.controllers;

import com.example.springintroapp.models.binding.CommentAddBindingModel;
import com.example.springintroapp.models.services.CommentServiceModel;
import com.example.springintroapp.models.views.HomeworkViewModel;
import com.example.springintroapp.services.CommentService;
import com.example.springintroapp.services.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final HomeworkService homeworkService;
    private final ModelMapper modelMapper;
    private final CommentService commentService;

    public CommentController(HomeworkService homeworkService, ModelMapper modelMapper, CommentService commentService) {
        this.homeworkService = homeworkService;
        this.modelMapper = modelMapper;
        this.commentService = commentService;
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("commentAddBindingModel")) {
            model.addAttribute("commentAddBindingModel", new CommentAddBindingModel());
        }

        HomeworkViewModel homeworkViewModel = modelMapper.map(
                homeworkService.findHomeworkForGrading(), HomeworkViewModel.class);

        model.addAttribute("homeworkViewModel", homeworkViewModel);

        return "homework-check";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute CommentAddBindingModel commentAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("commentAddBindingModel", commentAddBindingModel);
            redirectAttributes.addAttribute(
                    "org.springframework.validation.BindingResult.commentAddBindingModel", bindingResult);

            return "redirect:add";
        }

        CommentServiceModel commentServiceModel = modelMapper
                .map(commentAddBindingModel, CommentServiceModel.class);

        commentService.add(commentServiceModel, commentAddBindingModel.getHomeworkId());


        return "redirect:/";

    }

}

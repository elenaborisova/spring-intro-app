package com.example.springintroapp.web.controllers;

import com.example.springintroapp.models.binding.ExerciseAddBindingModel;
import com.example.springintroapp.models.services.ExerciseServiceModel;
import com.example.springintroapp.services.ExerciseService;
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
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    public ExerciseController(ExerciseService exerciseService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("exerciseBindingModel")) {
            model.addAttribute("exerciseBindingModel", new ExerciseAddBindingModel());
        }

        return "exercise-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute ExerciseAddBindingModel exerciseBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("exerciseBindingModel", exerciseBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.exerciseBindingModel",
                    bindingResult);
            return "redirect:add";
        }

        exerciseService.addExercise(
                modelMapper.map(exerciseBindingModel, ExerciseServiceModel.class));

        return "redirect:/";
    }
}

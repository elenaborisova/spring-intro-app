package com.example.springintroapp.web.controllers;

import com.example.springintroapp.models.binding.HomeworkBindingModel;
import com.example.springintroapp.services.ExerciseService;
import com.example.springintroapp.services.HomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    private final ExerciseService exerciseService;
    private final HomeworkService homeworkService;

    public HomeworkController(ExerciseService exerciseService, HomeworkService homeworkService) {
        this.exerciseService = exerciseService;
        this.homeworkService = homeworkService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("homeworkBindingModel")) {
            model.addAttribute("homeworkBindingModel", new HomeworkBindingModel());
            model.addAttribute("isLate", false);
        }

        model.addAttribute("exerciseNames", exerciseService.findAllNames());
        return "homework-add";
    }

    @GetMapping("/add")
    public String addConfirm(@Valid @ModelAttribute HomeworkBindingModel homeworkBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homeworkBindingModel", homeworkBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.homeworkBindingModel",
                    bindingResult);

            return "redirect:add";
        }

        boolean isLate = exerciseService.checkIsLate(
                homeworkBindingModel.getExercise());

        if (isLate) {
            redirectAttributes.addFlashAttribute("homeworkBindingModel", homeworkBindingModel);
            redirectAttributes.addFlashAttribute("isLate", true);
        }

        homeworkService
                .addHomework(homeworkBindingModel.getExercise(),
                        homeworkBindingModel.getGitAddress());

        return "redirect:/";
    }

}

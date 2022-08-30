package com.example.springintroapp.models.binding;


import javax.validation.constraints.Pattern;

public class HomeworkBindingModel {

    private String exercise;
    private String gitAddress;

    public HomeworkBindingModel() {
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    @Pattern(regexp = "https:\\/\\/github\\.com\\/.+",
            message = "Enter a valid GitHub address")
    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }
}

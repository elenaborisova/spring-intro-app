package com.example.springintroapp.models.entities;

import org.apache.catalina.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity{
    @Column(name = "score")
    private Integer score;
    @Column(name = "text_content", columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private HomeworkEntity homework;

    public CommentEntity() {
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public HomeworkEntity getHomework() {
        return homework;
    }

    public void setHomework(HomeworkEntity homework) {
        this.homework = homework;
    }
}

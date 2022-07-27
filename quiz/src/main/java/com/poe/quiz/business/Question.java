package com.poe.quiz.business;

import java.util.ArrayList;

public class Question {
    
    private Long id;
    private String title;
    
    private ArrayList<Answer> answers = new ArrayList<>();

    
    public Question() {
    }
    
    public Question(String title) {
        this.title = title;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
    
    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", title=" + title + ", answers=" + answers + '}';
    }
    
    
    
    
}

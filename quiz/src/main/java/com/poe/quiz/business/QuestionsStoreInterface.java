package com.poe.quiz.business;

import java.util.ArrayList;


public interface QuestionsStoreInterface {
    
    public void addQuestion(Question question, Answer[] answers);
    public ArrayList<Question> getQuestions();
    
}

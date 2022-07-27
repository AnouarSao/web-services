package com.poe.quiz.business;

import java.util.ArrayList;

public class QuestionsStore implements QuestionsStoreInterface {
    
     private ArrayList<Question> questions = new ArrayList<>();
     private Long questionIndex = 0L;
     private Long answerIndex = 0L;
     
     
   
     public void addQuestion(Question question, Answer[] answers){
         
         questionIndex++;
         question.setId(questionIndex);
         questions.add(question);
         
         for(int i=0; i<answers.length ; i++){
             answerIndex++;
             answers[i].setId(answerIndex);
             question.addAnswer(answers[i]);
         }
     }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}

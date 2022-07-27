package com.poe.quiz.business;

import java.util.ArrayList;

public class Game {
    
    private QuestionsStoreInterface store = new QuestionsStore();

    public QuestionsStoreInterface getStore() {
        return store;
    }
    
    public Game() {
        
        Question question1 = new Question("Qui est le chanteur du groupe Queen ?");
        Answer[] answers = { new Answer("Mick Jagger", false), 
                             new Answer("Freddie Mercury", true),
                             new Answer("Claude François", false)   };

        store.addQuestion(question1, answers);
    }
    
    
    public boolean validateAnswer(Long questionId, Long answerId){
        
        for(Question question : store.getQuestions()){
            if(question.getId().equals(questionId)){
                for(Answer answer : question.getAnswers()){
                    if(answer.getId().equals(answerId)){
                        return answer.isCorrectAnswer();
                    }
                }
            }
        }
        return false;
    }
    
}

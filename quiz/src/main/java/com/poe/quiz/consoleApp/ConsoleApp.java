package com.poe.quiz.consoleApp;

import com.poe.quiz.business.Answer;
import com.poe.quiz.business.Game;
import com.poe.quiz.business.Question;
import java.util.Scanner;

public class ConsoleApp {
    
    public static void main(String[] args){
        System.out.println("Jeu Quiz");
        
        Scanner clavier = new Scanner(System.in);
        
        Game game = new Game();
        for(Question question : game.getStore().getQuestions()){
            System.out.println("Question : "+question.getTitle());
            System.out.println("Choisissez une réponse:");
            
            for(Answer answer : question.getAnswers()){
                System.out.println(""+answer.getId()+" "+answer.getTitle());
            }
         
          
            System.out.println("Tapez votre choix");
            Long playerAnswer = clavier.nextLong();

            boolean win = game.validateAnswer(question.getId(), playerAnswer);
            
            if(win == true){
                System.out.println("Bonne réponse");
            }
            else {
                System.out.println("Mauvaise réponse");
            }
        }
    }
}

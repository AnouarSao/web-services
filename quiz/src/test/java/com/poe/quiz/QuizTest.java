package com.poe.quiz;

import com.poe.quiz.business.Game;
import org.junit.Assert;
import org.junit.Test;

public class QuizTest {
    
    @Test
    public void testValidateAnswer() {
        
        Game game = new Game();
        Assert.assertFalse(game.validateAnswer(1L, 1L));
        Assert.assertTrue(game.validateAnswer(1L, 2L));
    }
    
}

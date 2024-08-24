package com.dvc.wordle.WordleApp;

import com.dvc.wordle.WordleApp.service.GameEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class GameEngineTest {
    @Autowired
    private GameEngine gameEngine;

    @Test
    void testGameFlow() {
        gameEngine.startNewGame();
        String result = String.valueOf(gameEngine.makeGuess("wrong"));
        assertFalse(result.contains("Correct"));
        assertFalse(result.contains("Game over"));
    }

    @Test
    void testGameStatistics() {
        gameEngine.startNewGame();
        gameEngine.makeGuess("right");
//        assertEquals(1, gameEngine.getGamesPlayed());
//        assertEquals(1, gameEngine.getGamesWon());
//        assertEquals(100, gameEngine.getAverageScore(), 0.01);
    }
}
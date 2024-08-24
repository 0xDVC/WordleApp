package com.dvc.wordle.WordleApp;

import com.dvc.wordle.WordleApp.service.ScoreEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ScoreEngineTest {
    @Autowired
    private ScoreEngine scoreEngine;

    @Test
    void testCalculateScore() {
        assertEquals(100, scoreEngine.calculateScore(1), 0.01);
        assertEquals(83.33, scoreEngine.calculateScore(2), 0.01);
        assertEquals(0, scoreEngine.calculateScore(7), 0.01);
    }
}
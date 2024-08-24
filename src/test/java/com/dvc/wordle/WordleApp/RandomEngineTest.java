package com.dvc.wordle.WordleApp;

import com.dvc.wordle.WordleApp.service.RandomEngine;
import com.dvc.wordle.WordleApp.service.WordChecker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RandomEngineTest {
    @Autowired
    private RandomEngine randomEngine;
    @Autowired
    private WordChecker wordChecker;

    @Test
    void testGetRandomWord() {
        String randomWord = randomEngine.getRandomWord();
        assertNotNull(randomWord);
        assertTrue(wordChecker.isValidWord(randomWord));
    }
}
package com.dvc.wordle.WordleApp;

import com.dvc.wordle.WordleApp.service.WordChecker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WordCheckerTest {
    @Autowired
    private WordChecker wordChecker;

    @Test
    void testValidWord() {
        assertTrue(wordChecker.isValidWord("valid"));
        assertFalse(wordChecker.isValidWord("invalidword"));
    }
}
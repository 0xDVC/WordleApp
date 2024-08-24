package com.dvc.wordle.WordleApp.service;

import org.springframework.stereotype.Component;

@Component
public class ScoreEngine {
    private static final int MAX_ATTEMPTS = 6;
    private static final int MAX_SCORE = 100;

    public int calculateScore(int attempts) {
        if (attempts > MAX_ATTEMPTS) {
            return 0;
        }
        return MAX_SCORE - ((attempts - 1) * (MAX_SCORE / MAX_ATTEMPTS));
    }
}
package com.dvc.wordle.WordleApp.service;

import com.dvc.wordle.WordleApp.model.GameState;
import com.dvc.wordle.WordleApp.model.GuessResult;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GameEngine {
    private static final Logger logger = LoggerFactory.getLogger(GameEngine.class);
    private final WordChecker wordChecker;
    private final RandomEngine randomEngine;
    private final ScoreEngine scoreEngine;

    private String currentWord;
    private int attempts;
    private boolean gameWon;

    public GameEngine(WordChecker wordChecker, RandomEngine randomEngine, ScoreEngine scoreEngine) {
        this.wordChecker = wordChecker;
        this.randomEngine = randomEngine;
        this.scoreEngine = scoreEngine;
    }

    public void startNewGame() {
        currentWord = randomEngine.getRandomWord();
        attempts = 0;
        gameWon = false;
        logger.info("New game started with word: {}", currentWord);
    }

    public GuessResult makeGuess(String guess) {
        if (gameWon || attempts >= 6) {
            logger.warn("Attempt to guess after game ended");
            return new GuessResult(false, new char[5], "Game already ended", scoreEngine.calculateScore(attempts));
        }

        attempts++;
        if (!wordChecker.isValidWord(guess)) {
            logger.info("Invalid word guessed: {}", guess);
            return new GuessResult(false, new char[5], "Invalid word", scoreEngine.calculateScore(attempts));
        }

        char[] result = new char[5];
        for (int i = 0; i < 5; i++) {
            if (guess.charAt(i) == currentWord.charAt(i)) {
                result[i] = 'G'; // Green
            } else if (currentWord.contains(String.valueOf(guess.charAt(i)))) {
                result[i] = 'Y'; // Yellow
            } else {
                result[i] = 'R'; // Red (or gray)
            }
        }

        gameWon = String.valueOf(result).equals("GGGGG");
        if (gameWon) {
            logger.info("Game won in {} attempts", attempts);
        } else if (attempts == 6) {
            logger.info("Game lost. Word was: {}", currentWord);
        }

        int score = scoreEngine.calculateScore(attempts);
        return new GuessResult(gameWon, result, gameWon ? "Correct!" : (attempts == 6 ? "Game Over" : ""), score);
    }

    public GameState getGameState() {
        return new GameState(attempts, gameWon, currentWord);
    }
}
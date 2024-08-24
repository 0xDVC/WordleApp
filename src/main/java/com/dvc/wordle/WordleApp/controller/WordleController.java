package com.dvc.wordle.WordleApp.controller;

import com.dvc.wordle.WordleApp.model.GameState;
import com.dvc.wordle.WordleApp.model.GuessResult;
import com.dvc.wordle.WordleApp.service.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/game")
public class WordleController {
    private final GameEngine gameEngine;

    @Autowired
    public WordleController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @PostMapping("/start")
    public ResponseEntity<GameState> startNewGame() {
        gameEngine.startNewGame();
        return ResponseEntity.ok(gameEngine.getGameState());
    }

    @PostMapping("/guess")
    public ResponseEntity<GuessResult> makeGuess(@RequestBody String guess) {
        return ResponseEntity.ok(gameEngine.makeGuess(guess));
    }

    @GetMapping("/state")
    public ResponseEntity<GameState> getGameState() {
        return ResponseEntity.ok(gameEngine.getGameState());
    }
}
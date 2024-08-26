package com.dvc.wordle.WordleApp.model;


public record GameState(int attempts, boolean gameWon, String currentWord) {
}

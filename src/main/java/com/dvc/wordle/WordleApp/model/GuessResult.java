package com.dvc.wordle.WordleApp.model;



public record GuessResult(boolean correct, char[] pattern, String message, int score) {
}
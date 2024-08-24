package com.dvc.wordle.WordleApp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GameState {
    private final int attempts;
    private final boolean gameWon;
    private final String currentWord;
}

package com.dvc.wordle.WordleApp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GuessResult {
    private final boolean correct;
    private final char[] pattern;
    private final String message;
    private final int score;
}
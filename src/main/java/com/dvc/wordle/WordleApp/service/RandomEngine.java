package com.dvc.wordle.WordleApp.service;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class RandomEngine {
    private final List<String> words;
    private final Random random;

    public RandomEngine(WordChecker wordChecker) {
        this.words = wordChecker.getValidWords().stream()
                .filter(word -> word.length() == 5)
                .collect(Collectors.toList());
        this.random = new Random();
    }

    public String getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }
}
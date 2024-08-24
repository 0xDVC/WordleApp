package com.dvc.wordle.WordleApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class WordChecker {
    private final Set<String> validWords;
    @Value("${wordle.word.source}")
    private String wordListPath;

    public WordChecker() {
        validWords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(getClass().getResourceAsStream(wordListPath))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                validWords.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load word list", e);
        }
    }

    public boolean isValidWord(String word) {
        return validWords.contains(word.toLowerCase());
    }

    public Collection<String> getValidWords() {
        return validWords;
    }
}
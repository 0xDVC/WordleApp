package com.dvc.wordle.WordleApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class WordleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordleAppApplication.class, args);
	}

}

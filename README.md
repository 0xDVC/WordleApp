# WordleApp

## Overview

WordleApp is a full-stack application that includes a backend built with Java SpringBoot and a frontend built with React, TypeScript, and Vite. The application is designed to provide a seamless and interactive user experience for playing the popular word-guessing game, Wordle.

## Project Structure

```
WordleApp/
├── docker-compose.yml  
├── Dockerfile  
├── frontend/  
│   ├── .gitignore
│   ├── Dockerfile  
│   ├── eslint.config.js  
│   ├── index.html  
│   ├── package.json  
│   ├── public/   
│   ├── README.md   
│   ├── src/  
│   │   ├── App.tsx   
│   │   ├── components/   
│   │   ├── assets/   
│   ├── tsconfig.app.json  
│   ├── tsconfig.json   
│   ├── tsconfig.node.json  
│   └── vite.config.ts   
├── pom.xml   
├── README.md   
└── src/  
    ├── main/   
    │   ├── java/
    │   │   └── com/
    │   │       └── dvc/
    │   │           └── wordle/
    │   │               ├── WordleAppApplication.java 
    │   │               ├── controller/   
    │   │               ├── model/   
    │   │               └── service/   
    │   └── resources/  
    │       ├── application.properties  
    │       └── wordlist.txt   
    └── test/  
        └── java/
            └── com/
                └── dvc/
                    └── wordle/
                        └── WordleApp/   
                            ├── GameEngineTest.java
                            ├── RandomEngineTest.java
                            ├── ScoreEngineTest.java
                            └── WordCheckerTest.java

```

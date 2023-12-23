package com.guessyourage.guessyourage.controllers;

public class PromptController {
    public int guessAge(int age) {
        double GUESS_CORRECTLY_THRESHOLD = 0.5;
        int lowAge = 0;
        int highAge = age * 2;
        int randomAge = (int) (Math.random() * (highAge - lowAge)) + lowAge;
        return Math.random() > GUESS_CORRECTLY_THRESHOLD ? age : randomAge;
    }
}
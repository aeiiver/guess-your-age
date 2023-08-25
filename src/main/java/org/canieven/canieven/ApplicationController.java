package org.canieven.canieven;

import javafx.scene.control.Label;

public class ApplicationController {
    public void guessAge(int age, Label answerLabel) {
        double GUESS_CORRECTLY_THRESHOLD = 0.5;
        int lowAge = 0;
        int highAge = age * 2;
        int randomAge = (int)(Math.random() * (highAge - lowAge)) + lowAge;
        int guessed = Math.random() > GUESS_CORRECTLY_THRESHOLD ? age : randomAge;

        answerLabel.setText(String.format("Your REAL age is %d.", guessed));
        answerLabel.getScene().getWindow().sizeToScene();
    }
}
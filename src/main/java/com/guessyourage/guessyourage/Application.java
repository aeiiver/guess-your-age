package com.guessyourage.guessyourage;

import javafx.stage.Stage;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
        ApplicationSceneType.PROMPT.load(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
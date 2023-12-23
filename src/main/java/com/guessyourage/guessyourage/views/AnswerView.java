package com.guessyourage.guessyourage.views;

import com.guessyourage.guessyourage.ApplicationSceneType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AnswerView implements View {
    @FXML
    private VBox root;
    @FXML
    private Label answerLabel;

    @FXML
    private void onGotItClick(ActionEvent actionEvent) {
        ApplicationSceneType.PROMPT.load();
    }

    @Override
    public void load(Object data) {
        String msg = (String) data;
        answerLabel.setText(msg);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

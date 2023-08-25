package com.guessyourage.guessyourage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationView implements Initializable {
    private final ApplicationController controller;
    private final Validator validator = new Validator();

    @FXML private VBox root;
    @FXML private VBox wrapper;
    @FXML private TextField ageField;

    private Label answerLabel;

    public ApplicationView(ApplicationController controller) {
        this.controller = controller;
    }

    @FXML private void onGuessClick(ActionEvent actionEvent) {
        if (validator.validate()) {
            if (answerLabel == null) {
                answerLabel = new Label();
                wrapper.getChildren().add(answerLabel);
            }

            try {
                int age = Integer.parseInt(ageField.getText());
                controller.guessAge(age, answerLabel);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Unreachable");
            }
        } else {
            ageField.requestFocus();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validator.createCheck()
                .dependsOn("age", ageField.textProperty())
                .withMethod(field -> {
                    String age = field.get("age");
                    if (age.isEmpty() || !age.matches("^\\d+$")) {
                        field.error("Please type an age.");
                    }
                })
                .decorates(ageField);
    }
}

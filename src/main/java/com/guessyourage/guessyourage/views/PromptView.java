package com.guessyourage.guessyourage.views;

import com.guessyourage.guessyourage.ApplicationSceneType;
import com.guessyourage.guessyourage.controllers.PromptController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.synedra.validatorfx.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class PromptView implements View {
    private final Validator validator = new Validator();
    private final PromptController controller = new PromptController();

    @FXML
    private VBox root;
    @FXML
    private TextField ageField;

    @FXML
    private void onGuessClick(ActionEvent actionEvent) {
        if (validator.validate()) {
            try {
                int age = Integer.parseInt(ageField.getText());
                int guess = controller.guessAge(age);
                String msg = String.format("Your REAL age is %d.", guess);
                ApplicationSceneType.ANSWER.dontResizeNext().load(msg);
            } catch (NumberFormatException e) {
                assert false : "Unreachable";
            }
        } else {
            ageField.requestFocus();
        }
    }

    @Override
    public void load(Object data) {
        // Nothing to load
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

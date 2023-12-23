package com.guessyourage.guessyourage;

import com.guessyourage.guessyourage.views.AnswerView;
import com.guessyourage.guessyourage.views.PromptView;
import com.guessyourage.guessyourage.views.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

public enum ApplicationSceneType {
    PROMPT("prompt-view.fxml", new PromptView()),
    ANSWER("answer-view.fxml", new AnswerView());

    private static final String TITLE = "Guess your REAL age!";

    private static Stage currentStage;
    private static final HashMap<ApplicationSceneType, Scene> loadedScenes = new HashMap<>(values().length);

    private final URL resource;
    private final View view;
    private boolean dontResizeNext;

    ApplicationSceneType(String resource, View view) {
        this.resource = this.getClass().getResource(resource);
        this.view = view;
        this.dontResizeNext = false;
    }

    public ApplicationSceneType dontResizeNext() {
        dontResizeNext = true;
        return this;
    }

    public void load(Stage stage, Object data) {
        if (stage == null && currentStage == null) {
            assert false : "Unreachable";
        } else if (stage != null) {
            currentStage = stage;
        }

        FXMLLoader loader = new FXMLLoader(resource);
        loader.setController(view);

        Scene scene = loadedScenes.get(this);
        if (scene == null) {
            try {
                scene = new Scene(loader.load());
            } catch (IOException e) {
                assert false : "Unreachable";
            }
            URL url = getClass().getResource("style.css");
            String file = Objects.requireNonNull(url).toExternalForm();
            scene.getStylesheets().add(file);
            loadedScenes.put(this, scene);
        }

        double w = currentStage.getWidth();
        double h = currentStage.getHeight();
        {
            currentStage.setTitle(TITLE);
            currentStage.setScene(scene);
            view.load(data);
        }
        if (dontResizeNext) {
            currentStage.setWidth(w);
            currentStage.setHeight(h);
            dontResizeNext = false;
        } else {
            currentStage.sizeToScene();
        }

        if (!currentStage.isShowing()) {
            currentStage.show();
        }
    }

    public void load(Stage stage) {
        load(stage, null);
    }

    public void load(Object data) {
        load(null, data);
    }

    public void load() {
        load(null, null);
    }
}

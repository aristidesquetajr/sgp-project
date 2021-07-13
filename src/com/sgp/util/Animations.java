package com.sgp.util;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animations {


    public static void makeFadeIn(AnchorPane rootPane) {
        FadeTransition fadeTransition = makeFadeAnimation(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public static void makeFadeOut(AnchorPane rootPane) {
        FadeTransition fadeTransition = makeFadeAnimation(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        fadeTransition.setOnFinished((ActionEvent event) -> {
            Stage currentStage = (Stage) rootPane.getScene().getWindow();
            currentStage.hide();
        });
    }

    private static FadeTransition makeFadeAnimation(AnchorPane rootPane) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(2));
        fadeTransition.setNode(rootPane);        
        return fadeTransition;
    }
}

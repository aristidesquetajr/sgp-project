package com.sgp.util;

import java.net.URI;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animations {


    public static void makeFadeIn(Node rootPane, int time) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(time));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    public static void makeFadeOut(Node rootPane, int time) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setDuration(Duration.seconds(time));
        fadeTransition.setNode(rootPane);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        fadeTransition.setOnFinished((ActionEvent event) -> {
            Stage currentStage = (Stage) rootPane.getScene().getWindow();
            currentStage.hide();
        });
    }

    public static void openLoginOrResetPass(AnchorPane rootPane, String source) {
        try {
            URI src = Paths.get("src/com/sgp/views/" + source +".fxml").toAbsolutePath().toUri();
            Parent root = FXMLLoader.load(src.toURL());
            Scene scene = rootPane.getScene();

            root.translateXProperty().set(scene.getWidth());
            rootPane.getChildren().add(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            timeline.getKeyFrames().add(kf);

            timeline.setOnFinished(event2 -> {
                rootPane.getChildren().remove(rootPane.getChildren().get(0));
            });
            timeline.play();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package com.sgp.controllers;

import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class RecoverPasswordController implements Initializable {

    @FXML private AnchorPane rootPane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //makeFadeIn(rootPane);
    }

    @FXML
    private void backLogin(ActionEvent event) {
        /* openLoginOrResetPass(rootPane, "Login"); */
        try {
            URI src = Paths.get("src/com/sgp/views/" + "Login" +".fxml").toAbsolutePath().toUri();
            Parent root = FXMLLoader.load(src.toURL());
            Scene scene = rootPane.getScene();
            scene.setFill(Color.TRANSPARENT);

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

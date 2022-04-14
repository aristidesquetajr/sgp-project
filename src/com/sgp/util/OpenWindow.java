package com.sgp.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpenWindow {

    private double xOffset, yOffset;

    public OpenWindow(String source) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/sgp/views/" + source + ".fxml"));
            Stage stage = new Stage();

            // grab your root here
            root.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            // move around here
            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            });
            
            Scene scene = new Scene(root);
            // set transparent
            scene.setFill(Color.TRANSPARENT);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public OpenWindow(Pane pane, String source) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/sgp/views/" + source + ".fxml"));
            pane.getChildren().clear();
            pane.getChildren().add(root);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

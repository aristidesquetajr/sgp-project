package com.sgp.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpenWindow {

    public OpenWindow(String source, String title) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/sgp/views/" + source + ".fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
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
            pane.getChildren().removeAll(pane.getChildren());
            pane.getChildren().add(root);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

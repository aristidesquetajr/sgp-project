package com.sgp.main;

import com.sgp.controllers.LoginController;
import com.sgp.controllers.MainPainelController;
import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try {
            new LoginController()
                .setStage(stage)
                .setModality(Modality.APPLICATION_MODAL)
                .showUndecorated(true);
        } catch (Exception e) {
            System.out.println("(Login) error: " + e.getMessage());
        }
        
    }

    public static void main(String[] args) {
        System.out.println("Hello friend's :)");
        launch(args);
    }
    
}

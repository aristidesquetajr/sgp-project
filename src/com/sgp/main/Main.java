package com.sgp.main;

import com.sgp.util.OpenWindow;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new OpenWindow("Login", "Login");
    }
    
   public static void main(String[] args) {
        launch(args);
    };

}

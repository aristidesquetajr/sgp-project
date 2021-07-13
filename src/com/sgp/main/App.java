package com.sgp.main;

import com.sgp.util.OpenWindow;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            new OpenWindow("Login");
        } catch (Exception e) {
            System.out.println("Erro no: " + e.getMessage());
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

package com.sgp.controllers;

import static com.sgp.util.Animations.makeFadeIn;
import static com.sgp.util.Animations.openLoginOrResetPass;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RecoverPasswordController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        makeFadeIn(rootPane);
    }

    @FXML
    private void backLogin(MouseEvent event) {
        openLoginOrResetPass(rootPane, "Login");
    }
    
}

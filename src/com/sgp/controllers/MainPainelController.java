package com.sgp.controllers;

import static com.sgp.util.Animations.makeFadeIn;
import static com.sgp.util.Animations.makeFadeOut;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class MainPainelController implements Initializable {

   
    @FXML
    private Pane navbar;
    @FXML
    private Pane section;

    @FXML
    private AnchorPane rootPane;

    private void loadNextPage(String page) {
        try {
            Parent source = FXMLLoader.load(getClass().getResource("/com/sgp/views/" + page + ".fxml"));
            this.section.getChildren().removeAll(this.section.getChildren());
            this.section.getChildren().add(source);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeFadeIn(rootPane);
        loadNextPage("Home");
    }

    @FXML
    private void openHome(MouseEvent event) {
        loadNextPage("Home");
    }

    @FXML
    private void openCursos(MouseEvent event) {
        loadNextPage("Cursos");
    }

    @FXML
    private void openEstudantes(MouseEvent event) {
        loadNextPage("Estudantes");
    }

    @FXML
    void handleBtnLogoutClick(MouseEvent event) throws InterruptedException {
        makeFadeOut(rootPane);
        Thread.sleep(2001);
        lanchLogin();
    }

    private void lanchLogin() {
        try {
            Parent source = FXMLLoader.load(getClass().getResource("/com/sgp/views/Login.fxml"));
            Scene scene = new Scene(source);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Login");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

package com.sgp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class MainPainelController implements Initializable {

    @FXML
    private Pane btnHome;
    @FXML
    private Pane btnEstudantes;
    @FXML
    private Pane btnCursos;
    @FXML
    private Pane btnPagar;
    @FXML
    private Pane btnRelatorio;
    @FXML
    private Pane navbar;
    @FXML
    private Pane section;

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

}

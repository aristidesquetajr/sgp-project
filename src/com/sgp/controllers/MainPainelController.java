package com.sgp.controllers;

import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
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

    private void loadPage(String page) {
        Parent root = null;
        URI source = Paths.get("src/com/sgp/views/" + page + ".fxml").toAbsolutePath().toUri();
        System.out.println(source.toString());
        try {
            root = FXMLLoader.load(source.toURL());
            this.section.getChildren().removeAll(this.section.getChildren());
            this.section.getChildren().add(root);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadPage("Home");
    }

    @FXML
    private void openHome(MouseEvent event) {
        loadPage("Home");
    }

    @FXML
    private void openCursos(MouseEvent event) {
        loadPage("Cursos");
    }

    @FXML
    private void openEstudantes(MouseEvent event) {
        loadPage("Estudantes");
    }

}

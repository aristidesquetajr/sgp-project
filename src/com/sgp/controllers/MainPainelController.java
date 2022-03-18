package com.sgp.controllers;

import static com.sgp.util.Animations.makeFadeIn;
import static com.sgp.util.Animations.makeFadeOut;

import java.net.URL;
import java.util.ResourceBundle;

import com.sgp.util.OpenWindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class MainPainelController implements Initializable {

    @FXML
    private Label lblTitle;

    @FXML
    private Pane section;

    @FXML
    private AnchorPane rootPane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeFadeIn(rootPane);
        lblTitle.setText("Homepage");
        new OpenWindow(section, "Home");
    }

    @FXML
    private void openHome(MouseEvent event) {
        lblTitle.setText("Homepage");
        new OpenWindow(section, "Home");
    }

    @FXML
    private void openCursos(MouseEvent event) {
        lblTitle.setText("Cursos");
        new OpenWindow(section, "Cursos");
    }

    @FXML
    private void openEstudantes(MouseEvent event) {
        lblTitle.setText("Estudantes");
        new OpenWindow(section, "Estudantes");
    }

    @FXML
    void openPagamentos(MouseEvent event) {
        lblTitle.setText("Pagamentos");
        new OpenWindow(section, "Pagamentos");
    }

    @FXML
    void openRelatorio(MouseEvent event) {
        lblTitle.setText("Relatorios");
        new OpenWindow(section, "Relatorio");
    }

    @FXML
    private void Logout(MouseEvent event) throws InterruptedException {
        makeFadeOut(rootPane);
        Thread.sleep(2001);
        new OpenWindow("Login", "Login");
    }

    @FXML
    private void closeApplication(MouseEvent event) {
        System.exit(0);
    }
}

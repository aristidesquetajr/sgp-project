package com.sgp.controllers;

import static com.sgp.util.Animations.*;

import java.net.URL;
import java.util.ResourceBundle;

import com.sgp.dao.UtilizadorDAO;
import com.sgp.model.Utilizador;
import com.sgp.util.OpenWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUser;

    @FXML
    private AnchorPane window;

    @FXML
    private void Login(ActionEvent event) {
        String txtUsername, txtPassword;
        txtUsername = this.txtUser.getText();
        txtPassword = this.txtPass.getText();

        try {
            if (!(txtUsername.isEmpty() || txtPassword.isEmpty())) {
                Utilizador utilizador = new Utilizador();
                UtilizadorDAO utilizadorDAO = new UtilizadorDAO();

                utilizador.setUsername(txtUsername);
                utilizador.setPassword(txtPassword);

                if (utilizadorDAO.getAccess(utilizador)) {
                    System.out.println("Entrou");
                    makeFadeOut(window);
                    new OpenWindow("MainPainel", "Gestão de Propina");
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Username or Password is incorret");
                    alert.show();
                    System.out.println("Username or Password is incorret");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void openRecoverPassword(ActionEvent event) {
        openLoginOrResetPass(window, "RecoverPassword");
    }

    @FXML
    private void closeApplication(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeFadeIn(window);
    }

}

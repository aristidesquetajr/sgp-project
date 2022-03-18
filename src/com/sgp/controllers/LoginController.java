package com.sgp.controllers;

import static com.sgp.util.Animations.makeFadeIn;
import static com.sgp.util.Animations.makeFadeOut;

import java.net.URL;
import java.util.ResourceBundle;

import com.sgp.dao.UtilizadorDAO;
import com.sgp.model.Utilizador;
import com.sgp.util.OpenWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
                    System.out.println("User or Password is incorret");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void openRecoverPassword(ActionEvent event) {
        new OpenWindow("RecoverPassword", "Recover Your Password");
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

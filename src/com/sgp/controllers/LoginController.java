package com.sgp.controllers;

import com.sgp.beans.Utilizador;
import com.sgp.dao.UtilizadorDAO;
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private PasswordField txtPass;
    @FXML
    private TextField txtUser;
    @FXML
    private AnchorPane window;
    @FXML
    private Button btnLogin;

    @FXML
    void Login(ActionEvent event) {
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
                    openPainel();
                } else {
                    System.out.println("User or Password is incorret");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void openPainel() {
        try {
            URI uri = Paths.get("src/com/sgp/views/MainPainel.fxml").toAbsolutePath().toUri();
            Parent root = FXMLLoader.load(uri.toURL());
            Scene s = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(s);
            stage.setTitle("Sistema Gestao Propina");
            stage.setResizable(false);
            stage.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

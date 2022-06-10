package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import com.sgp.dao.UtilizadorDAO;
import com.sgp.model.Utilizador;
import static com.sgp.util.Animations.makeFadeIn;
import static com.sgp.util.Animations.makeFadeOut;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;

public class LoginController extends WindowControllerFx {

    @FXML private PasswordField txtPass;
    @FXML private TextField txtUser;
    @FXML private AnchorPane window;
    
    /* Outros Atributos */
    final private UtilizadorDAO utilizadorDAO = new UtilizadorDAO();
    final private Utilizador utilizador = new Utilizador();
    private Utilizador resultUtilizador;
    private double xOffset, yOffset;
    
    public LoginController() {
        System.out.println("Welcome the page Login!");

    }

    @Override
    public String getFXML() {
        return "/com/sgp/views/Login.fxml";
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeFadeIn(window, 5);

        // grab your root here
        window.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // root around here
        window.setOnMouseDragged(event -> {
            getWindow().setX(event.getScreenX() - xOffset);
            getWindow().setY(event.getScreenY() - yOffset);
        });
    }
    
    @FXML
    void closeApplication(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void changeCloseIcon(MouseEvent event) {
        FontAwesomeIcon icon = (FontAwesomeIcon) event.getSource();
        if (event.getEventType() == MOUSE_ENTERED)
            icon.setGlyphName("TIMES_CIRCLE");
        else 
            icon.setGlyphName("CIRCLE");
    }

    @FXML
    void Login(ActionEvent event) {
        try {
            utilizador.setUsername(txtUser.getText());
            utilizador.setPassword(txtPass.getText());
            resultUtilizador = utilizadorDAO.getAccess(utilizador);
            
            if (resultUtilizador.getLogado() == 1) {
                makeFadeOut(window, 1);
                new MainPainelController(resultUtilizador)
                    .setParent(getWindow())
                    .setModality(Modality.APPLICATION_MODAL)
                    .showUndecorated(true);
            } else {
                System.out.println("Username or Password is incorret");
                new Alert(Alert.AlertType.ERROR, "Username or Password is incorret").show();
            }
        } catch (Exception e) {
            System.out.println("[Error] ligação não estabelecida: " + e.getMessage());
            new Alert(AlertType.WARNING, "[505] ligação não estabelecida").show();
        }
    }
    
}

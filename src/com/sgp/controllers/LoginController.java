package com.sgp.controllers;

import static com.sgp.util.Animations.makeFadeIn;
import static com.sgp.util.Animations.makeFadeOut;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;

import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import com.sgp.dao.UtilizadorDAO;
import com.sgp.model.Utilizador;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        Stage stage = getWindow();
        makeFadeIn(window, 5);

        // grab your root here
        window.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // root around here
        window.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
    }
    
    @FXML
    private void openRecoverPassword(ActionEvent event) {
        try {
            URI src = Paths.get("src/com/sgp/views/" + "RecoverPassword" +".fxml").toAbsolutePath().toUri();
            Parent root = FXMLLoader.load(src.toURL());
            Scene scene = window.getScene();
            scene.setFill(Color.TRANSPARENT);

            root.translateXProperty().set(scene.getWidth());
            window.getChildren().add(root);

            Timeline timeline = new Timeline();
            KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
            KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
            timeline.getKeyFrames().add(kf);

            timeline.setOnFinished(event2 -> {
                window.getChildren().remove(window.getChildren().get(0));
            });
            timeline.play();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @FXML
    private void closeApplication(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void changeCloseIcon(MouseEvent event) {
        FontAwesomeIcon icon = (FontAwesomeIcon) event.getSource();
        if (event.getEventType() == MOUSE_ENTERED)
            icon.setGlyphName("TIMES_CIRCLE");
        else 
            icon.setGlyphName("CIRCLE");
    }

    @FXML
    private void Login(ActionEvent event) {
        try {
            utilizador.setUsername(txtUser.getText());
            utilizador.setPassword(txtPass.getText());
            resultUtilizador = utilizadorDAO.getAccess(utilizador);
            
            if (resultUtilizador.getLogado() == 1) {
                makeFadeOut(window, 2);
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

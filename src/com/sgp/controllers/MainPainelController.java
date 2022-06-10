package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import com.jfoenix.controls.JFXButton;
import com.sgp.model.Utilizador;
import static com.sgp.util.Animations.makeFadeIn;
import static com.sgp.util.Animations.makeFadeOut;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class MainPainelController extends WindowControllerFx {

    @FXML
    private Label lblTitle;
    @FXML
    private Pane section;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton btnHome, btnEstudantes,
            btnCursos, btnPagamentos,
            btnRelatorios, btnConfigs;

    private double xOffset, yOffset;
    Utilizador resUtilizador;

    public MainPainelController() {
    }

    public MainPainelController(Utilizador utilizador) {
        System.out.println("Welcome " + utilizador.getFkFuncionario().getFkPessoa().getNome());
        resUtilizador = utilizador;
    }

    @Override
    public String getFXML() {
        return "/com/sgp/views/MainPainel.fxml";
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        openWindow(new EstudantesController());
        makeFadeIn(rootPane, 5);

        // grab your root here
        rootPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // root around hereg-
        rootPane.setOnMouseDragged(event -> {
            getWindow().setX(event.getScreenX() - xOffset);
            getWindow().setY(event.getScreenY() - yOffset);
        });

        // Add açao nus Itens do Menu
        btnHome.setOnAction(e -> openWindow(new HomeController()));
        btnEstudantes.setOnAction(e -> openWindow(new EstudantesController()));
        btnCursos.setOnAction(e -> openWindow(new CursosController()));
        btnPagamentos.setOnAction(e -> openWindow(new PagamentosController()));
        btnRelatorios.setOnAction(e -> openWindow(new RelatorioController()));
        btnConfigs.setOnAction(e -> openWindow(new ConfigController()));
    }

    @FXML
    void Logout(ActionEvent event) throws InterruptedException {
        makeFadeOut(rootPane, 2);
        Thread.sleep(2001);
        new LoginController()
                .setParent(getWindow())
                .setModality(Modality.APPLICATION_MODAL)
                .showUndecorated(true);
    }

    @FXML
    void changeCloseIcon(MouseEvent event) {
        FontAwesomeIcon icon = (FontAwesomeIcon) event.getSource();
        if (event.getEventType() == MOUSE_ENTERED) {
            icon.setGlyphName("TIMES_CIRCLE");
        } else {
            icon.setGlyphName("CIRCLE");
        }
    }

    @FXML
    void closeApplication(MouseEvent event) {
        //resUtilizador.setLogado(0);
        System.exit(0);
    }

    private void openWindow(WindowControllerFx w) {
        try {
            lblTitle.setText(w.getTitle());
            Parent root = FXMLLoader.load(getClass().getResource(w.getFXML()));
            section.getChildren().clear();
            section.getChildren().add(root);
        } catch (IOException ex) {
            Logger.getLogger(MainPainelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

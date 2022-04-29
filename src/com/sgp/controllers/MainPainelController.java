package com.sgp.controllers;

import static com.sgp.util.Animations.makeFadeOut;
import static javafx.scene.input.MouseEvent.MOUSE_ENTERED;

import java.net.URL;
import java.util.ResourceBundle;

import com.sgp.model.Utilizador;
import com.sgp.util.OpenWindow;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import static com.sgp.util.Animations.makeFadeIn;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class MainPainelController extends WindowControllerFx {

    @FXML private Label lblTitle;
    @FXML private Pane section;
    @FXML private AnchorPane rootPane;
        
    private double xOffset, yOffset;
    private Utilizador resUtilizador;

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
        makeFadeIn(rootPane, 5);
        lblTitle.setText("Homepage");
        new OpenWindow(section, "Home");

        // grab your root here
        rootPane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // root around here
        rootPane.setOnMouseDragged(event -> {
            getWindow().setX(event.getScreenX() - xOffset);
            getWindow().setY(event.getScreenY() - yOffset);
        });
    }

    @FXML
    private void openHome(ActionEvent event) {
        lblTitle.setText("Homepage");
        new OpenWindow(section, "Home");
    }

    @FXML
    private void openCursos(ActionEvent event) {
        lblTitle.setText("Cursos");
        new OpenWindow(section, "Cursos");
    }

    @FXML
    private void openEstudantes(ActionEvent event) {
        lblTitle.setText("Estudantes");
        new OpenWindow(section, "Estudantes");
    }

    @FXML
    void openPagamentos(ActionEvent event) {
        lblTitle.setText("Pagamentos");
        new OpenWindow(section, "Pagamentos");
    }

    @FXML
    void openRelatorio(ActionEvent event) {
        lblTitle.setText("Relatorios");
        new OpenWindow(section, "Relatorio");
    }

    @FXML
    private void Logout(MouseEvent event) throws InterruptedException {
        makeFadeOut(rootPane, 2);
        Thread.sleep(2001);
        new LoginController()
            .setParent(getWindow())
            .setModality(Modality.APPLICATION_MODAL)
            .showUndecorated(true);
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
    private void closeApplication(MouseEvent event) {
        System.exit(0);
    }

}

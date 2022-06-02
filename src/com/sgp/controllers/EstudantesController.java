package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import java.net.URL;
import java.util.ResourceBundle;
import com.sgp.dao.AlunoDAO;
import com.sgp.model.Aluno;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class EstudantesController extends WindowControllerFx {

    @FXML
    private TableView<Aluno> tableEstudantes;
    @FXML
    private TableColumn<Aluno, String> 
            nomeEstudantes, cursoEstudantes, turmaEstudantes;
    @FXML
    private TableColumn<Aluno, Integer> 
            numbEstudantes, salaEstudantes;
    @FXML
    private AnchorPane 
            pageOne, pageTwo;

    final private AlunoDAO alunoDAO = new AlunoDAO();
    @FXML
    private Pane content;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showEstudantes();

        tableEstudantes.getSelectionModel().selectedItemProperty().addListener(
            (observale, oldValue, newValue) -> { 
                selectedItemTableEstudantes(newValue);
                
                /*
                pageTwo.setDisable(false);
                pageTwo.setVisible(true);
                
                pageOne.setDisable(true);
                pageOne.setVisible(false);
                */
            });
    }

    @Override
    public String getFXML() {
        return "/com/sgp/views/Estudantes.fxml";
    }

    @Override
    public String getTitle() {
        return "Estudantes";
    }
    
    @FXML
    void BackTable(ActionEvent event) {
        /*
        pageTwo.setVisible(false);
        pageTwo.setDisable(true);
        
        pageOne.setDisable(false);
        pageOne.setVisible(true);
        */
    }

    private void showEstudantes() {
        ObservableList<Aluno> listEstudantes = FXCollections.observableArrayList(alunoDAO.showAlunos());
        numbEstudantes.setCellValueFactory(new PropertyValueFactory<>("numAluno"));
        nomeEstudantes.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkPessoa().getNome()));
        cursoEstudantes.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkClasse().getFkCurso().getCurso()));
        salaEstudantes.setCellValueFactory(val -> (ObservableValue) new SimpleIntegerProperty(val.getValue().getFkClasse().getSala()));
        turmaEstudantes.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkClasse().getFkTurma().getTurma()));

        tableEstudantes.getItems().addAll(listEstudantes);
    }

    private void selectedItemTableEstudantes(Aluno aluno) {
        new ChangeEstudantesController(aluno).show();
        //content.getChildren().clear();
        //content.getChildren().add(root.getRootPane());
    }
    
}

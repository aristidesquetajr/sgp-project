package com.sgp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sgp.dao.AlunoDAO;
import com.sgp.model.Aluno;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class EstudantesController implements Initializable {

    @FXML
    private TableView<Aluno> tableEstudantes;

    @FXML
    private TableColumn<Aluno, Integer> numbEstudantes;

    @FXML
    private TableColumn<Aluno, String> nomeEstudantes;

    @FXML
    private TableColumn<Aluno, String> cursoEstudantes;

    @FXML
    private TableColumn<Aluno, Integer> salaEstudantes;

    @FXML
    private TableColumn<Aluno, String> turmaEstudantes;


    final private AlunoDAO alunoDAO = new AlunoDAO();

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
            (observale, oldValue, newValue) -> selectedItemTableEstudantes(newValue)
        );
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
        new ChangeEstudantesController(aluno)
            .setParent(new Stage())
            .setModality(Modality.APPLICATION_MODAL)
            .show();
    }

}

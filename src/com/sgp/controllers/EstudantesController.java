package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import com.sgp.dao.AlunoDAO;
import com.sgp.model.Aluno;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class EstudantesController extends WindowControllerFx {

    @FXML
    private TableView<Aluno> tableEstudantes;
    @FXML
    private TableColumn<Aluno, String> nomeEstudantes, cursoEstudantes, turmaEstudantes, statusEstudantes;
    @FXML
    private TableColumn<Aluno, Integer> numbEstudantes, salaEstudantes;
    @FXML
    private TabPane tabPane;

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
                (observale, oldValue, newValue) -> {
                    selectedItemTableEstudantes(newValue);
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

    private void showEstudantes() {
        ObservableList<Aluno> listEstudantes = FXCollections.observableArrayList(alunoDAO.showAlunos());
        numbEstudantes.setCellValueFactory(new PropertyValueFactory<>("numAluno"));
        nomeEstudantes.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkPessoa().getNome()));
        cursoEstudantes.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkClasse().getFkCurso().getCurso()));
        salaEstudantes.setCellValueFactory(val -> (ObservableValue) new SimpleIntegerProperty(val.getValue().getFkClasse().getSala()));
        turmaEstudantes.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkClasse().getFkTurma().getTurma()));
        statusEstudantes.setCellValueFactory(new PropertyValueFactory<>("status"));
        tableEstudantes.setItems(listEstudantes);
    }

    private void selectedItemTableEstudantes(Aluno aluno) {
        //new ChangeEstudantesController(aluno).show();
        tabPane.getSelectionModel().selectLast();
        
        
        
        
        
        
        
        
       
    }

}

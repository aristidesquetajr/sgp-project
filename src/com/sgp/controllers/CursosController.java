package com.sgp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;
import com.sgp.dao.CursoDAO;
import com.sgp.model.Curso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class CursosController implements Initializable {

    @FXML
    private JFXListView<Curso> listCursos;

    @FXML
    private TextField txtCurso;

    @FXML
    private Pane container;

    private Curso curso;
    private CursoDAO cursoDAO;

    @FXML
    private void handleButtonAddCurso(ActionEvent event) {
        String textCurso = this.txtCurso.getText();
        if (!(textCurso.isEmpty())) {
            Alert hasConfirmation = new Alert(AlertType.CONFIRMATION, "adicionar novo item?");
            hasConfirmation.show();

            curso = new Curso();
            curso.setCurso(textCurso);
            cursoDAO = new CursoDAO();
            cursoDAO.createdCurso(curso);
            showCursosList();

        } else {
            new Alert(AlertType.WARNING, "Campo vazio").show();
        }
    }

    @FXML
    void handleButtonDeletar(ActionEvent event) {
        ObservableList<Curso> selectCursos, cursoSelected;
        selectCursos = listCursos.getSelectionModel().getSelectedItems();
        cursoSelected = listCursos.getItems();
        String message = "";
        for (Curso cursoItem : selectCursos) {
            // Comando para deletar
            message += cursoItem.getCurso() + "\n";
        }
        new Alert(Alert.AlertType.INFORMATION, message).show();

        selectCursos.forEach(cursoSelected::remove); // remove apenas na tabela
    }

    @FXML
    void handleButtonEditar(ActionEvent event) {
        new Alert(AlertType.INFORMATION, "Ainda não foi configurado").show();
    }

    private void showCursosList() {
        cursoDAO = new CursoDAO();
        ObservableList<Curso> obsCursos = FXCollections.observableArrayList();
        obsCursos.addAll(cursoDAO.getCursos());
        this.listCursos.setItems(obsCursos);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listCursos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);;
        showCursosList();
    }

}

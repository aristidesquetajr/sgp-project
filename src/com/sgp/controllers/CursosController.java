package com.sgp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sgp.beans.Curso;
import com.sgp.dao.CursoDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class CursosController implements Initializable {

    @FXML
    private ListView<Curso> listCursos;

    @FXML
    private TextField txtCurso;

    @FXML
    private void handleAddCurso(ActionEvent event) {
        String textCurso = this.txtCurso.getText();
        if(!(textCurso.isEmpty())) {
            Curso curso = new Curso();
            curso.setCurso(textCurso);
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.createdCurso(curso);
            showCursosList();
        }
    }
    
    private void showCursosList() {
        CursoDAO cursoDAO = new CursoDAO();
        ObservableList<Curso> obsCursos = FXCollections.observableArrayList();
        obsCursos.addAll(cursoDAO.getCursos());
        this.listCursos.setItems(obsCursos);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCursosList();
    }
    
}

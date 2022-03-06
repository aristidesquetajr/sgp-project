package com.sgp.controllers;

import com.sgp.beans.Curso;
import com.sgp.dao.CursoDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
    private ListView<String> listCursos;
    @FXML
    private TextField txtCurso;
    
    private void addCursoList() {
        this.listCursos.setItems(getElements());
    }
    
    private ObservableList<String> getElements() {
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> listaCursos = cursoDAO.getCursos();
        ObservableList<String> row = FXCollections.observableArrayList();
        for(Curso c: listaCursos) {
            row.add(c.toString());
        }
        return row;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addCursoList();
    }    

    @FXML
    private void handleAddCurso(ActionEvent event) {
        String textCurso = this.txtCurso.getText();
        if(!(textCurso.isEmpty())) {
            Curso curso = new Curso();
            curso.setCurso(textCurso);
            CursoDAO cursoDAO = new CursoDAO();
            cursoDAO.createdCurso(curso);
            addCursoList();
        }
    }
    
}

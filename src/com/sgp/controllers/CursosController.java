package com.sgp.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.onexip.flexboxfx.FlexBox;
import com.sgp.dao.CursoDAO;
import com.sgp.model.Curso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    private Pane container;

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

    private void showCursos() {
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> listAllCursos = cursoDAO.getCursos();
        FlexBox flexBox = new FlexBox();
        
        listAllCursos.forEach((Curso c) -> {
            Pane pane = new Pane();
            pane.getChildren().add(new Label(c.getCurso()));
            //pane.setBackground(new BackgroundFill(Paint.valueOf("#f8f8f8"), null, null));
            
            flexBox.getChildren().add(pane);
            FlexBox.setGrow(pane, 10);
        });
        container.getChildren().add(flexBox);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCursosList();
        showCursos();
    }
    
}

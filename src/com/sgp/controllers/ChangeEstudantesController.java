package com.sgp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.sgp.model.Aluno;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ChangeEstudantesController extends WindowControllerFx {

    @FXML
    private ImageView imageEstudante;

    @FXML
    private TextField nameEstudantes;

    @FXML
    private TextField biEstudante;

    @FXML
    private ComboBox<String> generoEstudante;

    @FXML
    private TextField emailEstudante;

    @FXML
    private TextField nascimentoEstudante;

    @FXML
    private ComboBox<String> cursoEstudante;

    @FXML
    private TextField classeEstudante;

    @FXML
    private TextField salaEstudante;

    @FXML
    private TextField telefoneEncarregado;

    @FXML
    private TextField numbEstudante;

    @FXML
    private TextField turmaEstudante;

    @FXML
    private TextField telefoneEstudante;

    private Aluno getAluno;

    public ChangeEstudantesController(Aluno aluno) {
        getAluno = aluno;
    }

    @Override
    public String getFXML() {
        return "/com/sgp/views/ChangeEstudantes.fxml";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            nameEstudantes.setText(getAluno.getFkPessoa().getNome());
            generoEstudante.setPromptText(getAluno.getFkPessoa().getGenero());
            biEstudante.setText(getAluno.getFkPessoa().toString());
            emailEstudante.setText(getAluno.getFkPessoa().getEmail());
            /* nascimentoEstudante.setText(getAluno.getFkPessoa().getNascimento().toString()); */
            cursoEstudante.setPromptText(getAluno.getFkClasse().getFkCurso().getCurso());
            classeEstudante.setText(getAluno.getFkClasse().getClasse());
            salaEstudante.setText(getAluno.getFkClasse().getSala() + "");
            numbEstudante.setText(getAluno.getNumAluno() + "");
            turmaEstudante.setText(getAluno.getFkClasse().getFkTurma().getTurma());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

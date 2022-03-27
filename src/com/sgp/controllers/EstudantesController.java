package com.sgp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.sgp.dao.CursoDAO;
import com.sgp.dao.PessoaDAO;
import com.sgp.model.Curso;
import com.sgp.model.Pessoa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class EstudantesController implements Initializable {

    @FXML
    private JFXComboBox<Curso> cmbCurso;

    @FXML
    private JFXComboBox<String> cmbClasse;

    @FXML
    private JFXTextField txtFullName, txtEmail;

    @FXML
    private DatePicker dataNascimento;

    @FXML
    private ToggleGroup genero;

    private CursoDAO cursoDAO;

    @FXML
    private void handleCadastrar(ActionEvent event) {
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();

        JFXRadioButton generoRadio = (JFXRadioButton) genero.getSelectedToggle();

        pessoa.setNome(this.txtFullName.getText());
        pessoa.setGenero(generoRadio.getText());
        pessoa.setEmail(this.txtEmail.getText());

        if (pessoaDAO.cadastrarPessoa(pessoa)) {
            /*
             * Aluno aluno = new Aluno();
             * Classe classe = new Classe();
             * 
             * aluno.setFkPessoa(pessoaDAO.searchPessoa(pessoa.getNome()));
             * 
             * System.out.println(pessoaDAO.searchPessoa(pessoa.getNome()).toString());
             * AlunoDAO alunoDAO = new AlunoDAO();
             * 
             * alunoDAO.cadastro(pessoa, aluno, classe);
             */
            System.out.println("Success");
        }

    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmbClasse.getItems().addAll("10ª Classe", "11ª Classe", "12ª Classe", "13ª Classe");

        cursoDAO = new CursoDAO();
        cmbCurso.getItems().addAll(cursoDAO.getCursos());
    }

}

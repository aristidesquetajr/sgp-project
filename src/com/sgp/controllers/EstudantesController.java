package com.sgp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.sgp.dao.CursoDAO;
import com.sgp.dao.PessoaDAO;
import com.sgp.model.Curso;
import com.sgp.model.Pessoa;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class EstudantesController implements Initializable {

    @FXML
    private JFXComboBox<Curso> cmbCurso;

    @FXML
    private JFXComboBox<String> cmbGenero, cmbClasse;

    @FXML
    private JFXTextField txtFullName, txtEmail;

    private CursoDAO cursoDAO;

    @FXML
    private void handleCadastrar(ActionEvent event) {
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();

        if (getInfoPessoa(pessoa, pessoaDAO)) {
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
        cmbGenero.getItems().addAll("Masculino", "Femenino");
        cmbClasse.getItems().addAll("10ª Classe", "11ª Classe", "12ª Classe", "13ª Classe");

        cursoDAO = new CursoDAO();
        cmbCurso.getItems().addAll(cursoDAO.getCursos());
    }

    private Boolean getInfoPessoa(Pessoa pessoa, PessoaDAO pessoaDAO) {
        try {
            pessoa.setNome(this.txtFullName.getText());
            pessoa.setGenero(this.cmbGenero.getValue());
            pessoa.setEmail(this.txtEmail.getText());

            
            
            return pessoaDAO.cadastrarPessoa(pessoa);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}

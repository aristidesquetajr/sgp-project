package com.sgp.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.sgp.beans.Aluno;
import com.sgp.beans.Curso;
import com.sgp.beans.Pessoa;
import com.sgp.dao.AlunoDAO;
import com.sgp.dao.CursoDAO;
import com.sgp.dao.PessoaDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class EstudantesController implements Initializable {

    @FXML
    private ComboBox<Curso> cmbCurso;

    @FXML
    private ComboBox<String> cmbGenero, cmbClasse;

    @FXML
    private DatePicker dateNascimento;

    @FXML
    private TextField txtFullName, txtEmail;

    @FXML
    private void handleCadastrar(ActionEvent event) {
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();

        pessoa.setNome(this.txtFullName.getText());
        pessoa.setGenero(this.cmbGenero.getValue());

        String email = this.txtEmail.getText();
        pessoa.setEmail(email);

        LocalDate dataNascimento = this.dateNascimento.getValue();
        pessoa.setNascimento(dataNascimento == null ? "0000-00-00" : dataNascimento.toString());
        if (pessoaDAO.cadastrarPessoa(pessoa)) {
            Aluno aluno = new Aluno();
            aluno.setFkPessoa(pessoaDAO.searchPessoa(this.txtFullName.getText()));

            System.out.println(pessoaDAO.searchPessoa(pessoa.getNome()).toString());
            AlunoDAO alunoDAO = new AlunoDAO();

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
        showGeneros();
        showCursos();
        showClasses();
    }


    private void showGeneros() {
        ObservableList<String> listGeneros;
        listGeneros = FXCollections.observableArrayList(new String[] {"Masculino", "Femenino"});
        cmbGenero.setItems(listGeneros);
    }

    private void showCursos() {
        ObservableList<Curso> listCursos;
        listCursos = FXCollections.observableArrayList();
        CursoDAO cursoDAO = new CursoDAO();
        listCursos.addAll(cursoDAO.getCursos());
        cmbCurso.setItems(listCursos);
    }

    private void showClasses() {
        ObservableList<String> listClasses;
        listClasses = FXCollections.observableArrayList(new String[] {
            "10ª Classe", "11ª Classe", "12ª Classe", "13ª Classe"
        });
        cmbClasse.setItems(listClasses);
    }
}

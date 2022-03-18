package com.sgp.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.sgp.dao.AlunoDAO;
import com.sgp.dao.CursoDAO;
import com.sgp.dao.PessoaDAO;
import com.sgp.model.Aluno;
import com.sgp.model.Classe;
import com.sgp.model.Curso;
import com.sgp.model.Pessoa;

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
        
        if (getInfoPessoa(pessoa, pessoaDAO)) {
            /* Aluno aluno = new Aluno();
            Classe classe = new Classe();

            aluno.setFkPessoa(pessoaDAO.searchPessoa(pessoa.getNome()));

            System.out.println(pessoaDAO.searchPessoa(pessoa.getNome()).toString());
            AlunoDAO alunoDAO = new AlunoDAO();

            alunoDAO.cadastro(pessoa, aluno, classe); */
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

    private Boolean getInfoPessoa(Pessoa pessoa, PessoaDAO pessoaDAO) {
        try {
            pessoa.setNome(this.txtFullName.getText());
            pessoa.setGenero(this.cmbGenero.getValue());
            pessoa.setEmail(this.txtEmail.getText());

            LocalDate dataNascimento = this.dateNascimento.getValue();
            pessoa.setNascimento(dataNascimento == null ? "0000-00-00" : dataNascimento.toString());
            return pessoaDAO.cadastrarPessoa(pessoa);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}

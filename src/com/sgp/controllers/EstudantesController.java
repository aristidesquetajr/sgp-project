package com.sgp.controllers;

import com.sgp.beans.Aluno;
import com.sgp.beans.Pessoa;
import com.sgp.dao.AlunoDAO;
import com.sgp.dao.CursoDAO;
import com.sgp.dao.PessoaDAO;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class EstudantesController implements Initializable {

    @FXML
    private MenuButton cmbCurso;
    @FXML
    private MenuButton cmbGenero;

    @FXML
    private DatePicker dateNascimento;

    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtFullName;
    @FXML
    private MenuButton cmbClasse;

    @FXML
    void handleCadastrar(ActionEvent event) {
        Pessoa pessoa = new Pessoa();
        PessoaDAO pessoaDAO = new PessoaDAO();

        pessoa.setNome(this.txtFullName.getText());
        pessoa.setGenero(this.cmbGenero.getText());
        
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

    @FXML
    void toggleGenero(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        this.cmbGenero.setText(item.getText());
    }
    
    @FXML
    private void toggleClasse(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        this.cmbClasse.setText(item.getText());
    }

    private void toggleCurso() {
        this.cmbCurso.getItems().forEach((MenuItem menuItem) -> {
            menuItem.setOnAction((event) -> {
                this.cmbCurso.setText(menuItem.getText());
            });
        });
    }
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CursoDAO.showCursosComboBox(cmbCurso);
        toggleCurso();
    }
}

package com.sgp.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.sgp.dao.AlunoDAO;
import com.sgp.dao.CursoDAO;
import com.sgp.dao.PessoaDAO;
import com.sgp.model.Aluno;
import com.sgp.model.Classe;
import com.sgp.model.Curso;
import com.sgp.model.Pessoa;
import com.sgp.model.Turma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

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

    @FXML
    private TableView<Aluno> tableEstudantes;

    @FXML
    private TableColumn<Aluno, String> numbEstudantes;

    @FXML
    private TableColumn<Aluno, String> nomeEstudantes;

    @FXML
    private TableColumn<Aluno, String> cursoEstudantes;

    @FXML
    private TableColumn<Aluno, String> salaEstudantes;

    @FXML
    private TableColumn<Aluno, String> turmaEstudantes;

    /*  */

    final private CursoDAO cursoDAO = new CursoDAO();
    final private AlunoDAO alunoDAO = new AlunoDAO();

    @FXML
    private void CadastrarAluno(ActionEvent event) {
        if (!(txtFullName.getText().isEmpty() || txtEmail.getText().isEmpty())) {

            Pessoa pessoa = new Pessoa();
            PessoaDAO pessoaDAO = new PessoaDAO();

            JFXRadioButton generoRadio = (JFXRadioButton) genero.getSelectedToggle();

            pessoa.setNome(this.txtFullName.getText());
            pessoa.setGenero(generoRadio.getText());
            pessoa.setEmail(this.txtEmail.getText());

            Aluno aluno = new Aluno();
            aluno.setFkPessoa(pessoa);

            if (pessoaDAO.cadastrarPessoa(pessoa)) {
                /*
                 * 
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

        cmbCurso.getItems().addAll(cursoDAO.getCursos());

        //showEstudantes();
    }

    private void showEstudantes() {
        numbEstudantes.setCellValueFactory(new PropertyValueFactory<>("idPessoa"));
        nomeEstudantes.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cursoEstudantes.setCellValueFactory(new PropertyValueFactory<>("curso"));
        salaEstudantes.setCellValueFactory(new PropertyValueFactory<>("sala"));
        turmaEstudantes.setCellValueFactory(new PropertyValueFactory<>("turma"));

        tableEstudantes.getItems().addAll(alunoDAO.showAlunos());
    }

}

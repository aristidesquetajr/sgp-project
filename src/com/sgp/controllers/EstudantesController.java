package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import com.sgp.dao.AlunoDAO;
import com.sgp.dao.CursoDAO;
import com.sgp.model.Aluno;
import com.sgp.model.Classe;
import com.sgp.model.Curso;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class EstudantesController extends WindowControllerFx {
    
    @FXML
    private TabPane tabPane;

    /**
     * Page -> cadastrar estudante
     */
    @FXML
    private ToggleGroup radioGeneroC;
    @FXML
    private TextField tfNomeCompletoC, tfEmailC, tfTelefoneC;
    @FXML
    private ComboBox<Curso> cmbCursoC;
    @FXML
    private ComboBox<String> cmbClasseC;

    /**
     * Page -> lista de estudantes
     */
    @FXML
    private TableView<Aluno> tableEstudantes;
    @FXML
    private TableColumn<Aluno, String> columnNome, columnCurso, columnTurma, columnStatus, columnAnoLetivo;
    @FXML
    private TableColumn<Aluno, Integer> columnNumbEstudantes, columnSala;
    @FXML
    private TextField barraPesquisaNome;

    /**
     * Page -> Editar
     */
    @FXML
    private TextField nameEstudantes, emailEstudante;
    @FXML
    private ToggleGroup radioGeneroE;
    @FXML
    private TextField nascimentoEstudante;
    @FXML
    private ComboBox<String> cursoEstudante;
    @FXML
    private TextField classeEstudante, salaEstudante, telefoneEncarregado;
    @FXML
    private TextField numbEstudante, turmaEstudante, telefoneEstudante;
    
    final private AlunoDAO alunoDAO = new AlunoDAO();
    final private CursoDAO cursoDAO = new CursoDAO();
    ObservableList<Aluno> listEstudantes;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showEstudantes();
        
        tableEstudantes.getSelectionModel().selectedItemProperty().addListener(
                (observale, oldValue, newValue) -> {
                    selectedItemTableEstudantes(newValue);
                });
        cmbClasseC.getItems().addAll("10ª Classe", "11ª Classe", "12ª Classe", "13ª Classe");
        cmbCursoC.setItems(FXCollections.observableArrayList(cursoDAO.getCursos()));
    }
    
    @Override
    public String getFXML() {
        return "/com/sgp/views/Estudantes.fxml";
    }
    
    @Override
    public String getTitle() {
        return "Estudantes";
    }
    
    @FXML
    void cadastrarEstudante(ActionEvent event) {
        String nome = tfNomeCompletoC.getText();
        String genero = (radioGeneroC.getToggles().get(0).isSelected()) ? "Masculino" : "Femenino";
        String email = tfEmailC.getText();
        String telefone = tfTelefoneC.getText();
        Curso curso = cmbCursoC.getValue();
        String classe = cmbClasseC.getValue();
        try {
            if (nome.isEmpty() || email.isEmpty() || curso.equals(null)) {
                new Alert(Alert.AlertType.ERROR, "preenxa todos os campos").show();
            } else {
                
            }
        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }
    
     @FXML
    void searchEstudante(KeyEvent event) {
        String keyWorld = barraPesquisaNome.getText();
        listEstudantes = FXCollections.observableArrayList(alunoDAO.findAlunosByName(keyWorld));
        tableEstudantes.setItems(listEstudantes);
    }
    
    private void showEstudantes() {
        listEstudantes = FXCollections.observableArrayList(alunoDAO.showAlunos());
        columnNumbEstudantes.setCellValueFactory(new PropertyValueFactory<>("numAluno"));
        columnNome.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkPessoa().getNome()));
        columnCurso.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkClasse().getFkCurso().getCurso()));
        columnSala.setCellValueFactory(val -> (ObservableValue) new SimpleIntegerProperty(val.getValue().getFkClasse().getSala()));
        columnTurma.setCellValueFactory(val -> new SimpleStringProperty(val.getValue().getFkClasse().getFkTurma().getTurma()));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        columnAnoLetivo.setCellValueFactory(new PropertyValueFactory<>("anoLetivo"));
        tableEstudantes.setItems(listEstudantes);
    }
    
    private void selectedItemTableEstudantes(Aluno aluno) {
        pageEdit(aluno);
        tabPane.getTabs().get(2).setDisable(false);
        tabPane.getSelectionModel().selectLast();
    }
    
    private void pageEdit(Aluno getAluno) {
        nameEstudantes.setText(getAluno.getFkPessoa().getNome());
        if ("Masculino".equals(getAluno.getFkPessoa().getGenero()))
            radioGeneroE.getToggles().get(0).setSelected(true);
        else 
            radioGeneroE.getToggles().get(1).setSelected(true);
        emailEstudante.setText(getAluno.getFkPessoa().getEmail());
        /* nascimentoEstudante.setText(getAluno.getFkPessoa().getNascimento().toString()); */
        cursoEstudante.setPromptText(getAluno.getFkClasse().getFkCurso().getCurso());
        classeEstudante.setText(getAluno.getFkClasse().getClasse());
        salaEstudante.setText(getAluno.getFkClasse().getSala() + "");
        numbEstudante.setText(getAluno.getNumAluno() + "");
        turmaEstudante.setText(getAluno.getFkClasse().getFkTurma().getTurma());
    }
    
}

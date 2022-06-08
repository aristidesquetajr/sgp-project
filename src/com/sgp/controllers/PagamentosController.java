package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import com.jfoenix.controls.JFXCheckBox;
import com.sgp.model.Aluno;
import com.sgp.util.Month;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class PagamentosController extends WindowControllerFx {

    @FXML
    private ComboBox<String> cmbMonth;
    @FXML
    private JFXCheckBox hasMulta;
    @FXML
    private TableView<Month> tableMoths;
    @FXML
    private TableColumn<Month, String> months;
    @FXML
    private TableColumn<Month, Boolean> multas;
    

    private final List<Month> listaMonths = new ArrayList<>();
    private Aluno aluno;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cmbMonth.getItems().addAll(
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        );
        
        cmbMonth.getSelectionModel().selectFirst();

        months.setCellValueFactory(new PropertyValueFactory<>("month"));
        multas.setCellValueFactory(new PropertyValueFactory<>("multa"));
        multas.setCellFactory(CheckBoxTableCell.forTableColumn(multas));

    }
    
    @Override
    public String getFXML() {
        return "/com/sgp/views/Pagamentos.fxml";
    }

    @Override
    public String getTitle() {
        return "Pagamentos";
    }

    @FXML
    void addMonth(ActionEvent event) {
        String month = cmbMonth.getSelectionModel().getSelectedItem();
        Boolean multa = hasMulta.isSelected();

        if (month != null) {
            cmbMonth.getItems().removeAll(month);
            listaMonths.add(new Month(month, multa));
            tableMoths.setItems(updateTableMonth());
        }

    }

    @FXML
    void removeMonth(ActionEvent event) {
        Month itemSelected = tableMoths.getSelectionModel().getSelectedItem();
        int indexSelected = tableMoths.getSelectionModel().getSelectedIndex();

        if (itemSelected != null) {
            listaMonths.remove(indexSelected);
            cmbMonth.getItems().add(itemSelected.getMonth());
            tableMoths.setItems(updateTableMonth());
        }
    }

    @FXML
    void pagar(ActionEvent event) {

    }

    private ObservableList<Month> updateTableMonth() {
        return FXCollections.observableArrayList(listaMonths);
    }

}

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
    

    private ObservableList<Month> obsListMonths;
    private final List<Month> listaMonths = new ArrayList<>();
    private Aluno aluno;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        cmbMonth.getItems().addAll(
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        );

        months.setCellValueFactory(new PropertyValueFactory<>("month"));
        multas.setCellValueFactory(new PropertyValueFactory<>("multa"));

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
            updateTableMonth();
        }

    }

    @FXML
    void removeMonth(ActionEvent event) {
        Month itemSelected = tableMoths.getSelectionModel().getSelectedItem();
        int indexSelected = tableMoths.getSelectionModel().getSelectedIndex();

        if (itemSelected != null) {
            listaMonths.remove(indexSelected);
            cmbMonth.getItems().add(itemSelected.getMonth());
            updateTableMonth();
        }
    }

    @FXML
    void pagar(ActionEvent event) {

    }

    private void updateTableMonth() {
        obsListMonths = FXCollections.observableArrayList(listaMonths);
        tableMoths.getItems().clear();
        tableMoths.getItems().addAll(obsListMonths);
    }

}

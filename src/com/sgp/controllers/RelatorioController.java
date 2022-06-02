package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class RelatorioController extends WindowControllerFx {

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        
    }
    
     @Override
    public String getFXML() {
        return "/com/sgp/views/Relatorio.fxml";
    }

    @Override
    public String getTitle() {
        return "Relatorio";
    }
    
}

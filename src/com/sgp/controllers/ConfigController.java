/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class ConfigController extends WindowControllerFx {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public String getFXML() {
        return "/com/sgp/views/Config.fxml";
    }

    @Override
    public String getTitle() {
        return "Configuraçoes";
    }
    
}

package com.sgp.controllers;

import br.com.fandrauss.fx.gui.WindowControllerFx;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author kashiki
 */
public class HomeController extends WindowControllerFx {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @Override
    public String getFXML() {
        return "/com/sgp/views/Home.fxml";
    }

    @Override
    public String getTitle() {
        return "Homepage";
    }
    
    
    
    
}

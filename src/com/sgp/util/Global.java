package com.sgp.util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Global {
    
    public Parent getLocation(String texto) throws IOException {
        return FXMLLoader.load(getClass().getResource(texto));
    }
}

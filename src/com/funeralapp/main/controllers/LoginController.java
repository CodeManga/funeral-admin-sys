/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funeralapp.main.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author HILTON9
 */
public class LoginController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Parent sidebar;
        try {
            sidebar = FXMLLoader.load(getClass().getResource("/com/funeralapp/main/views/Sidebar.fxml"));
//            Parent menubar = FXMLLoader.load(getClass().getResource("/com/funeralapp/main/views/Menubar.fxml"));
            Parent contentArea = FXMLLoader.load(getClass().getResource("/com/funeralapp/main/views/Dashboard.fxml"));
            
//            borderPane.setTop(menubar);
            borderPane.setLeft(sidebar);
            borderPane.setCenter(contentArea);
            
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, "++++++++++", ex);
        }
    }    
    
}

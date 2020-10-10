/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funeralapp.main.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author HILTON9
 */
public class ProfilePopupController implements Initializable {

    @FXML
    private Circle profilePic;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.profilePic.setStroke(Color.WHITESMOKE);
        Image im = new Image("/com/funeralapp/main/media/profile.jpg", false);
        profilePic.setFill(new ImagePattern(im));
    }    
    
}

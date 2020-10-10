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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HILTON9
 */
public class CustomerInformationController implements Initializable {

    @FXML
    private ComboBox<?> title;
    @FXML
    private TextField firstName;
    @FXML
    private TextField middleName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField idNumber;
    @FXML
    private ComboBox<?> maritalStatus;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField policyNumber;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField cellNumber;
    @FXML
    private TextField altNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

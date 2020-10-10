/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funeralapp.main.controllers;

import com.funeralapp.main.model.LoginModel;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HILTON9
 */
public class SignInController implements Initializable {

    @FXML
    private FontAwesomeIcon signInCloseBtn;
    @FXML
    private JFXButton signInBtn;
    @FXML
    private VBox rootPane;
    
    private LoginModel loginModel = new LoginModel();
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label errorMessage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void closeApp(MouseEvent event) {
        if (event.getSource() == signInCloseBtn) {
            System.exit(0);
        }
    }

    @FXML
    private void logIn(MouseEvent event) {
    }

    @FXML
    private void signInMethod(ActionEvent event) {
        try {
            // Todo UI Error input validation
          if (this.loginModel.isLoggedIn(this.username.getText(), this.password.getText())) {
                Stage stage = (Stage)this.signInBtn.getScene().getWindow();
                stage.close();
                this.openDashboard();
            } else {
              this.errorMessage.setText("Wrong login details!");
          }
        } catch (Exception ex) {
            // Todo Create a dialog box to handle this
            ex.printStackTrace();
        }
    }

    private void openDashboard() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/com/funeralapp/main/views/Login.fxml").openStream());
            
            LoginController dashboard = loader.getController();
            
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setResizable(false);
            userStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

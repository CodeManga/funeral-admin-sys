
package com.funeralapp.main.controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 *
 * @author HILTON9
 */
public class MainController implements Initializable {

    @FXML
    private VBox vbox;
    
    private Parent fxml;
    private FontAwesomeIcon closeBtn;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 33);
        t.play();
        t.setOnFinished(e -> {
            this.signIn();
        });
    }    

    @FXML
    private void openSignUp(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(14);
        t.play();
        t.setOnFinished(e -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("/com/funeralapp/main/views/SignUp.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, "Failed to attatch SignUp View.");
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    @FXML
    private void openSignIn(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        t.setToX(vbox.getLayoutX() * 33);
        t.play();
        t.setOnFinished(e -> {
            this.signIn();
        });
    }
    
    private void signIn() {
        try {
            fxml = FXMLLoader.load(getClass().getResource("/com/funeralapp/main/views/SignIn.fxml"));
            vbox.getChildren().removeAll();
            vbox.getChildren().setAll(fxml);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, "Failed to attatch SignIn View.");
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeApp(MouseEvent event) {
        if (event.getSource() == closeBtn) {
            System.exit(0);
        }
    }
}

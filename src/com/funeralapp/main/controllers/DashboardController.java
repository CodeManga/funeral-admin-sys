/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.funeralapp.main.controllers;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.pdfsam.ui.RingProgressIndicator;

/**
 * FXML Controller class
 *
 * @author HILTON9
 */
public class DashboardController implements Initializable {

    @FXML
    private HBox progressBarHBox;
    @FXML
    private FontAwesomeIcon signout;
    
    private VBox vbox;
    
    private Parent fxml;
    @FXML
    private JFXButton pop;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RingProgressIndicator ringProgressIndicator = new RingProgressIndicator("red-circleindicator-container");
        ringProgressIndicator.setRingWidth(10);
        ringProgressIndicator.makeIndeterminate();
        
        RingProgressIndicator ringProgressIndicator1 = new RingProgressIndicator("blue-circleindicator-container");
        ringProgressIndicator1.setRingWidth(10);
        ringProgressIndicator1.makeIndeterminate();

        progressBarHBox.getChildren().add(ringProgressIndicator);
        progressBarHBox.getChildren().add(ringProgressIndicator1);

        new WorkerThread(ringProgressIndicator, 70).start();
        new WorkerThread(ringProgressIndicator1, 40).start();
    }    
    
    @FXML
    private void seetingsBtn(MouseEvent event) {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = loader.load(getClass().getResource("/com/funeralapp/main/views/ProfilePopup.fxml").openStream());
                        
            Scene scene = new Scene(root);
            userStage.setScene(scene);
            userStage.setResizable(false);
            userStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, "Failed to attatch ProfilePopup View.");
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

class WorkerThread extends Thread {
    RingProgressIndicator rpi;
    int progress;
    int i = 0;

    public WorkerThread(RingProgressIndicator rpi, int progress) {
        this.rpi = rpi;
        this.progress = progress;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
//                Logger.getLogger(RingProgressIndicator.class.getName()).log(Level.SEVERE, null, ex);
                  ex.printStackTrace();
            }
            
            Platform.runLater(()-> {
                rpi.setProgress(i);
            });
            
            i++;
            if (progress == i) {
                break;
            }
        }
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class ForgetpasswordController implements Initializable {

    @FXML
    private TextField tfCode;
    @FXML
    private Button btnok;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitok(ActionEvent event) {
        
          if (ResetPasswordController.a==Integer.parseInt(tfCode.getText())){
              TrayNotification tray = new TrayNotification();
        tray.setTitle("succees");
        tray.setMessage("Code Valide");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(4));
                try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("NewPassword.fxml"));
                    Parent root =loader.load();
                  
                    
                    tfCode.getScene().setRoot(root);
                    System.out.println("heloo new password");
                } catch (IOException ex) {
                    Logger.getLogger(ForgetpasswordController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
          
                
            }
            else System.out.println ("nooooooooo");

    }
    }
    


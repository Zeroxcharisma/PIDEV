/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.services.UtilisateurCRUD;
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
import javafx.scene.control.TextField;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class ValideInscriptionController implements Initializable {

    @FXML
    private TextField idValidation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("l'id de cette "+InscrireController.i);
    }    

    @FXML
    private void onClick(ActionEvent event) {
    if (InscrireController.numeroValidation==Integer.parseInt(idValidation.getText())){
            try {
                UtilisateurCRUD u=new UtilisateurCRUD();
                u.setEtat(InscrireController.i);
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
                Parent root =loader.load();
                

                idValidation.getScene().setRoot(root);
                 TrayNotification tray = new TrayNotification();
        tray.setTitle("succees");
        tray.setMessage("validation effectuée   tu peux consulter votre compte");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(4));
            } catch (IOException ex) {
                Logger.getLogger(ValideInscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        else{ 
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Erreur");
        tray.setMessage("code incorrect");
        tray.setNotificationType(NotificationType.ERROR);
        tray.showAndDismiss(Duration.seconds(4));}

    }

  
    
}
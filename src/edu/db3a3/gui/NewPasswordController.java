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
public class NewPasswordController implements Initializable {

    @FXML
    private TextField tfNewpassword;
    @FXML
    private TextField tfConfirmPassword;
    @FXML
    private Button btnmodif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updatePassword(ActionEvent event) {
    if (tfConfirmPassword.getText().equals(tfNewpassword.getText())){
    try {
        UtilisateurCRUD c=new UtilisateurCRUD();
        c.updatePassword(Integer.parseInt(ResetPasswordController.numTelephone),tfNewpassword.getText());
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root =loader.load();
      
        
        tfNewpassword.getScene().setRoot(root);
        TrayNotification tray = new TrayNotification();
        tray.setTitle("succees");
        tray.setMessage("Mots de passe changé");
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(4));
    } catch (IOException ex) {
        Logger.getLogger(NewPasswordController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }}}
    
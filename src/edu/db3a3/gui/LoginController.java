/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Session;
import edu.db3a3.services.UtilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


/**
 * FXML Controller class
 *
 * @author sofie
 */
public class LoginController implements Initializable {

    @FXML
    private TextField loginId;
    @FXML
    private TextField Password;
    @FXML
    private Button btnLogin;
    @FXML
    private Hyperlink inscriptionLink;
    @FXML
    private Hyperlink ForgetPasswordLink;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        try {
            if (loginId.getText().isEmpty()||Password.getText().isEmpty()){
               showAlert(Alert.AlertType.ERROR, Password.getScene().getWindow(), 
    "Form Error!", "Veuillez remplir tous les champs!");
                               
                
            }
            UtilisateurCRUD c=new UtilisateurCRUD();
            String s=c.validerLogin(loginId.getText(),Password.getText());
            
            
            // validation.setText( s);
            if(s.equals("utilisateur correct ")){
               String titleerr = " Bienvenue";
        String messagerr = "Hello  "+loginId.getText()+"  "+c.typeUserView(loginId.getText());
        TrayNotification tray = new TrayNotification();
        tray.setTitle(titleerr);
        tray.setMessage(messagerr);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(4));
             
                
                int p=c.typeUsernumero(loginId.getText());
                Session.id_utilisateur=c.getIdUtilisateur(loginId.getText(),Password.getText());
                System.out.println(p);
                //Admin
                if (p==0){
                    try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("DisplayAll.fxml"));
                    Parent root =loader.load();
                    Password.getScene().setRoot(root);
                    } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                }
                //Client
                if (p==1){
                     try {
                    FXMLLoader loader2=new FXMLLoader(getClass().getResource("Test2.fxml"));
                    Parent root =loader2.load();
                    Password.getScene().setRoot(root);
                     } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                }
                 //Coach
                if (p==2){
                     try {
                    FXMLLoader loader2=new FXMLLoader(getClass().getResource("Test3.fxml"));
                    Parent root =loader2.load();
                    Password.getScene().setRoot(root);
                    } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                    
                }
                //neutreutioniste
                 if (p==3){
                     try {
                    FXMLLoader loader2=new FXMLLoader(getClass().getResource("Test1.fxml"));
                    Parent root =loader2.load();
                    Password.getScene().setRoot(root);
                    } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                    
                }
                
                }
               
              
            else
            {
                
              showAlert(Alert.AlertType.ERROR, Password.getScene().getWindow(), 
    "Form Error!", "utilisateur incorrect!");
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

         

        
    
    }

    @FXML
    private void Inscriptionlink(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Inscrire.fxml"));
            Parent root =loader.load();
            loginId.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void forgetpassword(ActionEvent event) {
           try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("ResetPassword.fxml"));
             Parent root =loader.load();
            Password.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
}
    
}

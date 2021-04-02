/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Session;
import static edu.db3a3.entities.Session.id_utilisateur;
import edu.db3a3.entities.Utilisateur;
import edu.db3a3.services.UtilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class ProfileController implements Initializable {

    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfTelephone;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfAdresse;
    @FXML
    private Button btRetour;
     
     int id= Session.id_utilisateur;
    /**
     * Initializes the controller class.
     */
     
     UtilisateurCRUD c=new UtilisateurCRUD();
     Utilisateur u=new Utilisateur();
    @FXML
    private Hyperlink disconnect;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         u= c.getUtilisaeur(id);
       tfNom.setText(u.getNom());
       tfPrenom.setText(u.getPrenom());
       tfusername.setText(u.getUsername());
       tfPassword.setText(u.getPassword());
     
       tfAdresse.setText(u.getAdresse());
       tfTelephone.setText(String.valueOf(u.getTel()));
    }    
    
  
    @FXML
    private void Retourbtn(ActionEvent event) {
          try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Partieclient.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    @FXML
    private void disconnect(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

   /* private void modifyprof(ActionEvent event) {
       String nom = tfNom.getText();
     String prenom=  tfPrenom.getText();
      String username = tfusername.getText();
     String password =  tfPassword.getText();
     
      String adresse = tfAdresse.getText();
      String tel = tfTelephone.getText();
      String email = tfAdresse.getText();  
        
        
        UtilisateurCRUD pcd = new UtilisateurCRUD();
            pcd.modifierUtilisateurProfile(id_utilisateur,u);
    }
    */
    
}

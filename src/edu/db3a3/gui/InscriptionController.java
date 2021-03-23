/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Utilisateur;
import static edu.db3a3.gui.InscrireController.list;
import edu.db3a3.services.UtilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfRole;
    @FXML
    private TextField tfEtat;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnInscription;
    @FXML
    private ComboBox<String> listAdresse;
    
    public static  ObservableList<String>list=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          list.add("Ariana");
           list.add("Béja");
           list.add("Ben Arous");
           list.add("Bizerte");
           list.add("Gabes ");
           list.add("Gafsa");
           list.add("Jendouba");
           list.add("Kairouan");
           list.add("Kasserine");
           list.add("Kebili");
           list.add("La Mannouba");
           list.add("Le Kef");
           list.add("Mahdia");
           list.add("Medenine");
           list.add("Monastir");
           list.add("Nabeul");
           list.add("Sfax");
           list.add("Sidi Bouzid");
           list.add("Siliana");
           list.add("Sousse");
           list.add("Tataouine");
           list.add("Tozeur");
           list.add("Tunis");
           list.add("Zaghouan");
           listAdresse.setItems(list);
    }    

    @FXML
    private void SaveUser(ActionEvent event) {
    
    String username = tfUsername.getText();
    String nom =tfNom.getText();
    String prenom = tfPrenom.getText();
    String password =tfPassword.getText();
    int tel = Integer.parseInt(tfTel.getText());
   // String adresse=tfAdresse.getText();
     String adresse= listAdresse.getSelectionModel().getSelectedItem();
    int id_role=Integer.parseInt(tfRole.getText());
    int etat=Integer.parseInt(tfEtat.getText());
    String email=tfEmail.getText();
    
    Utilisateur u = new Utilisateur(username,nom,prenom,password,tel,adresse,id_role,etat,email);
    UtilisateurCRUD UC = new UtilisateurCRUD();
    UC.ajouterUtilisateur(u);
    
     try {
            Parent root = FXMLLoader.load(getClass().getResource("DisplayAll.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Dashboard");
            primaryStage.setScene(scene);
         
            primaryStage.show();
            Stage stage1 = (Stage) tfNom.getScene().getWindow();
            stage1.close();
        
      } catch (IOException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    
    
}

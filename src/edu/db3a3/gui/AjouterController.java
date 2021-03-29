/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Panier;
import edu.db3a3.services.panierCRUD;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfqte;
    @FXML
    private Button btnvalider;
    @FXML
    private Button event;
    @FXML
    private Button produit;
    @FXML
    private Button reclamation;
    @FXML
    private Button abonnement;
    @FXML
    private Button panier;
    @FXML
    private Button planning;
    @FXML
    private Label imagePath;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savePanier(ActionEvent event) {
        
        String nom = tfNom.getText();
        int prix = Integer.parseInt(tfPrix.getText());
        int qte = Integer.parseInt(tfqte.getText());
        int total = prix*qte;
        
        Panier p = new Panier(0, nom, prix,qte,total);
        panierCRUD pc = new panierCRUD();
        pc.ajouterPanier2(p);
        
       /* FXMLLoader loader = new FXMLLoader(getClass().getResource("affiche.fxml"));
        
        try {
            Parent root = loader.load();
            AfficheController ac = loader.getController();
            ac.setTextID(""+p.getId());
            ac.setTextNom(p.getNom());
            ac.setTextPrix(""+p.getPrix());
            ac.setTextqte(""+p.getQte());
            ac.setTexttotale(""+p.getTotal());
            
            
           // tfNom.getScene().setRoot(root);
           
            
            
            
        } catch (IOException ex) {
            System.out.println("Error :"+ex.getMessage());
        }
       */
        try {
              Parent exercices_parent = FXMLLoader.load(getClass().getResource("affiche.fxml"));
              Scene ex_section_scene = new Scene(exercices_parent);
              Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
              
              second_stage.setScene(ex_section_scene);
              second_stage.show();
          } catch (IOException ex) {
              
          }    
        TrayNotification tray = null;
        tray = new TrayNotification("panier ajoutee", "Votre commande a ete ajoutee avec succes ,Merci ", NotificationType.SUCCESS);
       
        tray.showAndDismiss(javafx.util.Duration.seconds(5));
}

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void produit(ActionEvent event) {
    }

    @FXML
    private void reclamation(ActionEvent event) {
    }

    @FXML
    private void abonnement(ActionEvent event) {
    }

    @FXML
    private void panier(ActionEvent event) {
    }

    @FXML
    private void planning(ActionEvent event) {
    }
    
 
    
}

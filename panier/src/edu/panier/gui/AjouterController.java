/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.panier.gui;


import edu.panier.entities.Panier;
import edu.panier.services.panierCRUD;
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterController implements Initializable {

    @FXML
    private AnchorPane tfID;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrix;
    @FXML
    private Button btnvalider;

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
        String prix = tfPrix.getText();
        Panier p = new Panier(0, nom, prix);
        panierCRUD pc = new panierCRUD();
        pc.ajouterPanier(p);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("affiche.fxml"));
        
        try {
            Parent root = loader.load();
            AfficheController ac = loader.getController();
            ac.setTextID(""+p.getId());
            ac.setTextNom(p.getNom());
            ac.setTextPrix(p.getPrix());
            
            tfNom.getScene().setRoot(root);
            
            
            
        } catch (IOException ex) {
            System.out.println("Error :"+ex.getMessage());
        }
        
        
    } 
    
}

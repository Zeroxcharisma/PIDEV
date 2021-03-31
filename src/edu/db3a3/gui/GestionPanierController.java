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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class GestionPanierController implements Initializable {

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
    private Button Gcours;
    @FXML
    private Button GExamen;
    @FXML
    private Label ajout;
    @FXML
    private Button user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void event(ActionEvent event) {
         try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Evenement.fxml"));
                Gcours.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(IAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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

    @FXML
    private void cours(ActionEvent event) {
         try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Ajouter.fxml"));
                Gcours.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(IAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }

    @FXML
    private void test(ActionEvent event) {
         try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Affiche.fxml"));
                Gcours.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(IAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void ajout(MouseEvent event) {
    }

    @FXML
    private void user(ActionEvent event) {
    }
    
}

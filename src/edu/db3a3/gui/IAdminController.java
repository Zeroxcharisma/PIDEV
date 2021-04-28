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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class IAdminController implements Initializable {

    @FXML
    private Button Gcours;
    @FXML
    private Button GExamen;
    private Button retour;
    @FXML
    private Button event;
    @FXML
    private Button abonnement;
    @FXML
    private Button produit;
    @FXML
    private Button planning;
    @FXML
    private Button reclamation;
    @FXML
    private Button panier;
    @FXML
    private Button user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      /*   Gcours.setOnAction(e->{
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("GestionCours.fxml"));
                Gcours.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(IAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        });
        GExamen.setOnAction(e->{
            try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("GestionTestFitness.fxml"));
                GExamen.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(IAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }); 
        retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("Acceuil.fxml"));
             retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterTestFitnessController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             }); */
    }    

    @FXML
    private void event(ActionEvent event) {
        
        try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("Evenement.fxml"));
                GExamen.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(IAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void abonnement(ActionEvent event) {
    }


    @FXML
    private void produit(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
	Scene scene = new Scene(root);
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stage.setScene(scene);
	stage.show();
    }

    @FXML
    private void planning(ActionEvent event) {
    }

    @FXML
    private void cours(ActionEvent event) {
        try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("GestionCours.fxml"));
                Gcours.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(IAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void test(ActionEvent event) {
         try {
                Parent root;
                root = FXMLLoader.load(getClass().getResource("GestionTestFitness.fxml"));
                GExamen.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(IAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void reclamation(ActionEvent event) {
    }

    @FXML
    private void panier(ActionEvent event) {
    }

    @FXML
    private void user(ActionEvent event) {
    }
    
}


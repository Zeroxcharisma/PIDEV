/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.Views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

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
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Gcours.setOnAction(e->{
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
            
             }); 
    }    
    
}
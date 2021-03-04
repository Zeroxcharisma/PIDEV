/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.PiD.gui;

import edu.PiD.entities.Reclamation;
import edu.PiD.services.ReclamationCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AddRecController implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfDescription;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterReclamation(ActionEvent event) {
    
           /// SAUVEGARDE DANS LA BD
            String resEmail = tfEmail.getText();
            String resSujet = tfSujet.getText();
               String resDescription = tfDescription.getText();
            Reclamation r = new Reclamation(14, resEmail, resSujet,resDescription,1);
            ReclamationCRUD pcd = new ReclamationCRUD();
            pcd.ajouterReclamation(r);
            JOptionPane.showMessageDialog(null, "Reclamation ajouté");
         
                  
       
            
            
            
        
    

}}

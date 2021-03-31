/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.TestFitness;
import edu.db3a3.services.TestFitnessService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class ModifierTestFitnessController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private Button ajouter;
    @FXML
    private TextField dureeE;
    @FXML
    private DatePicker dateE;
    @FXML
    private Button v;
    @FXML
    private Button r;
    private static TestFitness ex;
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
    @FXML
    private Button user;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                GestionTestFitnessController gec = new GestionTestFitnessController();
        TestFitness exm= gec.getE();
        dureeE.setText(String.valueOf(exm.getDuree()));
        dateE.setValue(LocalDate.now());
        TestFitnessService ex1 = new TestFitnessService();
        retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("GestionTestFitness.fxml"));
             retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(ModifierTestFitnessController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });  
         v.setOnAction(e->{
             //Local(String nom, String adresse, float prix,float surface,int capacite)
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Error");
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Error");
             String du= dureeE.getText();
             String da=dateE.getEditor().getText();
             String ch="";
             Boolean ok =true;
             int qt = -1;
             int test=Integer.parseInt(du);
             if(!du.matches("\\d+")||du.length()==0){
                 ch+="Vous devez entrer un prenom valide!";
                 ok=false;
             }
             else qt = Integer.parseInt(du);
             if(ok==true){
                 
                 TestFitness examen = new TestFitness(qt,da);
                 examen.setId(exm.getId());
                 TestFitnessService es = new TestFitnessService();
                 try {
                     es.updateTestFitness(examen);
                     ch+="Operation effectuée avec success!\n";
                     alert1.setContentText(ch);
                     alert1.show();
                 } catch (SQLException ex) {
                     Logger.getLogger(AjouterTestFitnessController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else {
                 alert.setContentText(ch);
                 alert.show();
             }
        });
         retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("GestionTestFitness.fxml"));
             retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterTestFitnessController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });
      

        

        

        
        
    }    
    public TestFitness getE() {
        return ex;
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

    @FXML
    private void user(ActionEvent event) {
    }
}

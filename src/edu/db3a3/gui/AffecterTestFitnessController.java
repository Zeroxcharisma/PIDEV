/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.TestFitness;
import edu.db3a3.services.TestFitnessService;
import edu.db3a3.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class AffecterTestFitnessController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private Button ajouter;
    @FXML
    private TextField dureE;
    @FXML
    private Button v;
    @FXML
    private Button r;
    @FXML
    private ComboBox<String> cours;
    @FXML
    private DatePicker dateE;
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

         Connection connexion = MyConnection.getInstance().getCnx();
         
         try{
            String sql="select nom from cours";
            Statement ste = connexion.createStatement();
            ResultSet rs=ste.executeQuery(sql);
            while(rs.next())
        {
            cours.getItems().addAll(rs.getString("nom")); 
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierTestFitnessController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
        GestionTestFitnessController gec = new GestionTestFitnessController();
        TestFitness exm= gec.getE();
        dureE.setText(String.valueOf(exm.getDuree()));
        dateE.setValue(LocalDate.now());
        dureE.setEditable(false);
        dateE.setEditable(false);
        retour.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("GestionTestFitness.fxml"));
             retour.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AffecterTestFitnessController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             });  
         v.setOnAction(e->{
             //Local(String nom, String adresse, float prix,float surface,int capacite)
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Error");
             Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Error");
             String du= dureE.getText();
             String da=dateE.getEditor().getText();
             String c = cours.getSelectionModel().getSelectedItem().toString();
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
                 
                 TestFitness testfitness = new TestFitness(qt,c,da);
                 testfitness.setId(exm.getId());
                 TestFitnessService es = new TestFitnessService();
                 try {
                     es.updateTestFitness(testfitness);
                     ch+="Operation effectuée avec success!\n";
                     alert1.setContentText(ch);
                     alert1.show();
                 } catch (SQLException ex) {
                     Logger.getLogger(AffecterTestFitnessController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void produit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
	Scene scene = new Scene(root);
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stage.setScene(scene);
	stage.show();
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

    


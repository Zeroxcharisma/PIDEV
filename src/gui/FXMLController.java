/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abonnement.gui;

import edu.abonnement.entities.abonnement;
import edu.abonnement.services.abonnementCRUD;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField idabo;
    @FXML
    private TextField dureeabo;
    @FXML
    private TextField prixabo;
    @FXML
    private TextField typeabo;
    @FXML
    private Button ajouterabo;
     @FXML
    private Button btnback ;
      private Stage primaryStage;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        abonnementCRUD a = new abonnementCRUD();
        abonnement a1 = new  abonnement ( Integer.parseInt(idabo.getText()),Integer.parseInt(dureeabo.getText()),Integer.parseInt(prixabo.getText()),typeabo.getText());
       a.ajouterAbonnement(a1);
    }
    @FXML
     private void back(ActionEvent event) throws IOException {
        Stage primaryStage = null;
         Stage window = primaryStage;
        Parent rootRec2 = FXMLLoader.load(getClass().getResource("menu.fxml"));;
        Scene rec2 = new Scene(rootRec2);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(rec2);
        app.show();
     }
    
}

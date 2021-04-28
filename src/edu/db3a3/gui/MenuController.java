/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class MenuController implements Initializable {

    @FXML
    private Button event;
    @FXML
    private Button abonnement;
    @FXML
    private Button Reclamation;
    @FXML
    private Button Panier;
    @FXML
    private Button produit;
    @FXML
    private Button planning;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void abonnement(ActionEvent event) {
    }

    @FXML
    private void Reclamation(ActionEvent event) {
    }

    @FXML
    private void Panier(ActionEvent event) {
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
    
}

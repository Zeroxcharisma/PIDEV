/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.abonnement;
import edu.db3a3.services.abonnementCRUD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ClientController implements Initializable {

    @FXML
    private TableView<abonnement> affichage;
    @FXML
    private TableColumn<?, ?> idaff;
    @FXML
    private TableColumn<?, ?> dureeaff;
    @FXML
    private TableColumn<?, ?> prixaff;
    @FXML
    private TableColumn<?, ?> typeaff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       affichage (); 
    }   
     private void affichage (){
  abonnementCRUD a= new abonnementCRUD();
        List<abonnement> list = a.displayabonnement();
        ObservableList<abonnement> liste = FXCollections.observableArrayList(list);
        idaff.setCellValueFactory(new PropertyValueFactory<>("id"));
         dureeaff.setCellValueFactory(new PropertyValueFactory<>("duree"));
          prixaff.setCellValueFactory(new PropertyValueFactory<>("prix"));
           typeaff.setCellValueFactory(new PropertyValueFactory<>("type"));
        affichage.setItems(liste);
    
}}

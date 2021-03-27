/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.panier.gui;

import edu.panier.entities.Panier;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheController implements Initializable {
    
    @FXML
    private TableView<Panier> table;

    @FXML
    private TableColumn<Panier, Integer> id;

    @FXML
    private TableColumn<Panier, String> nom;

    @FXML
    private TableColumn<Panier, String> prix;
  
    ObservableList<Panier> list = FXCollections.observableArrayList(

      
        
      
    );
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<Panier,Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Panier,String>("nom"));
        prix.setCellValueFactory(new PropertyValueFactory<Panier,String>("prix"));
        
        table.setItems(list);
    }    

    
    public void setTextID(String message) {
        this.id.setText(message);
    }

    public void setTextNom(String message) {
        this.nom.setText(message);
    }

    public void setTextPrix(String message) {
        this.prix.setText(message);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Participation;
import edu.db3a3.entities.Utilisateur;
import edu.db3a3.services.ParticipationCrud;
import edu.db3a3.services.UtilisateurCRUD;
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
 * @author sofie
 */
public class ShowparticpationController implements Initializable {
    @FXML
    private TableView<Participation> table;

    @FXML
    private TableColumn<Participation, String> coltype;
    @FXML
    private TableColumn<Participation, String> coledcr;
    @FXML
    private TableColumn<Participation, String> coldate;
    @FXML
    private TableColumn<Participation, Integer> colid;
 //public static ObservableList<Participation> listea=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
int id= edu.db3a3.entities.Session.id_utilisateur;
 UtilisateurCRUD s=new UtilisateurCRUD();
     Utilisateur u=new Utilisateur();
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         
  
    
    
        
       ParticipationCrud a =new ParticipationCrud();
        System.out.println(id);
         
         
              //  List<Participation> list = a.geteventsss(id);
        ObservableList<Participation> liste = FXCollections.observableArrayList(a.geteventsss(id));
           
     //   System.out.println("showparticipation"+listea);
         coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
           coledcr.setCellValueFactory(new PropertyValueFactory<>("dcr"));
             coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
               colid.setCellValueFactory(new PropertyValueFactory<>("id_event"));
      
               table.setItems(liste); 
               
              
        
        // TODO
    }    
    
    
}

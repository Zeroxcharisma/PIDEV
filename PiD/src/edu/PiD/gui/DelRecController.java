/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.PiD.gui;

import edu.PiD.entities.Reclamation;
import edu.PiD.services.ReclamationCRUD;
import edu.PiD.tools.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class DelRecController implements Initializable {

   @FXML
    private TableView<Reclamation> tableRec;
    @FXML
    private TableColumn<Reclamation, Integer> coId;
    @FXML
    private TableColumn<Reclamation, String> coEmail;
    @FXML
    private TableColumn<Reclamation, String> coSujet;
    @FXML
    private TableColumn<Reclamation, String> coDescription;
     public static  ObservableList<Reclamation>reclamationlist=FXCollections.observableArrayList();
    @FXML
    private Button btnDel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        try {
              Connection c= MyConnection.getInstance().getCnx();
          PreparedStatement pt;
              pt = c.prepareStatement("SELECT id,email,sujet,description from reclamation");
             // String requete = "select id_utilisateur,username,nom,prenom,email,tel,adresse,id_role,etat from utilisateur";
              ResultSet rs=pt.executeQuery();
               
              while(rs.next()){
                Reclamation r = new Reclamation();
                r.setId(rs.getInt("id"));
                r.setEmail(rs.getString(2));
                r.setSujet(rs.getString(3));
                r.setDescription(rs.getString(4));
            
                
               // p.setEmail(rs.getString(10));
                reclamationlist.add(r);}   
               //oblist.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("username"),rs.getString("nom"),rs.getInt("tel"),rs.getString("email"),rs.getString("prenom"),rs.getString("adresse"),String.valueOf(rs.getInt("id_role")),String.valueOf(rs.getInt("etat")),new Button("update"),new Button("delete")));}
               // oblist.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("adresse"),rs.getString("role"),rs.getInt("etat"),new Button("update"),new Button("delete")));}
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }
           coId.setCellValueFactory(new PropertyValueFactory<>("id"));
         coEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
         coSujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
         coDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
         
       
         
         
         
                 
         tableRec.setItems(reclamationlist);
    }    

    @FXML
    private void supprimerReclamation(ActionEvent event) {
          Reclamation r =tableRec.getSelectionModel().getSelectedItem();
    ReclamationCRUD UC = new ReclamationCRUD();
    UC.supprimerReclamation(r);
    }
    
}

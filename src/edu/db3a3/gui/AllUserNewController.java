/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Utilisateur;
import edu.db3a3.services.CrudRole;
import edu.db3a3.services.UtilisateurCRUD;
import edu.db3a3.tools.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class AllUserNewController implements Initializable {
    public static ObservableList<Utilisateur> liste2=FXCollections.observableArrayList();
     public static ObservableList<Utilisateur> liste=FXCollections.observableArrayList();
     public static ObservableList<Utilisateur> listeEdit=FXCollections.observableArrayList();
     public static TableView<Utilisateur> table2;
    @FXML
    private TableView<Utilisateur> table;
    @FXML
    private TableColumn<Utilisateur, String> colidUtilisateur;
    @FXML
    private TableColumn<Utilisateur, String> colusername;
    @FXML
    private TableColumn<Utilisateur, String> colnom;
    @FXML
    private TableColumn<Utilisateur, String> colprenom;
    @FXML
    private TableColumn<Utilisateur, String> colemail;
    @FXML
    private TableColumn<Utilisateur, String> coltel;
    @FXML
    private TableColumn<Utilisateur, String> coladresse;
    @FXML
    private TableColumn<Utilisateur, String> colrole;
    @FXML
    private TableColumn<Utilisateur, String> coletat;
    @FXML
    private TextField searchBox;
    private ObservableList<Utilisateur> masterData = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          table2=table;
     initTable();
              FilteredList<Utilisateur> filteredData = new FilteredList<>(masterData, k-> true);
              searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
                  System.out.println("aaaaaa");
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (person.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
              }
                 if (person.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
              }
                  if (person.getPrenom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
              }
             
                    return false; // Does not match.
            });
        });
               SortedList<Utilisateur> sortedData = new SortedList<>(filteredData);
                sortedData.comparatorProperty().bind(table.comparatorProperty());
                table.setItems(sortedData);
   //  table3=table;
    }    
      private void initTable(){
        intiCols();
    }
      private void intiCols() {
          UtilisateurCRUD u=new UtilisateurCRUD();
            Connection c= MyConnection.getInstance().getCnx();
        try {
             PreparedStatement pt;
            pt = c.prepareStatement("select id_utilisateur,nom,prenom,etat,libelle,tel,adresse,username,email from utilisateur INNER JOIN role where utilisateur.id_role=role.id_role");
           ResultSet rs=pt.executeQuery();
               CrudRole p=new CrudRole();
               String m=null;
              while(rs.next()){
                 
                  if (rs.getInt("etat")==0){
                      m="Activer";
                      
                  }
                  else m="Bloquer";
                System.out.println (rs.getString("libelle"));
                

                liste.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("tel"),rs.getString("libelle"),m,rs.getString("username"),rs.getString("email"),rs.getString("adresse")));
              masterData.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("tel"),rs.getString("libelle"),m,rs.getString("username"),rs.getString("email"),rs.getString("adresse")));
           
              } } catch (SQLException ex) {
              Logger.getLogger(AllUserNewController.class.getName()).log(Level.SEVERE, null, ex);
          }
      
         colidUtilisateur.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
          
           colusername.setCellValueFactory(new PropertyValueFactory<>("username"));
           
             colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
               colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                 colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                
                   coltel.setCellValueFactory(new PropertyValueFactory<>("tel"));
                   

                  // setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
                     coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                      
                   colrole.setCellValueFactory(new PropertyValueFactory<>("l"));
                   
                   coletat.setCellValueFactory(new PropertyValueFactory<>("m"));
                   
                   
                   
                   
                   
          
         
       //  initcol();
         table.setItems(liste);
       System.out.println(masterData);
      }
      

    
       
    @FXML
    void handleOrganisationDebloquer(ActionEvent event) {
            Utilisateur or= table.getSelectionModel().getSelectedItem();
    if(or== null)
    {//msg alertt
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Debloquer user");
alert.setHeaderText(null);
alert.setContentText("Vous devez selectionnez un utilisateur!");

alert.showAndWait();
        return;
            }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("bloquer utilisateur");
    alert.setContentText("Voulez vous vraiment debloquer "+or.getNom());
    Optional<ButtonType> reponse=alert.showAndWait();
    if(reponse.get() == ButtonType.OK)
    {
    UtilisateurCRUD c = new UtilisateurCRUD();
    boolean rep = c.debloquer(or.getId_utilisateur());
    
    
     Alert alert2 = new Alert(Alert.AlertType.WARNING);
        alert2.setTitle("Debloquer un  utilisateur");
alert2.setHeaderText(null);
    if(rep== true)
    {
    
alert2.setContentText("le compte de "+or.getNom()+"  est activé ");

alert2.showAndWait();
 UtilisateurCRUD u=new UtilisateurCRUD();
            Connection c1= MyConnection.getInstance().getCnx();
        try {
             PreparedStatement pt;
            pt = c1.prepareStatement("select id_utilisateur,nom,prenom,etat,libelle,tel,adresse,username,email from utilisateur INNER JOIN role where utilisateur.id_role=role.id_role");
           ResultSet rs=pt.executeQuery();
               CrudRole p=new CrudRole();
               String m=null;
              while(rs.next()){
                 
                  if (rs.getInt("etat")==0){
                      m="Activer";
                      
                  }
                  else m="Bloquer";
                System.out.println (rs.getString("libelle"));
               
                liste2.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("tel"),rs.getString("libelle"),m,rs.getString("username"),rs.getString("email"),rs.getString("adresse")));
              } } catch (SQLException ex) {
              Logger.getLogger(AllUserNewController.class.getName()).log(Level.SEVERE, null, ex);
          }
         colidUtilisateur.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
           colusername.setCellValueFactory(new PropertyValueFactory<>("username"));
             colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
               colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                 colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                   coltel.setCellValueFactory(new PropertyValueFactory<>("tel"));
                   

                  // setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
                     coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                   colrole.setCellValueFactory(new PropertyValueFactory<>("l"));
                    coletat.setCellValueFactory(new PropertyValueFactory<>("m"));
                 
         
       //  initcol();
       table.getItems().removeAll(liste);
         table.setItems(liste2);
      
//intiCols()
            
    }
    else
     alert2.setContentText("echec : le compte d'utilisateur "+or.getNom()+" n'est pas activé ");   
   
    
    
    }
    else
    {
     Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Dialogue d'alerte");
alert1.setHeaderText(null);
alert1.setContentText("Debloquage annulé !");

alert1.showAndWait();
    }
        

    }
    @FXML
private     void handleOrganisationOndeleteAction(ActionEvent event) {
    
    Utilisateur or= table.getSelectionModel().getSelectedItem();
    System.out.println(or);
   if(or== null)
    {//msg alertt
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Bloquer user");
alert.setHeaderText(null);
alert.setContentText("tu peux pas bloquer un admin!");

alert.showAndWait();
        return;
            
            
            }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Bloquer user");
    alert.setContentText("Voulez vous vraiment bloquer "+or.getNom());
    Optional<ButtonType> reponse=alert.showAndWait();
    if(reponse.get() == ButtonType.OK)
    {
    UtilisateurCRUD c = new UtilisateurCRUD();
    boolean rep = c.bloquer(or.getId_utilisateur());
    
    
     Alert alert2 = new Alert(Alert.AlertType.WARNING);
        alert2.setTitle("Bloquer un  utilisateur");
alert2.setHeaderText(null);
    if(rep== true)
    {
    
alert2.setContentText(or.getNom()+"  est bloqué ");

alert2.showAndWait();
 UtilisateurCRUD u=new UtilisateurCRUD();
            Connection c1= MyConnection.getInstance().getCnx();
        try {
             PreparedStatement pt;
            pt = c1.prepareStatement("select  id_utilisateur,nom,prenom,etat,libelle,tel,adresse,username,email from utilisateur INNER JOIN role where utilisateur.id_role=role.id_role");
           ResultSet rs=pt.executeQuery();
               CrudRole p=new CrudRole();
               String m=null;
              while(rs.next()){
                 
                  if (rs.getInt("etat")==0){
                      m="Activer";
                      
                  }
                  else m="Bloquer";
                System.out.println (rs.getString("libelle"));
               
                liste2.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("nom"),rs.getString("prenom"),rs.getInt("tel"),rs.getString("libelle"),m,rs.getString("username"),rs.getString("email"),rs.getString("adresse")));
              } } catch (SQLException ex) {
              Logger.getLogger(AllUserNewController.class.getName()).log(Level.SEVERE, null, ex);
          }
       
         colidUtilisateur.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
           colusername.setCellValueFactory(new PropertyValueFactory<>("username"));
             colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
               colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                 colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                   coltel.setCellValueFactory(new PropertyValueFactory<>("tel"));
                   

                  // setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
                     coladresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
                   colrole.setCellValueFactory(new PropertyValueFactory<>("l"));
                    coletat.setCellValueFactory(new PropertyValueFactory<>("m"));
                 
         
       //  initcol();
       
       
        table.getItems().removeAll(liste);
         table.setItems(liste2);
      
//intiCols()
            
    }
    else
     alert2.setContentText("echec : utilisateur "+or.getNom()+" n'est pas bloquer ");   
   
    
    
    }
    else
    {
     Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Dialogue d'alerte");
alert1.setHeaderText(null);
alert1.setContentText("Bloquer annulé !");

alert1.showAndWait();
    }

    }

  
    
}



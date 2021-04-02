/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Utilisateur;
import edu.db3a3.services.UtilisateurCRUD;
import edu.db3a3.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class DisplayAllController implements Initializable {

    @FXML
    private TableView<Utilisateur> table;
    public static  TableView<Utilisateur> table2;
    
    @FXML
    private TableColumn<Utilisateur, String> col_id;
    @FXML
    private TableColumn<Utilisateur, String> col_username;
    @FXML
    private TableColumn<Utilisateur, String> col_nom;
    @FXML
    private TableColumn<Utilisateur, String> col_prenom;
    @FXML
    private TableColumn<Utilisateur, String> col_email;
    @FXML
    private TableColumn<Utilisateur, String> col_tel;
    @FXML
    private TableColumn<Utilisateur, String> col_adresse;
    @FXML
    private TableColumn<Utilisateur, String> col_role;
    @FXML
    private TableColumn<Utilisateur, String> col_etat;
   
    
    public static  ObservableList<Utilisateur>oblist=FXCollections.observableArrayList();
    public static int id;
  
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button ajouter;
    @FXML
    private Button block;
    @FXML
    private Button btnstat;
    private Hyperlink profile;
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
    @FXML
    private Hyperlink disconnect;
 

    /**
     * Initializes the controller class.
     */
    @Override
       public void initialize(URL location, ResourceBundle resources) {
   
          
         table2=table;
        /*  try {
              Connection c= MyConnection.getInstance().getCnx();
          PreparedStatement pt;
              pt = c.prepareStatement("SELECT id_utilisateur,username,nom,prenom,email,tel,adresse,id_role,etat from utilisateur");
             // String requete = "select id_utilisateur,username,nom,prenom,email,tel,adresse,id_role,etat from utilisateur";
              ResultSet rs=pt.executeQuery();
               
              while(rs.next()){
                Utilisateur p = new Utilisateur();
                p.setId_utilisateur(rs.getInt("id_utilisateur"));
                p.setUsername(rs.getString(2));
                p.setNom(rs.getString(3));
                p.setPrenom(rs.getString(4));
                p.setEmail(rs.getString(5));
                p.setTel(rs.getInt("tel"));
                p.setAdresse(rs.getString(7));
                p.setId_role(rs.getInt(8));
                p.setEtat(rs.getInt("etat"));
                
            
            
               // p.setEmail(rs.getString(10));
                oblist.add(p);}
                
                
            //   oblist.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("username"),rs.getString("nom"),rs.getInt("tel"),rs.getString("email"),rs.getString("prenom"),rs.getString("adresse"),String.valueOf(rs.getInt("id_role")),String.valueOf(rs.getInt("etat")),new Button("update"),new Button("delete")));}
               // oblist.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("adresse"),rs.getString("role"),rs.getInt("etat"),new Button("update"),new Button("delete")));}
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }
           
              */
        UtilisateurCRUD u = new UtilisateurCRUD();
        
         col_id.setCellValueFactory(new PropertyValueFactory<>("id_utilisateur"));
         col_username.setCellValueFactory(new PropertyValueFactory<>("username"));
         col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
         col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
         col_tel.setCellValueFactory(new PropertyValueFactory<>("tel"));
         col_adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
         col_role.setCellValueFactory(new PropertyValueFactory<>("id_role"));
         col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        
                 
         
         
         
                 
         table.setItems(u.afficherUtilisateur3());
         
                       
         edittabcol();
       }
       
        private void edittabcol(){
                    
                        col_username.setCellFactory(TextFieldTableCell.forTableColumn());
                        col_username.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setUsername(e.getNewValue());
                        });
                         col_nom.setCellFactory(TextFieldTableCell.forTableColumn());
                        col_nom.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setNom(e.getNewValue());
                        });
                         col_prenom.setCellFactory(TextFieldTableCell.forTableColumn());
                        col_prenom.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrenom(e.getNewValue());
                        });
                        col_email.setCellFactory(TextFieldTableCell.forTableColumn());
                        col_email.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setEmail(e.getNewValue());
                        });
                    //   col_tel.setCellFactory(TextFieldTableCell.forTableColumn());
                    //    col_tel.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setTel(e.getNewValue());
                    //    });
                        col_adresse.setCellFactory(TextFieldTableCell.forTableColumn());
                        col_adresse.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setAdresse(e.getNewValue());
                        });
                     //   col_role.setCellFactory(TextFieldTableCell.forTableColumn());
                    //    col_role.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setId_role(e.getNewValue());
                    //    });
                     //   col_etat.setCellFactory(TextFieldTableCell.forTableColumn());
                     //   col_etat.setOnEditCommit(e->{e.getTableView().getItems().get(e.getTablePosition().getRow()).setEtat(e.getNewValue());
                     //   });
                        
                          
                         table.setEditable(true);
                       
    }
    

    @FXML
    private void UpdateUser(ActionEvent event) {
    }

    @FXML
    private void DeleteUser(ActionEvent event) {
     Utilisateur u =table.getSelectionModel().getSelectedItem();
           if(u== null)
    {//msg alertt
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Supprimer Utilisateur");
alert.setHeaderText(null);
alert.setContentText("Vous devez selectionnez un utilisateur!");

alert.showAndWait();
        return;
            }
        
   
    UtilisateurCRUD UC = new UtilisateurCRUD();
    UC.supprimerUtilisateur(u);
     table.setItems(UC.afficherUtilisateur3());
    
      
    
    
    }

    @FXML
    private void AddUser(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inscription.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            stage.setTitle("Ajouter Utilisateur");
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    
    
    @FXML
    private void ModifyUser(MouseEvent event) {
        try {
            
     
            
            
            
    Utilisateur u =table2.getSelectionModel().getSelectedItem();
             
               
                       
    if(u== null)
    {//msg alertt
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Modifier Utilisateur");
alert.setHeaderText(null);
alert.setContentText("Vous devez selectionnez un utilisateur!");

alert.showAndWait();
        return;
            }
                 id=u.getId_utilisateur();
               
                     
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyUser.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            stage.setTitle("Modifier Utilisateur");
           
            
               
             System.out.println(u);
             System.out.println(u.getId_utilisateur());    
             
            
             
             
       
             
             
             
             
          //  UtilisateurCRUD UC = new UtilisateurCRUD();
           // UC.modifierUtilisateur(u);
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int idd(){
        return id ;
    }

    @FXML
    private void blockuser(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AllUserNewController.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            stage.setTitle("Blocker/Deblocker Utilisateur");
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void stat(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistiques.fxml"));
            Parent root =loader.load();
             
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            stage.setTitle("Statistiques");
            
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void linkprofile(ActionEvent event) {
         try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root =loader.load();
            profile.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DisplayAllController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void produit(ActionEvent event) {
    }

    @FXML
    private void reclamation(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("DelRec.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    @FXML
    private void abonnement(ActionEvent event) {
        try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    @FXML
    private void panier(ActionEvent event) {
        try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("GestionPanier.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    @FXML
    private void planning(ActionEvent event) {
           try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("IAdmin.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    @FXML
    private void user(ActionEvent event) {
    }

    @FXML
    private void disconnect(ActionEvent event) {
          try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }
   
   
}

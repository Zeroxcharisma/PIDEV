/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import com.sun.jmx.snmp.SnmpOidTable;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import edu.db3a3.entities.Utilisateur;
import static edu.db3a3.gui.DisplayAllController.table2;
import edu.db3a3.services.UtilisateurCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class ModifyUserController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tefTel;
    @FXML
    private TextField telAdresse;
    @FXML
    private TextField tfRole;
    @FXML
    private TextField tfEtat;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnmodifier;
    private TextField id_user;
    DisplayAllController a = new DisplayAllController();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           
           
           UtilisateurCRUD uc = new UtilisateurCRUD();
           
           Utilisateur aa = new Utilisateur();
                aa=uc.getUtilisaeur(a.idd());
        System.out.println(aa);
                 
                  
       tfUsername.setText(String.valueOf(aa.getUsername()));
       tfNom.setText(aa.getNom());
      tfPrenom.setText(aa.getPrenom());
       tfPassword.setText(aa.getPassword());
       tefTel.setText(String.valueOf(aa.getTel()));
     telAdresse.setText(aa.getAdresse());
     tfRole.setText(String.valueOf(aa.getId_role()));
         tfEtat.setText(String.valueOf(aa.getEtat()));
      tfEmail.setText(aa.getEmail());  
    }    

    @FXML
    private void ModifyUser(ActionEvent event) {
        
       
       
        
      
            int Id_user=a.idd();
            
            String Username=tfUsername.getText();
            String nom=tfNom.getText();
            String prenom=tfPrenom.getText();
            String password=tfPassword.getText();
            String telephone=tefTel.getText();
            String adresse=telAdresse.getText();
            String role = tfRole.getText();
            String etat = tfEtat.getText();
            String email = tfEmail.getText();
            int opt = JOptionPane.showConfirmDialog(null, "Confirmer la Modification ?","Modifier",JOptionPane.YES_NO_OPTION);
      if(opt==0){
            UtilisateurCRUD pcd = new UtilisateurCRUD();
            pcd.modifierUtilisateur2(String.valueOf(Id_user),Username,nom,prenom,password,telephone,adresse,role,etat,email);
      }  
            try {
            Parent root = FXMLLoader.load(getClass().getResource("DisplayAll.fxml"));
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Dashboard");
            primaryStage.setScene(scene);
         
            primaryStage.show();
            Stage stage1 = (Stage) tfNom.getScene().getWindow();
            stage1.close();
        
      } catch (IOException ex) {
            Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
          
        
    }
    
    
      
}

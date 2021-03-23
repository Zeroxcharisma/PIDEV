/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;


import edu.db3a3.entities.Utilisateur;
import edu.db3a3.services.UtilisateurCRUD;
import edu.db3a3.tools.SmsSender;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import sun.security.validator.Validator;






/**
 * FXML Controller class
 *
 * @author sofie
 */
public class ResetPasswordController implements Initializable {

    @FXML
    private TextField tfCode;
    @FXML
    private Button btnSend;
    Utilisateur sa =new Utilisateur();
 public static int a =(int) (Math.random()*9999);
 public  static String numTelephone ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SendCode(ActionEvent event) {
         
        System.out.println("sofiene");
    UtilisateurCRUD f=new UtilisateurCRUD();
    System.out.println(tfCode.getText());  
    if ((!tfCode.getText().matches("\\d{8}" ))||(tfCode.getText().equals(""))) {
     System.out.println("utilisateur incorrecte");
    }
    
     

    
   
    else{
              numTelephone =tfCode.getText();
              SmsSender s = new SmsSender();
              s.send(String.valueOf(a),numTelephone);
              
         
              
              
           
            
              try {
                FXMLLoader loader2=new FXMLLoader(getClass().getResource("Forgetpassword.fxml"));
             Parent root =loader2.load();
             tfCode.getScene().setRoot(root);
                } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }


          
             }

    }
    





    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Utilisateur;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import static java.util.Collections.list;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Window;
import javafx.util.Duration;
import java.util.*;
import static java.util.Collections.list;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class InscrireController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfTel;
    private TextField tfAdresse;
    @FXML
    private TextField tfEmail;
    @FXML
    private Button btnInscription;
    @FXML
    private TextField tfRole;
    @FXML
    private TextField tfEtat;
    @FXML
    private ComboBox<String> listeRole;
    @FXML
    private ComboBox<String> listAdresse;
 

    
    
    
     private boolean isEditMode=Boolean.FALSE;
     static int numeroValidation =(int) (Math.random()*9999);
     static int i;
     
     public static  ObservableList<String>list=FXCollections.observableArrayList();
     public static  ObservableList<String>list2=FXCollections.observableArrayList();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           list.add("Coach");
           list.add("nutritionniste");
           list.add("Client");
           listeRole.setItems(list);
       
           
           
           list2.add("Ariana");
           list2.add("Béja");
           list2.add("Ben Arous");
           list2.add("Bizerte");
           list2.add("Gabes ");
           list2.add("Gafsa");
           list2.add("Jendouba");
           list2.add("Kairouan");
           list2.add("Kasserine");
           list2.add("Kebili");
           list2.add("La Mannouba");
           list2.add("Le Kef");
           list2.add("Mahdia");
           list2.add("Medenine");
           list2.add("Monastir");
           list2.add("Nabeul");
           list2.add("Sfax");
           list2.add("Sidi Bouzid");
           list2.add("Siliana");
           list2.add("Sousse");
           list2.add("Tataouine");
           list2.add("Tozeur");
           list2.add("Tunis");
           list2.add("Zaghouan");
           listAdresse.setItems(list2);
       
        // TODO
    } 
    
    
     void Link(ActionEvent event) throws IOException {
      
  FXMLLoader loader=new FXMLLoader(getClass().getResource("AllUserNewController.fxml"));
            Parent root =loader.load();
             tfPrenom.getScene().setRoot(root);
    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.initOwner(owner);
    alert.show();
}
       void number(ActionEvent event) {

    }

    @FXML
    private void addUser(ActionEvent event) throws SQLException {
        
            if (tfUsername.getText().isEmpty()||tfNom.getText().isEmpty()||tfPrenom.getText().isEmpty()||tfPassword.getText().isEmpty()||tfTel.getText().isEmpty()||tfEmail.getText().isEmpty()){
                showAlert(Alert.AlertType.ERROR, tfNom.getScene().getWindow(),
                        "Form Error!", "Veuillez remplir tous les champs!");}
            
            
            
            String username = tfUsername.getText();
            String nom =tfNom.getText();
            String prenom = tfPrenom.getText();
            String password =tfPassword.getText();
            int tel = Integer.parseInt(tfTel.getText());
            String adresse= listAdresse.getSelectionModel().getSelectedItem();
             int id_role=0;
             if(listeRole.getSelectionModel().getSelectedItem()=="Coach"){
                  id_role=2;
             }
             if(listeRole.getSelectionModel().getSelectedItem()=="nutritionniste"){
                  id_role=3;
             }
             if(listeRole.getSelectionModel().getSelectedItem()=="Client"){
                  id_role=1;
             }
            
            int etat=0;
            String email=tfEmail.getText();
            
            Utilisateur u = new Utilisateur(username,nom,prenom,password,tel,adresse,id_role,0,email);
            UtilisateurCRUD UC = new UtilisateurCRUD();
            
            
            String s=UC.ajouterUtilisateur2(u);
            TrayNotification tray = new TrayNotification();
            tray.setTitle("Succees");
            tray.setMessage(tfUsername.getText()+" est inscrit");
            tray.setNotificationType(NotificationType.SUCCESS);
            tray.showAndDismiss(Duration.seconds(4));
            
            
            i=UC.getIdUtilisateur(tfUsername.getText(),tfPassword.getText());
            
            System.out.println(i);
            
            if (tfUsername.getText().isEmpty()||tfNom.getText().isEmpty()||tfPrenom.getText().isEmpty()||tfPassword.getText().isEmpty()||tfTel.getText().isEmpty()||tfEmail.getText().isEmpty())
            {
                showAlert(Alert.AlertType.ERROR, tfUsername.getScene().getWindow(),
                        "Form Error!", "Please enter your name");}
            
            
             if (s.equals("non valide")){
                    showAlert(Alert.AlertType.ERROR, tfNom.getScene().getWindow(),
                            "Form Error!", "deja existant");
                    
                    
                }
                
                if (s.equals("vous ete inscrit")){
                    
                    
                    try{
                        String host ="smtp.gmail.com" ;
                        String user = "pidevusers@gmail.com";
                        String pass = "Pidev123*";
                        String to =tfEmail.getText() ;
                        String from ="pidevusers@gmail.com" ;
                        String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
                        String messageText = "Your Is Test Email : le numero de validation:"+numeroValidation;
                        boolean sessionDebug = false;
                        
                        Properties props = System.getProperties();
                        
                        props.put("mail.smtp.starttls.enable", "true");
                        props.put("mail.smtp.host", host);
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.required", "true");
                        
                        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                        Session mailSession = Session.getDefaultInstance(props, null);
                        mailSession.setDebug(sessionDebug);
                        Message msg = new MimeMessage(mailSession);
                        msg.setFrom(new InternetAddress(from));
                        InternetAddress[] address = {new InternetAddress(to)};
                        msg.setRecipients(Message.RecipientType.TO, address);
                        msg.setSubject(subject); msg.setSentDate(new Date());
                        msg.setText(messageText);
                        
                        Transport transport=mailSession.getTransport("smtp");
                        transport.connect(host, user, pass);
                        transport.sendMessage(msg, msg.getAllRecipients());
                        transport.close();
                        System.out.println("message send successfully");
                    }catch(Exception ex)
                    {
                        System.out.println(ex);
                      
                        showAlert(Alert.AlertType.ERROR, tfNom.getScene().getWindow(),
                                "PROBLEM", "INVALID EMAIL");
                        
                    }
                    
                    try {
                        FXMLLoader loader2=new FXMLLoader(getClass().getResource("valideInscription.fxml"));
                        Parent root;
                        root = loader2.load();
                        
                        ValideInscriptionController irc= loader2.getController();
                        
                      
                        tfTel.getScene().setRoot(root);
                    } catch (IOException ex) {
                        Logger.getLogger(InscrireController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
               
            }  
       
        
    

    
    }


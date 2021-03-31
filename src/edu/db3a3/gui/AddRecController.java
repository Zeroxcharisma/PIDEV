/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import com.twilio.rest.wireless.v1.Command.Transport;
import edu.db3a3.entities.Reclamation;
import edu.db3a3.entities.Utilisateur;

import static edu.db3a3.gui.ResetPasswordController.numTelephone;
import edu.db3a3.services.ReclamationCRUD;
import edu.db3a3.services.UtilisateurCRUD;
import edu.db3a3.tools.Sms;
import edu.db3a3.tools.SmsSender;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AddRecController implements Initializable {

    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfEmail;
    @FXML
    private ComboBox tfSujet;
    @FXML
    private TextField tfDescription;
    String c = "Reclamtion sur coach";
    @FXML
    private ComboBox como2;
    @FXML
    private Label liste;
    
public  static String numTelephone ;
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
    int id= edu.db3a3.entities.Session.id_utilisateur;
    
    
     UtilisateurCRUD s=new UtilisateurCRUD();
     Utilisateur u=new Utilisateur();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      u= s.getUtilisaeur(id);
      tfEmail.setText(u.getEmail());
       // tfEmail.setText("jessymina.jc@gmail.com");
        
        ObservableList<String> list = FXCollections.observableArrayList("Reclamtion sur coach","Autre");
          como2.setVisible(false);
      liste.setVisible(false);
          
      
     
         tfSujet.setItems(list);
    }    

    @FXML
    private void ajouterReclamation(ActionEvent event) {
        if (tfEmail.getText().isEmpty()|tfDescription.getText().isEmpty()|(tfSujet.getSelectionModel().isEmpty() && como2.getSelectionModel().isEmpty())){
         
        Notifications notificationBuilder = Notifications.create()
 
                    .title("ERREUR")
                    .text("Veuillez remplir les champs")
                
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.show();   
     }else{
if(como2.isVisible()){
    

        Utilisateur user = (Utilisateur) como2.getSelectionModel().getSelectedItem();   
        int id_utilisateur= user.getId_utilisateur();
         if ( id_utilisateur>0){
             
       
         ReclamationCRUD rec = new ReclamationCRUD();
           /// SAUVEGARDE DANS LA BD
            String resEmail = tfEmail.getText();
            String resSujet = tfSujet.getSelectionModel().getSelectedItem().toString();
           
           
           
            String resDescription = tfDescription.getText();
            Reclamation r = new Reclamation(14, resEmail, resSujet,resDescription,1,"",id_utilisateur);
            ReclamationCRUD pcd = new ReclamationCRUD();
            if(rec.getNumberOfReclamation(id_utilisateur)>2){
            rec.coachBanner(id_utilisateur);
            
            
              numTelephone =String.valueOf(user.getTel());
              Sms s = new Sms();
              System.out.print(numTelephone);
              s.send("votre compte a été bloqué à cause d'un nombre de reclamation",numTelephone);
          
            }
            pcd.ajouterReclamation(r);
            JOptionPane.showMessageDialog(null, "Reclamation ajouté");
         
                    }
}
         else {
              /// SAUVEGARDE DANS LA BD
            String resEmail = tfEmail.getText();
            String resSujet = tfSujet.getSelectionModel().getSelectedItem().toString();
               String resDescription = tfDescription.getText();
            Reclamation r = new Reclamation(12, resEmail, resSujet,resDescription,1,"");
            ReclamationCRUD pcd = new ReclamationCRUD();
            pcd.ajouterReclamation2(r);
            JOptionPane.showMessageDialog(null, "Reclamation ajouté");
         
         }
        
          
sendMail();





            
        TrayNotification tray = null;
        tray = new TrayNotification("Reclamation envoyée", "Cher client votre réclamation a été prise en compte et sera traitée dès que possible,Cordialement ", NotificationType.SUCCESS);
       
        tray.showAndDismiss(javafx.util.Duration.seconds(5));
    
        }
}
    @FXML
    public void comoboxdis(){
    ReclamationCRUD r = new ReclamationCRUD();
 List<Utilisateur> user=  user= r.getAllCoachs();
 ObservableList<Utilisateur> utili = FXCollections.observableArrayList();
 
if(tfSujet.getSelectionModel().getSelectedItem().equals(c)){
liste.setVisible(true);
como2.setVisible(true);
for(Utilisateur e : user)
   
{
    utili.add(new Utilisateur(e.getId_utilisateur(),e.getNom(),e.getTel()));
    
    como2.setItems(utili);
    
   // como2.getItems().addAll(e.getId_utilisateur(),e.getNom()); 
//Utilisateur user = como2.getSelectionModel().getSelectedItem();
    
}}
else {
como2.setVisible(false);
}
 // como2.getSelectionModel().getSelectedItem();
//    System.out.print(u.getId_utilisateur());
    
}
  //Utilisateur uss = (Utilisateur) como2.getSelectionModel().getSelectedItem();
  public void sendMail(){
      try{
            String host ="smtp.gmail.com" ;
            String user = "yasmine.chaieb@esprit.tn";
            String pass = "203JFT2277";
            String to =tfEmail.getText();
            String from ="yasmine.chaieb@esprit.tn";
            String subject = "Réclamation bien reçu";
            String messageText = "Bonjour cher client  , votre reclamation a été bien reçu et en cours de traitement. Cordialemment";
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
            msg.setSubject(subject); msg.setSentDate(new java.util.Date());
            msg.setText(messageText);
           javax.mail.Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        
        
        
        
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
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("IUser.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    @FXML
    private void abonnement(ActionEvent event) {
    }

    @FXML
    private void panier(ActionEvent event) {
    }

    @FXML
    private void planning(ActionEvent event) {
    }

    @FXML
    private void user(ActionEvent event) {
         
        try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Profile.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }
}

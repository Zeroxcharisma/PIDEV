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
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
    @FXML
    private TextField idabo;
    @FXML
    private TextField dureeabo;
    @FXML
    private TextField prixabo;
    @FXML
    private TextField typeabo;
    @FXML
    private Button ajouterabo;
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

}

    @FXML
    private void choix(MouseEvent event) {
        if (affichage.getSelectionModel().getSelectedItem()!=null){
            int id = affichage.getSelectionModel().getSelectedItem().getId();
            System.out.println("id="+id);
        }
        else {
            System.out.println("aucun element n est selectee");

        }

    }

    @FXML
    private void ajouter(ActionEvent event) {
         if(idabo.getText().isEmpty() | dureeabo.getText().isEmpty()|prixabo.getText().isEmpty()|typeabo.getText( ).isEmpty()){      

        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setHeaderText(null);
        al.setContentText("remplir les champs vides svp");
        al.showAndWait();



        }else{
         abonnementCRUD a = new abonnementCRUD();
        abonnement a1 = new  abonnement ( Integer.parseInt(idabo.getText()),Integer.parseInt(dureeabo.getText()),Integer.parseInt(prixabo.getText()),typeabo.getText());
       JOptionPane.showMessageDialog(null, "abonnement ajouté");
        a.ajouterAbonnement(a1); 
         affichage();



         try{
            String host ="smtp.gmail.com" ;
            String user = "mouhamed.bannour.05@gmail.com";
            String pass = "Cc+med1997";
            String to ="mouhamed.bannour@esprit.tn" ;
            String from ="mouhamed.bannour.05@gmail.com" ;
            String subject = "Compte crée";
            String messageText = "Bonjour cher nouveau membre , votre abonnement a été bien crée. Cordialemment";
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

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());




    }
         TrayNotification tray = null;
        tray = new TrayNotification("abonnement ajoutee", "Votre abonnement a ete ajoutee avec succes ,Merci ", NotificationType.SUCCESS);

        tray.showAndDismiss(javafx.util.Duration.seconds(5));


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
    }
}
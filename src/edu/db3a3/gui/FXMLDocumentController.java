/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.abonnement;
import edu.db3a3.services.abonnementCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {
    
  
    @FXML
    private TableView<abonnement> affichage;
    @FXML
    private TableColumn<abonnement, Integer> idaff;
    @FXML
    private TableColumn<abonnement, Integer> dureeaff;
    @FXML
    private TableColumn<abonnement, Integer> prixaff;
    @FXML
    private TableColumn<abonnement, String> typeaff;
    @FXML
    private CheckBox tri;
    @FXML
    private TextField idd;
    @FXML
    private CheckBox tri1;
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
    private Button modifier;
    @FXML
    private Button recherche;
    @FXML
    private TextField rch;
    @FXML
    private PieChart statype;
    @FXML
    private Button event;
    @FXML
    private Button abonnement;
    @FXML
    private Button produit;
    @FXML
    private Button planning;
    @FXML
    private Button reclamation;
    @FXML
    private Button panier;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affichage ();
        try {
            loadDataPie();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        statype.setData(piechartdata);
       
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
    private void trid(ActionEvent event) {
        abonnementCRUD a= new abonnementCRUD();
        List<abonnement> list =  a.displaybytype();
        ObservableList<abonnement> liste = FXCollections.observableArrayList(list);
        idaff.setCellValueFactory(new PropertyValueFactory<>("id"));
         dureeaff.setCellValueFactory(new PropertyValueFactory<>("duree"));
          prixaff.setCellValueFactory(new PropertyValueFactory<>("prix"));
           typeaff.setCellValueFactory(new PropertyValueFactory<>("type"));
        affichage.setItems(liste);
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
        abonnementCRUD a= new abonnementCRUD();
        int opt = JOptionPane.showConfirmDialog(null, "Confirmer la supression ?","supprimer",JOptionPane.YES_NO_OPTION);
      if(opt==0){
       a.delete( Integer.parseInt(idd.getText()));
        JOptionPane.showMessageDialog(null, "abonnement supprimé");
        affichage();
    }}

    @FXML
    private void trid1(ActionEvent event) {
        abonnementCRUD a= new abonnementCRUD();
        List<abonnement> list =  a.displaybytype1();
        ObservableList<abonnement> liste = FXCollections.observableArrayList(list);
        idaff.setCellValueFactory(new PropertyValueFactory<>("id"));
         dureeaff.setCellValueFactory(new PropertyValueFactory<>("duree"));
          prixaff.setCellValueFactory(new PropertyValueFactory<>("prix"));
           typeaff.setCellValueFactory(new PropertyValueFactory<>("type"));
        affichage.setItems(liste);
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
    private void modifieraboo(ActionEvent event) {
         int opt = JOptionPane.showConfirmDialog(null, "Confirmer la modification ?","modifier",JOptionPane.YES_NO_OPTION);
      if(opt==0){
        if(idabo.getText().isEmpty() | dureeabo.getText().isEmpty()|prixabo.getText().isEmpty()|typeabo.getText( ).isEmpty()){      
        
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setHeaderText(null);
        al.setContentText("remplir les champs vides svp");
        al.showAndWait();
            
            
        
        }else{

   
    }
    
         abonnementCRUD a = new abonnementCRUD();
        abonnement a1 = new  abonnement ( Integer.parseInt(idabo.getText()),Integer.parseInt(dureeabo.getText()),Integer.parseInt(prixabo.getText()),typeabo.getText());
         JOptionPane.showMessageDialog(null, "abonnement modifié");
       a.update(a1);
        affichage();
    }}

    @FXML
    private void chercher(ActionEvent event) {
         try {
                   ObservableList<abonnement> ofList = FXCollections.observableArrayList();
        idaff.setCellValueFactory(new PropertyValueFactory<>("id"));
        dureeaff.setCellValueFactory(new PropertyValueFactory<>("duree"));
        prixaff.setCellValueFactory(new PropertyValueFactory<>("prix"));
        typeaff.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        /////////////////////////////////////////////////////////////////////////////
        abonnementCRUD rt = new abonnementCRUD();
        List old = rt.FindabonnementBytype(rch.getText());
        ofList.addAll(old);
        affichage.setItems(ofList);
        affichage.refresh();
         JOptionPane.showMessageDialog(null,"abonnement trouver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
    
    
    
    ObservableList<PieChart.Data> piechartdata; //stat
     Connection cnx;
    ResultSet rs;
    public void loadDataPie() throws SQLException{
        piechartdata = FXCollections.observableArrayList();
        String dbUsername = "root";
        String dbPassword = "";
        String dbURL = "jdbc:mysql://localhost:3306/pidev";
        
  
        
        cnx = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        PreparedStatement pst = cnx.prepareStatement("SELECT type as 'type', COUNT(type) as 'total' FROM abonnement GROUP BY type  ");
        rs=pst.executeQuery();
        
        while(rs.next()){
            piechartdata.add(new PieChart.Data(rs.getString("type"),rs.getInt("total")));

        } 
    }

    @FXML
    private void event(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Evenement.fxml"));
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
    private void produit(ActionEvent event) {
    }

    @FXML
    private void planning(ActionEvent event) {
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
    private void panier(ActionEvent event) {
    }

   
}

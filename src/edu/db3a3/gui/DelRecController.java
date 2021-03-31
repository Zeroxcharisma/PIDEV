/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;


import edu.db3a3.entities.Reclamation;
import edu.db3a3.services.ReclamationCRUD;
import edu.db3a3.tools.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

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
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfDescription;
    @FXML
    private Button btnUp;
    @FXML
    private TableColumn<Reclamation,String> coEtat;
    @FXML
    private ComboBox tfEtat;
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
    private Button user;
    @FXML
    private Label letat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       refresh(true);
       
    }    

    @FXML
    private void supprimerReclamation(ActionEvent event) {
        if (tableRec.getSelectionModel().isEmpty() ){
         
        Notifications notificationBuilder = Notifications.create()
 
                    .title("ERREUR")
                    .text("Veuillez choisir un champ")
                
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.show();   
     }else{
    
   int responce=    JOptionPane.showConfirmDialog(null, "voulez-vous supprimer la reclamation sélectionné ?","vérification",JOptionPane.YES_NO_OPTION);
            if (responce==JOptionPane.YES_OPTION){
                     Reclamation r =tableRec.getSelectionModel().getSelectedItem();
    ReclamationCRUD UC = new ReclamationCRUD();
    UC.supprimerReclamation(r);
                tableRec.getItems().clear();
            refresh(true);
 
            } else{
                
                System.out.println("suppression annuler");
            }
          
    }}

   @FXML
    private void updateReclamation(ActionEvent event) {

        if (tfEtat.getSelectionModel().isEmpty() | tfId.getText().isEmpty() | tfEmail.getText().isEmpty() | tfSujet.getText().isEmpty() | tfDescription.getText().isEmpty()) {

            Notifications notificationBuilder = Notifications.create()
                    .title("ERREUR")
                    .text("Veuillez remplir les champs")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.show();
        } else {

            try {
                Connection cnx = MyConnection.getInstance().getCnx();

                int value1 = Integer.parseInt(tfId.getText());

                String value2 = tfEmail.getText();

                String value3 = tfSujet.getText();
                String value4 = tfDescription.getText();
               
                String value5 = tfEtat.getSelectionModel().getSelectedItem().toString();
                if(value5.equals("traitée")){
                    tfEtat.setVisible(false);
                    
                }

                String sql = "update reclamation set id= '" + value1 + "',email= '" + value2 + "',sujet= '"
                        + value3 + "',description= '" + value4 + "',etat= '" + value5 + "' where id='" + value1 + "' ";
                PreparedStatement pst = cnx.prepareStatement(sql);
                pst = cnx.prepareStatement(sql);
                pst.execute();
                int responce = JOptionPane.showConfirmDialog(null, "voulez-vous modifier l'etat ?", "vérification", JOptionPane.YES_NO_OPTION);
                if(tfEtat.getSelectionModel().getSelectedItem().equals("traitée")){
                    sendMail();
                }
                if (responce == JOptionPane.YES_OPTION) {
                    tableRec.getItems().clear();
                    refresh(true);

                } else {

                    System.out.println("modification annuler");
                }

            } catch (SQLException ex) {
                Logger.getLogger(DelRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void click(MouseEvent event) {
        Reclamation reclamation = tableRec.getSelectionModel().getSelectedItem();
        tfId.setText("" + reclamation.getId());
        tfEmail.setText(reclamation.getEmail());
        tfSujet.setText(reclamation.getSujet());
        tfDescription.setText(reclamation.getDescription());
        tfEtat.setValue(reclamation.getEtat());
        if(tfEtat.getSelectionModel().getSelectedItem().equals("traitée")){
               
            tfEtat.setVisible(false);
               letat.setVisible(false);
               btnUp.setDisable(true);
        }
        else {tfEtat.setVisible(true);
        letat.setVisible(true);
        btnUp.setDisable(false);
        }
        ObservableList<String> list = FXCollections.observableArrayList("traitée");
        tfEtat.setItems(list);

    }

    public void refresh(boolean x) {
        if (x == true) {
            try {
                Connection c = MyConnection.getInstance().getCnx();
                PreparedStatement pt;
                pt = c.prepareStatement("SELECT id,email,sujet,description,etat from reclamation");
                // String requete = "select id_utilisateur,username,nom,prenom,email,tel,adresse,id_role,etat from utilisateur";
                ResultSet rs = pt.executeQuery();

                while (rs.next()) {
                    Reclamation r = new Reclamation();
                    r.setId(rs.getInt("id"));
                    r.setEmail(rs.getString(2));
                    r.setSujet(rs.getString(3));
                    r.setDescription(rs.getString(4));
                    r.setEtat(rs.getString(5));

                    // p.setEmail(rs.getString(10));
                    reclamationlist.add(r);
                }
                //oblist.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("username"),rs.getString("nom"),rs.getInt("tel"),rs.getString("email"),rs.getString("prenom"),rs.getString("adresse"),String.valueOf(rs.getInt("id_role")),String.valueOf(rs.getInt("etat")),new Button("update"),new Button("delete")));}
                // oblist.add(new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("adresse"),rs.getString("role"),rs.getInt("etat"),new Button("update"),new Button("delete")));}
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            };
            coId.setCellValueFactory(new PropertyValueFactory<>("id"));
            coEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            coSujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            coDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
            coEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));

            tableRec.setItems(reclamationlist);

        } else {
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
    public void sendMail() {
        try {
            String host = "smtp.gmail.com";
            String user = "yasmine.chaieb@esprit.tn";
            String pass = "203JFT2277";
            String to = tfEmail.getText();
            String from = "yasmine.chaieb@esprit.tn";
            String subject = "Réclamation traitée";
            String messageText = "Bonjour cher client  ,votre réclamation a bien été traitée merci. Cordialemment";
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
            msg.setSubject(subject);
            msg.setSentDate(new java.util.Date());
            msg.setText(messageText);
            javax.mail.Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            System.out.println("message send successfully");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void produit(ActionEvent event) {
    }

    @FXML
    private void reclamation(ActionEvent event) {
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
    }

    @FXML
    private void planning(ActionEvent event) {
    }

    @FXML
    private void user(ActionEvent event) {
    }
  
  
}

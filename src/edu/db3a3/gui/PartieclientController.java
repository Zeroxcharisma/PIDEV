/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import edu.db3a3.entities.Participation;
import edu.db3a3.entities.Utilisateur;
import edu.db3a3.entities.evenement;
import edu.db3a3.services.ParticipationCrud;
import edu.db3a3.services.UtilisateurCRUD;
import edu.db3a3.services.evenementCRUD;

import java.awt.Desktop;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;
import map.mapa;

/**
 * FXML Controller class
 *
 * @author maalaoui
 */
public class PartieclientController implements Initializable {

    @FXML
    private TableView<evenement> tableExA;
    @FXML
    private TableColumn<evenement, String> colidprofile;
    @FXML
    private TableColumn<evenement, String> collieu;
    @FXML
    private TableColumn<evenement, String> coltype;
    @FXML
    private TableColumn<evenement, String> coldcr;
    @FXML
    private TableColumn<evenement, String> coldate;
    @FXML
    private Button btnchercherc;
    @FXML
    private Button btnyogac;
    @FXML
    private Button btnnatationc;
    @FXML
    private Button btnimprimerc;
    @FXML
    private TextField tfatrouverc;
     private javafx.stage.Window evenement;
    @FXML
    private Button map;
    @FXML
    private Button join;
    int id= edu.db3a3.entities.Session.id_utilisateur;
     public static ObservableList<Participation> listea=FXCollections.observableArrayList();
    
     UtilisateurCRUD s=new UtilisateurCRUD();
     Utilisateur u=new Utilisateur();
    @FXML
    private Button showpart;
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
    
    //private static Map map ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherevenement() ;
        // TODO
    }    

   

    @FXML
    private void ajouterv1(ActionEvent event) throws IOException {
         Desktop.getDesktop().open(new File("1.mp4"));
    }

    @FXML
    private void ajouterv2(ActionEvent event) throws IOException {
         Desktop.getDesktop().open(new File("2.mp4"));
    }

    private void afficherevenement() {
        ObservableList<evenement> listre = FXCollections.observableArrayList();
        colidprofile.setCellValueFactory(new PropertyValueFactory<>("id"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
        coldcr.setCellValueFactory(new PropertyValueFactory<>("dcr"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        evenementCRUD r = new evenementCRUD();
        List old = r.afficherevenement();
        listre.addAll(old);
        tableExA.setItems(listre);    
    }

    @FXML
    private void chercherevenementc(ActionEvent event) {
           try {
                   ObservableList<evenement> ofList = FXCollections.observableArrayList();
        colidprofile.setCellValueFactory(new PropertyValueFactory<>("id"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
        coldcr.setCellValueFactory(new PropertyValueFactory<>("dcr"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        /////////////////////////////////////////////////////////////////////////////
        evenementCRUD rt = new evenementCRUD();
        List old = rt.FindevenementBytype(tfatrouverc.getText());
        ofList.addAll(old);
        tableExA.setItems(ofList);
        tableExA.refresh();
         JOptionPane.showMessageDialog(null,"evenement trouver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }

    @FXML
    private void imprimerevenementc(ActionEvent event) {
        System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(evenement); 
            
    Node root = this.tableExA;
           job.printPage(root);
           job.endJob(); }
    }

    private void afficherevenementc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void gotomap(ActionEvent event) 
        throws IOException {
        final mapa example = new mapa("test");
        example.generateMarker(map());
        Parent rootRec2 = FXMLLoader.load(getClass().getResource("partieclient.fxml"));
        Scene rec2 = new Scene(rootRec2);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(rec2);
        app.show();
    }

    private LatLng map() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void join(ActionEvent event) {
        
        evenement e =tableExA.getSelectionModel().getSelectedItem();
        
        
        ParticipationCrud p = new ParticipationCrud();
        p.ajouterUtilisateur(id,e.getId());
                
        
    }

    @FXML
    private void showpart(ActionEvent event) {
       
       try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("showparticpation.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
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
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("AddRec.fxml"));
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
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("Client.fxml"));
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
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("IUser.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionplanning.Views;

import gestionplanning.Entities.Cours;
import gestionplanning.Service.CoursService;
import gestionplanning.Service.Mailing;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class AjouterCoursController implements Initializable {

    public String ImageComp;
    @FXML
    private TextField nomC;
    @FXML
    private TextField nbH;
    @FXML
    private TextField nomE;
    @FXML
    private Button v;
    @FXML
    private Button r;
    @FXML
    private Label imagePath;
    @FXML
    private ImageView ImageField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        r.setOnAction(e->{  
            Parent root ;
         try {
             root=FXMLLoader.load(getClass().getResource("GestionCours.fxml"));
             r.getScene().setRoot(root);
         } catch (IOException ex) {
             Logger.getLogger(AjouterTestFitnessController.class.getName()).log(Level.SEVERE, null, ex);
         }
            
             }); 
        v.setOnAction(e->{
          //Local(String nom, String adresse, float prix,float surface,int capacite)  
        Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Error");
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);

                alert.setTitle("Success");

        String n= nomC.getText();
         String nb=nbH.getText();
         String ne= nomE.getText();

         String ch="";
         Boolean ok =true;
         int pr = -1;
         int test=Integer.parseInt(nb);
         if(!n.matches("^[a-zA-Z]+$")){
             ch+="Vous devez entrer un nom valide!\n";
             ok=false;
         }
         if(!ne.matches("^[a-zA-Z]+$")){
             ch+="Vous devez entrer un nom d'enseignant valide!\n";
             ok=false;
         }
         if(!nb.matches("\\d+")||nb.length()==0||test>3){
             ch+="Vous devez entrer une durée inferieure a 3 heures\n";
             ok=false;
         }
         else pr = Integer.parseInt(nb);
         if(ok==true){
             Cours cours = new Cours(n,ne,pr,ImageComp);
             CoursService cs = new CoursService();
             try {
                cs.ajouterCours(cours);
                List<String> emails = new ArrayList<>();
                emails = cs.getEmails();
                for( String email : emails ) {
                    Mailing.mailing(email);
                }
                ch+="Ajout effectué avec success!\n";
                alert1.setContentText(ch);
                alert1.show();
                 
             } catch (SQLException ex) {
                 Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
             } catch (Exception ex) {
                Logger.getLogger(AjouterCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         else {
             alert.setContentText(ch);
             alert.show();
         }
        });
    }    

    @FXML
    private void uploade(ActionEvent event) throws FileNotFoundException, IOException {
        FileChooser fc = new FileChooser();
        //fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", listFichier));
        File f = fc.showOpenDialog(null);
        if (f != null) {

            //Commentaire.setText("Image selectionnée" + f.getAbsolutePath());
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(new File(f.getAbsolutePath()));
//             
                os = new FileOutputStream(new File("C:/xampp/htdocs/ImagePIDEv/" + f.getName()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                System.out.println("razi");

            } finally {
                is.close();
                os.close();

            }

            File file = new File("C:/xampp/htdocs/ImagePIDEv/" + f.getName());
//            System.out.println(file.toURI().toString());
            ImageField.setImage(new Image(file.toURI().toString()));
            ImageComp = f.getName();
            System.out.println(ImageComp);
            imagePath.setText(ImageComp);
        } else if (f == null) {
            //Commentaire.setText("Erreur chargement de l'image");
            System.out.println("Erreur !");
        }
    }
    
}
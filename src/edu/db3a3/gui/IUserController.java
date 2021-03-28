/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import edu.db3a3.entities.Cours;
import edu.db3a3.services.CoursService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class IUserController implements Initializable {

    @FXML
    private FlowPane FlowPaneCour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            affichageUS();
        } catch (SQLException ex) {
            Logger.getLogger(IUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    public void setFILES(String Body, String Body1, String Body2, String Body3,String path) {
        try {

            OutputStream file = new FileOutputStream(new File("text.pdf"));

            Document document = new Document();

            PdfWriter.getInstance(document, file);

            document.open();
            document.addTitle("Ticket");

            com.itextpdf.text.Image img;
            img = com.itextpdf.text.Image.getInstance(path);
            com.itextpdf.text.Image.getInstance(img);
            document.add(img);
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph("                    "));
            document.add(new Paragraph(Body));
            document.add(new Paragraph(Body1));
            document.add(new Paragraph(Body2));
            document.add(new Paragraph(Body3));
            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void btnPDF(String Body, String Body1, String Body2, String Body3,String path) throws IOException, SQLException {
       
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Button button2 = new Button();
        button2.setStyle("-fx-background-color: #00ff00");
        alert.setTitle("PDF ");
        alert.setContentText("Bonjour Mr/Mme !  vous voulez exporter votre cour en PDF ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            setFILES(Body, Body1, Body2, Body3,path);

        } else {

        }
    }
    
    
    private void affichageUS() throws SQLException {

        CoursService ser = new CoursService();

        ObservableList<Cours> listComp = FXCollections.observableArrayList(ser.readAll());

        
        ArrayList<Separator> as = new ArrayList<>();
        ArrayList<VBox> vbx = new ArrayList<>();
        ArrayList<HBox> btnP = new ArrayList<>();

        for (int i = 0; i < listComp.size(); i++) {

            Separator h = new Separator(Orientation.VERTICAL);
            h.setPrefWidth(17);
            h.setPrefHeight(24);
            h.setVisible(false);
            as.add(h);

            VBox VBoxComp = new VBox();

            VBoxComp.setSpacing(7);
            VBoxComp.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            VBoxComp.setAlignment(Pos.CENTER);
            VBoxComp.setPrefHeight(265);
            VBoxComp.setPrefWidth(230);
            HBox panne = new HBox();
            panne.setSpacing(5);
            panne.setStyle("-fx-background-color : #FFFFFF;");
            //VBoxComp.setStyle("-fx-border-color : #2B48E8;");
            panne.setAlignment(Pos.CENTER);
            panne.setPrefHeight(30);
            panne.setPrefWidth(80);

            Rectangle c = new Rectangle(230, 180);

//                ImageView img = new ImageView(new Image(new FileInputStream("C:\\Users\\loume78\\Desktop\\Mon_cv\\loume.png")));
//                img.setFitHeight(10);
//                img.setFitWidth(20);
            try {
                c.setFill(new ImagePattern(new Image(new FileInputStream("C:/xampp/htdocs/ImagePIDEv/" + listComp.get(i).getImage()))));
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } 

            VBoxComp.getChildren().add(c);
            String path = ("C:/xampp/htdocs/ImagePIDEv/" + listComp.get(i).getImage());
            Label titreComp = new Label("Nom : " + listComp.get(i).getNom());

            

           

            Button print = new Button("Print");
            
            print.setStyle("-fx-background-color : #60A9C4;");
            print.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                                    
                                    String Body = "L’athlétisme est un ensemble d’épreuves sportives codifiées";
                                    String Body1 = "comprenant les courses, sauts, lancers, épreuves combinées et";
                                    String Body2 = "marche. L'origine du mot athlétisme vient du grec « Athlos »";
                                    String Body3 = "signifiant combat. Il s’agit de l’art de dépasser la performance des adversaires en vitesse ou en endurance, en distance ou en hauteur." ;
                                    
                    try {
                        btnPDF(Body, Body1, Body2, Body3,path);
                    } catch (IOException ex) {
                        Logger.getLogger(IUserController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(IUserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
          
            panne.getChildren().add(print);
            VBoxComp.getChildren().add(panne);


            VBoxComp.getChildren().add(titreComp);
         
            vbx.add(VBoxComp);
            btnP.add(panne);
            FlowPaneCour.getChildren().add(vbx.get(i));

            FlowPaneCour.getChildren().add(as.get(i));

            if (i == 0) {
                System.out.println("i=0 llllll");
            } else if (((i + 1) % 3) == 0) {
                Separator sepHoriz = new Separator(Orientation.HORIZONTAL);
                sepHoriz.setPrefWidth(30);
                sepHoriz.setPrefHeight(30);
                sepHoriz.setVisible(false);
                FlowPaneCour.getChildren().add(sepHoriz);

            }
        }
    }
    
}

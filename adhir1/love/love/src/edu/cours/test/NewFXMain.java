/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.test;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author maalaoui
 */
public class NewFXMain extends Application {
    
    @Override
     public void start(Stage primaryStage)throws IOException {
          try {
           FXMLLoader home = new FXMLLoader(getClass().getResource("../Gui/partieclient.fxml"));
            //FXMLLoader home1 = new FXMLLoader(getClass().getResource("../Gui/modifierCours.fxml"));
          // FXMLLoader home = new FXMLLoader(getClass().getResource("../Gui/stat.fxml"));

        Parent root = home.load();
        Scene rec = new Scene(root);
        primaryStage.setTitle("evenement");
        primaryStage.setScene(rec);
        primaryStage.show();
        } catch (IOException e) {
              System.out.println(e.getMessage());
        }
 
    /**
     * @param args the command line arguments
     */}
    public static void main(String[] args) {
        launch(args);
    }
    
}

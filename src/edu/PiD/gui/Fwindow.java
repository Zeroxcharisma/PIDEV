/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.PiD.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class Fwindow extends Application {
    
    @Override
    public void start(Stage primaryStage) {
 try {
           FXMLLoader home = new FXMLLoader(getClass().getResource("AddRec.fxml"));
            //FXMLLoader home1 = new FXMLLoader(getClass().getResource("../Gui/modifierCours.fxml"));

        Parent root = home.load();
        Scene rec = new Scene(root);
        primaryStage.setTitle("Formulaire d'ajout");
        primaryStage.setScene(rec);
        primaryStage.show();
        } catch (IOException e) {
              System.out.println(e.getMessage());
        }
 
    /**
     * @param args the command line arguments
     */}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

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
 * @author sofie
 */
public class FirstWindow extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            //  Parent root = FXMLLoader.load(getClass().getResource("AllUserNewController.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("DisplayAll.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("Inscrire.fxml"));
                // Parent root = FXMLLoader.load(getClass().getResource("Evenement.fxml"));
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("map.fxml"));
            //  Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("IAdmin.fxml"));
            //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("Affiche.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("DelRec.fxml"));
            //  Parent root = FXMLLoader.load(getClass().getResource("AddRec.fxml"));
            // Parent root = FXMLLoader.load(getClass().getResource("Partieclient.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("VClub");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

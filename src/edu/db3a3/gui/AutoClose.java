/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sofie
 */
public class AutoClose {
    private Timeline timer;

    public AutoClose(VBox mainPanel) {

        timer = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent evt) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Inactivity");
                alert.setHeaderText("Connection closed due to inactivity");
                alert.show();

                try {
                  
            
            
          //Stage mainWindowStage = Login.getPrimaryStage();

                  Stage mainWindowStage = null ;

                    Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

                    Scene scene = new Scene(root);
                    mainWindowStage.setScene(scene);
                    mainWindowStage.show();

                    timer.stop();
                } catch (IOException ex) { 
                }
            }
        }));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        mainPanel.addEventFilter(MouseEvent.ANY, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                timer.playFromStart();
            }
        });
    }
}
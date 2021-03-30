/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.gui;

import edu.cours.entities.evenement;
import edu.cours.tools.MyConnection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author maalaoui
 */
public class StatController implements Initializable {

    @FXML
    private BarChart<String, Double> chart;
    @FXML
    private Button btn_load;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
     
    @FXML
    private void loadChart(ActionEvent event) {
        try {
          evenement e = new evenement();
            String requete="SELECT Id,lieu from evenement ORDER BY lieu ASC ";
            XYChart.Series<String,Double> series=new XYChart.Series<>();
            
            //execute querry and store it in resulttest
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             ResultSet rs =  pst.executeQuery();
           while(rs.next()){
           series.getData().add(new XYChart.Data<>(rs.getString("lieu"),rs.getDouble("Id")));
           chart.getData().add(series);
           
           
           }

            
            
        } catch (SQLException ex) {
        }

    }
    
}

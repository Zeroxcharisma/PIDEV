/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Produit;
import edu.db3a3.services.BonPlanService;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PiechartController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML
    private Button back;

    ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          BonPlanService pdao;
		try {
			pdao = BonPlanService.getInstance();

        List<Produit> pers=pdao.displayAllList();
        for(Produit p:pers) {
            list.addAll(
                new PieChart.Data(p.getType_bp(), 12.0)             
        );
        }
        pieChart.setAnimated(true);
        pieChart.setData(list);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }    

    @FXML
    private void backkk(ActionEvent event) throws IOException {
        
		Parent root = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    private void api(ActionEvent event) {
    
    
}
}
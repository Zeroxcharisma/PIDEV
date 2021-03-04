/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.PiD.gui;

import edu.PiD.services.ReclamationCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ModRecController implements Initializable {

    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfDescription;
    @FXML
    private Button btnMod;
    @FXML
    private TextField tfId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateReclamation(ActionEvent event) {
        Integer id=Integer.valueOf(tfId.getText());
        String email=tfEmail.getText();
        String sujet=tfSujet.getText();
        String description=tfDescription.getText();
        ReclamationCRUD pcd = new ReclamationCRUD();
        pcd.modifierReclamation2(id,email,sujet,description);
            
        
    }
    
}

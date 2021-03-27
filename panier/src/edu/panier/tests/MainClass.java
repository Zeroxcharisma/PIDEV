/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.panier.tests;

import edu.panier.entities.Panier;
import edu.panier.services.panierCRUD;
import edu.panier.tools.MyConnection;
import java.awt.BorderLayout;
import static javafx.scene.input.KeyCode.P;

/**
 *
 * @author ASUS
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        
        panierCRUD rcr= new panierCRUD();
        
        Panier p = new Panier(5, "ballon", "50");
        Panier c = new Panier(6, "esprit", "96");
       //rcr.ajouterPanier(c);
       
        
        //rcr.supprimerPanier(c);
        
        
       //rcr.updatePanier(c);
       //rcr.updatePanier(p);
        
                
        //panierCRUD pcd = new panierCRUD();
        //System.out.println(pcd.displayPanier());
    }
    
}

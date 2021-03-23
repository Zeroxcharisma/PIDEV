/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.tests;

import edu.db3a3.entities.Utilisateur;
import edu.db3a3.services.UtilisateurCRUD;
import edu.db3a3.tools.MyConnection;

/**
 *
 * @author sofie
 */
public class MainClass {
    public static void main(String[] args) {
       // MyConnection mc = new MyConnection();
       UtilisateurCRUD pcd = new UtilisateurCRUD();
      // Utilisateur U = new Utilisateur();
      // pcd.ajouterUtilisateur(U);
        System.out.println(pcd.uesersList());
    }
    
    
    
}

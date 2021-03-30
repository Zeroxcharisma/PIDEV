/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.services;

import edu.cours.entities.Cours;
import edu.cours.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class CoursCRUD {
    
    public void addCours(Cours c){
        String requete="INSERT INTO Cours (  numCours, numSalles,nomCours,nomCoach,horraire,duree,type)"+  "VALUES (?,?,?,?,?,?,?)";
    
        try {
            PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);                // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            ///singloton c'st un patron de conception maykhalinich naamel dima new haja il nous permet d'optenir une seule instance de la classe dans la memoire  
        
           
            pst.setInt(1, c.getNumCours());
            pst.setInt(2, c.getNumSalles());
             pst.setString(3, c.getNomCours());
            pst.setString(4, c.getNomCoach());
            pst.setString(5, c.getHorraire());
            pst.setString(6, c.getDuree());
            pst.setString(7 , c.getType());
            
            pst.executeUpdate();
            System.out.println("Cours ajouté");
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(CoursCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

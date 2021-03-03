/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.test;

 import edu.cours.tools.MyConnection;
import edu.produits.entities.produit;
import edu.produits.services.produitCRUD;
import java.sql.SQLException;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author dell
 */
public class MainClass {
    public static void main(String[] args)  {
        
        produitCRUD ccd = new produitCRUD();
         produit p2 = new produit (64,"proteine",987,"bonne qualité");
         // ccd.getAll().forEach(e->System.out.println(e));
      // ccd.ajouterProduit(p2);
        //ccd.update(p2);
        // ccd.delete(id);
     
       //ccd.displayproduit().forEach(ep->System.out.println(ep));
     // System.out.println(ccd.FindproduitByid(id));
    // ccd.displaybyprix().forEach(t->{System.out.println(t);});
          
      
 }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.PiD.tests;

import edu.PiD.entities.Reclamation;
import edu.PiD.entities.Utilisateur;
import edu.PiD.services.ReclamationCRUD;
import edu.PiD.tools.MyConnection;

/**
 *
 * @author House
 */
public class MainClass {
    
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
   /*     MyConnection mc2 = MyConnection.getInstance();
       System.out.println(mc.hashCode()+"--"+mc2.hashCode());*/
        
          //Reclamation reclamation =new Reclamation(17,"k.j@gmail.com","reclamation du temps","le coach dhdd",2);
  // Utilisateur u = new Utilisateur();
        //  ReclamationCRUD r =new ReclamationCRUD();
     //  r.ajouterReclamation(reclamation);
        
        //Reclamation reclamation =new Reclamation(17,"john.j@gmail.com","reclamation du cours","le cours ...... ",2);
        //ReclamationCRUD r =new ReclamationCRUD();
         //r.updateReclamation(reclamation);
       
    //  Reclamation reclamation =new Reclamation(26,"jas@gmail.com","reclamation sur coach","le coach dhdd",1,"");
     ReclamationCRUD r =new ReclamationCRUD();
     //r.ajouterReclamation(reclamation);
      //r.updateReclamation(reclamation);
      //r.suppReclamation(27);
   //   System.out.println(r.recherche();
    // System.out.println(r.FindReclamationById(13));
//System.out.println(r.recherche("reclamation du temps"));
//r.getAllCoachs().forEach(p->System.out.print(p));
System.out.print(r.getNumberOfReclamation(2));
    }
}


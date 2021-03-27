/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abonnement.test;

 
import edu.abonnement.entities.abonnement;
 
import edu.abonnement.services.abonnementCRUD;

/**
 *
 * @author USER
 */
public class MainClass {
    
    public static void main(String[] args){
    abonnementCRUD aaa= new  abonnementCRUD();
       abonnement a1 = new  abonnement (1,1,14,"vip");
       //aaa.ajouterAbonnement(a1);
         //aaa.update(a1);
         //aaa.delete(2);
        // aaa.displayabonnement().forEach(ep->System.out.println(ep));
         // System.out.println(aaa.FindabonnementByid(45));
       
   //aaa.displaybytype().forEach(t->{System.out.println(t);});
}
    
}
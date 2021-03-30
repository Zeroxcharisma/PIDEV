/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.test;

import edu.cours.entities.Cours;
import edu.cours.entities.evenement;
import edu.cours.services.CoursCRUD;
import edu.cours.services.evenementCRUD;
import edu.cours.tools.MyConnection;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author dell
 */
public class MainClass {
    public static void main(String[] args) {
        Date date1 = new Date(2021,2,2);
        MyConnection mc = new MyConnection();
        evenementCRUD e = new evenementCRUD();
        evenement e1 = new evenement(333,"salsa","isabella","lundi",date1);
        evenement e2 = new evenement(555,"tango","isabella","lundi",date1);
        //e.addEvenement(e1);
        //e.addEvenement(e2);
        //e.delete(e2);
        
        //e.update(e2);
        e.displayevenement().forEach(ep->System.out.println(ep));
    }
}

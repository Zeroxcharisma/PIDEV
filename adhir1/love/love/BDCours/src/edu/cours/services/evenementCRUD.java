/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.services;
import edu.cours.entities.Cours;
import edu.cours.entities.evenement;
import edu.cours.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maalaoui
 */
     public class evenementCRUD {
     public void addEvenement(evenement e){
    String requete= "INSERT INTO evenement(id,lieu,type,dcr,date)" + "VALUES(?,?,?,?,?)";
    
        try {
            PreparedStatement pst1 =  new MyConnection().cn.prepareStatement(requete);                // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            ///singloton c'st un patron de conception maykhalinich naamel dima new haja il nous permet d'optenir une seule instance de la classe dans la memoire  
        
           
             pst1.setInt(1,e.getId());
             pst1.setString(2,e.getlieu());
             pst1.setString(3,e.gettype());
             pst1.setString(4,e.getdcr());
             pst1.setDate(5,e.getdate());
            
            pst1.executeUpdate();
            System.out.println("evenement ajoutée");
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public java.util.List<evenement> getAll() {
        ArrayList<evenement> listevenement = new ArrayList<>();
        try {
          String requete= "GETALL FROM `evenement` WHERE `evenement`.`Id` = ? ";

            PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);                // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            ResultSet rs = pst.executeQuery("Select * from evenement");
            while (rs.next()) {
                listevenement.add(new evenement(
                        rs.getInt(1),
                       
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        
                        rs.getDate(5)));
                           
            }
          pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listevenement;
    }
    
       public void update (evenement e) {
        try {
            String requete = "UPDATE evenement SET Id='"+e.getId()
                    + "',lieu='"+e.getlieu()+ "',type='"+e.gettype()
                    +"',dcr='"+e.getdcr()+"',date='"+e.getdate()
                    + "' WHERE Id=" + e.getId();
   PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);              
            int rowsUpdated = pst.executeUpdate(requete);
            if (rowsUpdated > 0) {
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void delete(int Id) {
        try {
            String requete= "DELETE FROM `evenement` WHERE `evenement`.`Id` = ? ";
            PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);                // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            pst.setInt(1, Id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(evenement evenementss) {
        try {
            String requete= "DELETE FROM `evenement` WHERE `evenement`.`Id` = ? ";
            PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);                // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            pst.setInt(1, evenementss.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public List<evenement> displayevenement() {
//         List<evenement> evenementList = new ArrayList<>();
//        try {
//            String requete = "SELECT * FROM evenement";
//            Statement pst =  new MyConnection().cn.prepareStatement();
//            ResultSet rs =  pst.executeQuery(requete);
//            while(rs.next()){
//                evenement e = new evenement();
//                e.setId(rs.getInt("id"));
//                e.setlieu(rs.getString("lieu"));
//                e.settype(rs.getString("type"));
//                e.setdcr(rs.getString("dcr"));
//                e.setdate(rs.getDate("date"));
//                evenementList.add(e);
//                System.out.println("Affichage effectue");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return evenementList;
//    }
    public List<evenement> displayevenement() {
         List<evenement> evenementList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM evenement";
            PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete); 
            ResultSet rs =  pst.executeQuery(requete);
            while(rs.next()){
                evenement p = new evenement();
                p.setId(rs.getInt(1));
                p.setlieu(rs.getString(2));
                p.settype(rs.getString(3));
                p.setdcr(rs.getString(4));
                p.setdate(rs.getDate(5));
                evenementList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenementList;
    }
    
    
}
  
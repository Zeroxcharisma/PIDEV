/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.services;


import edu.db3a3.entities.abonnement;
import edu.db3a3.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author USER
 */
public class abonnementCRUD {
     public void ajouterAbonnement(abonnement a){
        String requete="INSERT INTO abonnement (id,duree,prix,type,id_user)" + "VALUES (?,?,?,?,?)";
    
        try {
          
          PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             
        
           
            pst.setInt(1, a.getId());
            pst.setInt(2, a.getDuree());
            pst.setInt(3, a.getPrix());
            pst.setString(4, a.getType());
            pst.setInt(5, a.getId_user());
            
            
            pst.executeUpdate();
            System.out.println("abonnement ajouté");
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(abonnementCRUD.class.getName()).log(Level.SEVERE, null, ex);  
        }
    } 
       public void ajouterAbonnement2(abonnement a){
        String requete="INSERT INTO abonnement (id,duree,prix,type,id_user)" + "VALUES (?,?,?,?,?)";
    
        try {
          
          PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             
        
           
            pst.setInt(1, a.getId());
            pst.setInt(2, a.getDuree());
            pst.setInt(3, a.getPrix());
            pst.setString(4, a.getType());
            pst.setInt(5, a.getId_user());
            
            
            pst.executeUpdate();
            System.out.println("abonnement ajouté");
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(abonnementCRUD.class.getName()).log(Level.SEVERE, null, ex);  
        }
    } 
     public void update (abonnement a) {
        try {
            String requete = "UPDATE abonnement SET id='"+a.getId()
                    + "',duree='"+a.getDuree()+ "',prix='"+a.getPrix()
                    +"',type='"+a.getType()
                    +"',id_user='"+a.getId_user()
                    + "' WHERE Id=" + a.getId();
   PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);     
            int rowsUpdated = pst.executeUpdate(requete);
            if (rowsUpdated > 0) {
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     public void delete(int Id) {
        try {
            String requete= "DELETE FROM `abonnement` WHERE `abonnement`.`Id` = ? ";
           PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);  // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            pst.setInt(1, Id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(abonnementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<abonnement> displayabonnement() {
         List<abonnement> abonnementList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM abonnement";
           PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            ResultSet rs =  pst.executeQuery(requete);
            while(rs.next()){
                abonnement p = new abonnement();
                p.setId(rs.getInt(1));
                p.setDuree(rs.getInt(2));
                p.setPrix(rs.getInt(3));
                p.setType(rs.getString(4));
                p.setId_user(rs.getInt(5));
                

                abonnementList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return abonnementList;
    }
    
    
    public ArrayList<abonnement> FindabonnementBytype(String type)  {
  ArrayList<abonnement> listabonnement = new ArrayList<>();   
   try {
          String requete= "select * from abonnement WHERE type='" + type + "' ";
       PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
        ResultSet res = pst.executeQuery("select * from abonnement WHERE type='" + type + "' ");
         abonnement  com = null;
        while (res.next()) { 
            com = new  abonnement (res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4));
            listabonnement .add(com);   
        }
        } catch (SQLException ex) {
            Logger.getLogger( abonnementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }System.out.println("abonnement trouve");
        
                 return listabonnement ;
 
    }
   
    
    
    public java.util.List<abonnement> displaybytype() {
     ArrayList<abonnement> listabonnement = new ArrayList<>();
        try {
             String requete= "select * FROM abonnement ORDER by duree ";

           PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);        // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                        listabonnement.add(new abonnement(
                         
                      rs.getInt(1),
                      rs.getInt(2),
                      rs.getInt(3),
                      rs.getString(4),
                      rs.getInt(5)  ));
                                                                            
            }
        pst.close();
      } catch (SQLException ex) {
            Logger.getLogger(abonnementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listabonnement;
    }
     public java.util.List<abonnement> displaybytype1() {
     ArrayList<abonnement> listabonnement = new ArrayList<>();
        try {
             String requete= "select * FROM abonnement ORDER by prix ";

            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);                // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                        listabonnement.add(new abonnement(
                         
                      rs.getInt(1),
                      rs.getInt(2),
                      rs.getInt(3),
                      rs.getString(4),
                       rs.getInt(5)  ));
                                                                            
            }
        pst.close();
      } catch (SQLException ex) {
            Logger.getLogger(abonnementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listabonnement;
    }

    public void modifierAbonnement(abonnement a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateAbonnement(abonnement a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produits.services;

import edu.cours.tools.MyConnection;
import edu.produits.entities.produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class produitCRUD {
    public void ajouterProduit(produit p){
        String requete="INSERT INTO produit (id,nom,prix,descp)" + "VALUES (?,?,?,?)";
    
        try {
          PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);           
             
        
           
            pst.setInt(1, p.getId());
            pst.setString(2, p.getNom());
            pst.setInt(3, p.getPrix());
            pst.setString(4, p.getDescp());
           
            
            pst.executeUpdate();
            System.out.println("produit ajouté");
        
            
        
        
        } catch (SQLException ex) {
            Logger.getLogger(produitCRUD.class.getName()).log(Level.SEVERE, null, ex);  
        }
    } 

public void update (produit p) {
        try {
            String requete = "UPDATE produit SET Id='"+p.getId()
                    + "',Nom='"+p.getNom()+ "',Nom='"+p.getNom()
                    +"',Prix='"+p.getPrix()+"',prix='"+p.getPrix()
                    +"',descp='"+p.getDescp()+"',descp='"+p.getDescp()
                    + "' WHERE id=" + p.getId();
   PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);              
            int rowsUpdated = pst.executeUpdate(requete);
            if (rowsUpdated > 0) {
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
           
        }}
        public void delete(int Id) {
        try {
            String requete= "DELETE FROM produit WHERE produit.`Id` = ? ";
            PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);                // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            pst.setInt(1, Id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(produitCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public List<produit> displayproduit() {
         List<produit> produitList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM produit";
            PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete); 
            ResultSet rs =  pst.executeQuery(requete);
            while(rs.next()){
                produit e = new produit();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setPrix(rs.getInt(3));
                e.setDescp(rs.getString(4));
              
               produitList.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return produitList;
    }
        public ArrayList<produit> FindproduitByid(int Id)  {
  ArrayList<produit> listproduit = new ArrayList<>();   
   try {
          String requete= "select * from produit WHERE Id='" + Id + "' ";
        PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);
        ResultSet res = pst.executeQuery("select * from produit WHERE Id='" + Id + "' ");
        produit com = null;
        while (res.next()) { 
            com = new produit(res.getInt(1),res.getString(2),res.getInt(3),res.getString(4));
            listproduit.add(com);   
        }
        } catch (SQLException ex) {
            Logger.getLogger(produitCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return listproduit ;
 
    }

    public void ajouterProduit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ajouterProduit(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        public java.util.List<produit> displaybyprix() {
     ArrayList<produit> listproduit = new ArrayList<>();
        try {
             String requete= "select * FROM produit ORDER by prix ";

            PreparedStatement pst =  new MyConnection().cn.prepareStatement(requete);                // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                        listproduit.add(new produit(
                         
                      rs.getInt(1),
                      rs.getString(2),
                      rs.getInt(3),
                      rs.getString(4)));
                                                                          
            }
        pst.close();
      } catch (SQLException ex) {
            Logger.getLogger(produitCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listproduit;
    }

    } 

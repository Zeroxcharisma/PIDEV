/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.services;

import edu.db3a3.entities.Panier;
import edu.db3a3.interfaces.IPanier;
import edu.db3a3.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class panierCRUD implements IPanier<Panier> {

 @Override
    public void ajouterPanier(Panier p) {
        try {
            String requete = "INSERT INTO panier (nom,prix,qte,total)" + "VALUES ('"+p.getNom()+"','"+p.getPrix()+"','"+p.getQte()+"','"+p.getTotal()+"')";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Produit ajoutée");
            System.out.println(p.getNom());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
     public void ajouterPanier2(Panier p){
        try {
            String requete= "INSERT INTO panier (nom, prix, qte,total)" + "VALUES (?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, p.getNom());
            pst.setInt(2, p.getPrix());
            pst.setInt(3, p.getQte());
            pst.setInt(4, p.getTotal());
            pst.executeUpdate();
            System.out.println("Produit inserée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerPanier(Panier p) {
try {
            String requete = "DELETE FROM panier where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Produit supprimée from panier");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void updatePanier(Panier p) {
       try {
            String requete = "UPDATE panier SET nom=? WHERE id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1,p.getNom());
            pst.setInt(2,p.getId());
            pst.executeUpdate();
            System.out.println("Panier modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Panier> displayPanier() {
           List<Panier> PanierList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM panier";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                Panier p = new Panier();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString(2));
                p.setPrix(rs.getInt("prix"));
                PanierList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return PanierList;
    }
} 


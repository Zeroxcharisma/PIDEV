/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.services;

import edu.db3a3.entities.Role;
import edu.db3a3.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sofie
 */
public class CrudRole {
   
 Connection c= MyConnection.getInstance().getCnx();
    public void ajouterRole(Role p){
       try {
           Statement st=c.createStatement();//qui va assurer la connexion entre sql et java 
         
           String req="insert into role values("+p.getId_role()+",'"+p.getLibelle()+"')";//pour les chaine de caractere il faut ajouterles simple cote ''
       st.executeUpdate(req);
       } catch (SQLException ex) {
           Logger.getLogger(CrudRole.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
     public void afficherRole() {
       try {
           Statement st=c.createStatement();
           String req="select * from role";
           ResultSet rs=st.executeQuery(req);
           while(rs.next()){
               //rs.get type de la colonne () l'index ou nom de la colonne 
               System.out.println("role id= "+rs.getInt(1)+"libelle : "+rs.getString(1) );
           }
       } catch (SQLException ex) {
           Logger.getLogger(CrudRole.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
  public Role getIdRole(String m){
        try {
            
            PreparedStatement pt = c.prepareStatement("select * from role where libelle =?");
            pt.setString(1,m);
            ResultSet rs=pt.executeQuery();
    
              while(rs.next()){
              Role u1=new Role(rs.getInt("id_role"),rs.getString("libelle"));
              return u1;
              
             }
          
        } catch (SQLException ex) {
            Logger.getLogger(CrudRole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
  }
    public void modifierRole (int id,String libelle){
       try {
           PreparedStatement pt =c.prepareStatement("update role set id_role=? where libelle=?");
        
            pt.setInt(1, id);
               pt.setString(2, libelle);
            pt.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(CrudRole.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    }
    public void SupprimerRole (int id_role){
       try {
           PreparedStatement pt =c.prepareStatement("delete from role where id_role=?");
           pt.setInt(1, id_role);
           pt.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(CrudRole.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.services;


import edu.db3a3.entities.Participation;
import edu.db3a3.entities.Utilisateur;
import static edu.db3a3.gui.AllUserNewController.liste;

import edu.db3a3.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author sofie
 */
public class ParticipationCrud {
    
     public static ObservableList<Participation> listea=FXCollections.observableArrayList();
     
    public void ajouterUtilisateur(int id_user , int id_event) {
        try {
            String requete = "INSERT INTO participation (id_user,id_event)"
                    + "VALUES ('"+id_user+"','"+id_event+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println("Participation ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ObservableList<Participation> geteventsss(int id_user){
        try {
           
            Connection c= MyConnection.getInstance().getCnx();
            PreparedStatement pt;
            pt = c.prepareStatement("select type,dcr,date,id from evenement INNER JOIN participation where participation.id_user='"+id_user+"'and evenement.id=participation.id_event");
            ResultSet rs=pt.executeQuery();
          
            while(rs.next()){
                
                Participation p = new Participation();
                p.setDate(rs.getString("date"));
                p.setDcr(rs.getString("dcr"));
                p.setType(rs.getString("type"));
                p.setId_event(rs.getInt("id"));
                
                listea.add(p);
                    
                System.out.println("Participation"+listea);
            }   } catch (SQLException ex) {
            Logger.getLogger(ParticipationCrud.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return listea;
    
    }}

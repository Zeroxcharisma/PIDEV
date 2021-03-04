/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.PiD.entities;

import java.sql.Date;
import javafx.scene.control.TextField;

/**
 *
 * @author Asus
 */
public class Reclamation {

   private int id;
    private String email;
    private String sujet;
    private String description;
   private int id_user;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public Reclamation() {
    }

    public Reclamation(int id, String email, String sujet, String description,int id_user) {
        this.id = id;
        this.email = email;
        this.sujet = sujet;
        this.description = description;
        this.id_user= id_user;
        
      
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSujet() {
        return sujet;
    }

    public String getDescription() {
        return description;
    }

  

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  



    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + "email=" + email + " sujet=" + sujet + " description=" + description +'}';
    }

    
}


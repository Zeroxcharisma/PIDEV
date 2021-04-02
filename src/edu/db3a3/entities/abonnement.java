/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.entities;

/**
 *
 * @author USER
 */
public class abonnement {
    
    private int id;
    private int duree;
    private int prix;
    private String type;
    private int id_user;

    public abonnement(int id, int duree, int prix, String type, int id_user) {
        this.id = id;
        this.duree = duree;
        this.prix = prix;
        this.type = type;
        this.id_user = id_user;
    }

    public abonnement() {
    }

    public abonnement(int id, int duree, int prix, String type) {
        this.id = id;
        this.duree = duree;
        this.prix = prix;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "abonnement{" + "id=" + id + ", duree=" + duree + ", prix=" + prix + ", type=" + type + ", id_user=" + id_user + '}';
    }
   
    
    
   

    
   
}

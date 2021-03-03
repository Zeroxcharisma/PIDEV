/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abonnement.entities;

/**
 *
 * @author USER
 */
public class abonnement {
    
    private int id;
    private int duree;
    private int prix;
    private String type;
    
    
   

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

    @Override
    public String toString() {
        return "abonnement{" + "id=" + id + ", duree=" + duree + ", prix=" + prix + ", type=" + type + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuree() {
        return duree;
    }

    public int getPrix() {
        return prix;
    }

    public String getType() {
        return type;
    }
}

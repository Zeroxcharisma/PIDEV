/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entitie;

/**
 *
 * @author yossr
 */
public class Abonnement {
    int id;
    int duree;
    float prix;
    String type;

    public Abonnement() {
    }

    public Abonnement(int duree, float prix, String type) {
        this.duree = duree;
        this.prix = prix;
        this.type = type;
    }

    public Abonnement(int id, int duree, float prix, String type) {
        this.id = id;
        this.duree = duree;
        this.prix = prix;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public int getDuree() {
        return duree;
    }

    public float getPrix() {
        return prix;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}

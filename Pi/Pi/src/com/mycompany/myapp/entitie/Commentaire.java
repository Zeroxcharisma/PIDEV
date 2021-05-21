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
public class Commentaire {
    int id;
    int idAb;
    String description;
    String date;
    int likes;

    public Commentaire() {
    }

    public Commentaire(int id, int idAb, String description, String date) {
        this.id = id;
        this.idAb = idAb;
        this.description = description;
        this.date = date;
    }

    public Commentaire(int idAb, String description, String date) {
        this.idAb = idAb;
        this.description = description;
        this.date = date;
    }

    public Commentaire(int idAb, String description) {
        this.idAb = idAb;
        this.description = description;
    }
    

    public int getId() {
        return id;
    }

    public int getIdAb() {
        return idAb;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdAb(int idAb) {
        this.idAb = idAb;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Commentaire(int id, int idAb, String description, String date, int likes) {
        this.id = id;
        this.idAb = idAb;
        this.description = description;
        this.date = date;
        this.likes = likes;
    }

    public Commentaire(int idAb, String description, String date, int likes) {
        this.idAb = idAb;
        this.description = description;
        this.date = date;
        this.likes = likes;
    }
    
    
}

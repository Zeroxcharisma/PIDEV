/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.entities;

/**
 *
 * @author ASUS
 */
public class Produit {
    private int id ;
    private String nom, type ,image, description;
    private float  prix ;

    public Produit() {
    }

    public Produit(String nom, String type, String image, String description, float prix) {
        this.nom = nom;
        this.type = type;
        this.image = image;
        this.description = description;
        this.prix = prix;
    }

    
    public Produit(int id, String nom, String type, String image, String description, float prix) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.image = image;
        this.description = description;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", image=" + image + ", description=" + description + ", prix=" + prix + '}';
    }
    
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entitie;

/**
 *
 * @author Ahmed laifi
 */
public class Produit {
    
    private int id;
    private String nom;
    private float prix;
    private String type;
    private String image;
    private String description;

    public Produit() {
    }

    public Produit(int id, String nom, float prix, String type, String image, String description) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.type = type;
        this.image = image;
        this.description = description;
    }

    public Produit(String nom, float prix, String type, String image, String description) {
        this.nom = nom;
        this.prix = prix;
        this.type = type;
        this.image = image;
        this.description = description;
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

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
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

     
    
    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", type=" + type + ", image=" + image + ", description=" + description + '}';
    }
    
    
    
}

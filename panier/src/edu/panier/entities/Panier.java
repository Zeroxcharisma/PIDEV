/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.panier.entities;

/**
 *
 * @author ASUS
 */
public class Panier {

    private int id;
    private String nom;
    private String prix;

    public Panier() {
    }

    public Panier(int id, String nom, String prix) {
        this.id = id;
        this.nom = nom;
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

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + '}';
    }

    
    
    
    
}

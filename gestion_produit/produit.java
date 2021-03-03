/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produits.entities;

/**
 *
 * @author ASUS
 */
public class produit {
    private int id;
    private String nom;
    private int prix;
    private String descp;
    
    
    
 

    public produit() {
    }

    @Override
    public String toString() {
        return "produit{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", descp=" + descp + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getPrix() {
        return prix;
    }

    public String getDescp() {
        return descp;
    }

    public produit(int id, String nom, int prix, String descp) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.descp = descp;
    }

    //public String getDescp() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
}

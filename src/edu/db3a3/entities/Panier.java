/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.entities;

/**
 *
 * @author ASUS
 */
public class Panier {

    private int id;
    private String nom;
    private int prix;
    private int qte;
    private int total;

    public Panier() {
    }

    public Panier(int id, String nom, int prix, int qte , int total) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.qte = qte;
        this.total = total;
    }
    
    

  
    public void setQte(int qte) {
        this.qte = qte;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQte() {
        return qte;
    }

    public int getTotal() {
        return total;
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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", qte=" + qte + ", total=" + total + '}';
    }

  

    
    
    
    
}


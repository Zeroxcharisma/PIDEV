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
public class Panier {
    private int id ;
    private int idUser ;
    private String nomProduit;
    private float prix;
    private String image;
    private int quantite;

    public Panier() {
    }

    public Panier(int idUser, String nomProduit, float prix, String image, int quantite) {
        this.idUser = idUser;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
    }

    public Panier(int id, int idUser, String nomProduit, float prix, String image, int quantite) {
        this.id = id;
        this.idUser = idUser;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", idUser=" + idUser + ", nomProduit=" + nomProduit + ", prix=" + prix + ", image=" + image + ", quantite=" + quantite + '}';
    }
    
    
    
}

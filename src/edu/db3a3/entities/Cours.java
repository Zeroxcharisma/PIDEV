/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.entities;

/**
 *
 * @author moham
 */
public class Cours {
  private int id;
    private String nom;
    private String nom_ct ;
    private int nb_heure;
    private String image;

    public Cours(int id, String nom, String nom_ct, int nb_heure, String image) {
        this.id = id;
        this.nom = nom;
        this.nom_ct = nom_ct;
        this.nb_heure = nb_heure;
        this.image = image;
    }

    public Cours() {
    }

    public Cours(String nom, String nom_ct, int nb_heure, String image) {
        this.nom = nom;
        this.nom_ct = nom_ct;
        this.nb_heure = nb_heure;
        this.image = image;
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

    public String getNom_ct() {
        return nom_ct;
    }

    public void setNom_ct(String nom_ct) {
        this.nom_ct = nom_ct;
    }

    public int getNb_heure() {
        return nb_heure;
    }

    public void setNb_heure(int nb_heure) {
        this.nb_heure = nb_heure;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", nom=" + nom + ", nom_ct=" + nom_ct + ", nb_heure=" + nb_heure + ", image=" + image + '}';
    }
    
    

   


  
      
}

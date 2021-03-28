/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.entities;

/**
 *
 * @author Asus
 */
public class Utilisateur1 {
     private int id_utilisateur;
    private String username;
    private String nom;
    private String prenom;
   private String password;
    private String tel;
   private String adresse;
   private int id_role;
   private int etat;
    private String email;

    public Utilisateur1() {
    }

    public Utilisateur1(int id_utilisateur, String nom,String tel) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.tel=tel;
    }
    

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public int getEtat() {
        return etat;
    }

    public int getId_role() {
        return id_role;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getUsername() {
        return username;
    }

    public Utilisateur1(int id_utilisateur, String username, String nom, String prenom, String password, String tel, String adresse, int id_role, int etat, String email) {
        this.id_utilisateur = id_utilisateur;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.tel = tel;
        this.adresse = adresse;
        this.id_role = id_role;
        this.etat = etat;
        this.email = email;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  nom;
    }

  
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.entities;

import javafx.scene.control.Button;

/**
 *
 * @author sofie
 */
public class Utilisateur {
    
  private   Integer    id_utilisateur ;
  private   String username;
  private   String nom ;
  private   String prenom ;
  private   String password ;
  private   Integer tel ;
  private   String adresse;
  private int  id_role ;
  private   int etat;
  private   String email;
  String k;
  String m;
  String l ;
  private Button update; 
  private Button  delete; 
  

    public Utilisateur() {
    }
 
  public Utilisateur (int id_utilisateur ,String nom,String prenom,int  tel,String l,String m,String username,String email,String adresse){
    this.id_utilisateur=id_utilisateur;
    this.nom=nom;
    this.prenom=prenom;
    this.tel=tel;
    this.l=l;
    this.m=m;
    this.username=username;
    this.email=email;
    this.adresse=adresse;}

    public Utilisateur(Integer id_utilisateur, String username, String nom, String prenom, String password, Integer tel, String adresse, int id_role, int etat, String email) {
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

    public Utilisateur(String username, String nom, String prenom, String password, int tel, String adresse, int id_role, int etat, String email) {
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
    
    

    public Utilisateur(int aInt, String string, String string0, int aInt0, String string1, String string2, String string3, String string4, String string5, Button button, Button button0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(String text, String text0, int parseInt, String text1, String text2, String text3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(int id_utilisateur, String nom,Integer tel) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.tel=tel;
    }

    public Integer getId_utilisateur() {
        return id_utilisateur;
    }

    public String getUsername() {
        return username;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public Integer getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getId_role() {
        return id_role;
    }

    public int getEtat() {
        return etat;
    }

    public String getEmail() {
        return email;
    }

    public void setId_utilisateur(Integer id_utilisateur) {
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

    public void setTel(Integer tel) {
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

   /* @Override
    public String toString() {
        return "Utilisateur{" + "id_utilisateur=" + id_utilisateur + ", username=" + username + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", tel=" + tel + ", adresse=" + adresse + ", id_role=" + id_role + ", etat=" + etat + ", email=" + email + '}';
    }*/
    
       @Override
    public String toString() {
        return  nom;
    }
 

    public Utilisateur(Integer id_utilisateur, String username, String nom, String prenom, String password, Integer tel, String adresse, int id_role, int etat, String email, Button update, Button delete) {
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
        this.update = update;
        this.delete = delete;
    }

    public Button getUpdate() {
        return update;
    }

    public Button getDelete() {
        return delete;
    }

    public void setUpdate(Button update) {
        this.update = update;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getM() {
        return m;
    }

    public String getL() {
        return l;
    }

    public void setM(String m) {
        this.m = m;
    }

    public void setL(String l) {
        this.l = l;
    }

   
  
    
}

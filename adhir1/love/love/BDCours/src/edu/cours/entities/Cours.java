/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.entities;

/**
 *
 * @author dell
 */
public class Cours {
    
    private int numCours;
    private int numSalles;
    private String  nomCours;
    private String  nomCoach;
    private String  horraire;
    private String  duree ;
    private String  type;

    public Cours() {
    }

    public Cours(int numCours, int numSalles, String nomCours, String nomCoach, String horraire, String duree, String type) {
        this.numCours = numCours;
        this.numSalles = numSalles;
        this.nomCours = nomCours;
        this.nomCoach = nomCoach;
        this.horraire = horraire;
        this.duree = duree;
        this.type = type;
    }

    public String getDuree() {
        return duree;
    }

    public String getHorraire() {
        return horraire;
    }

    public String getNomCoach() {
        return nomCoach;
    }

    public String getNomCours() {
        return nomCours;
    }

    public int getNumCours() {
        return numCours;
    }

    public int getNumSalles() {
        return numSalles;
    }

    public String getType() {
        return type;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setHorraire(String horraire) {
        this.horraire = horraire;
    }

    public void setNomCoach(String nomCoach) {
        this.nomCoach = nomCoach;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public void setNumCours(int numCours) {
        this.numCours = numCours;
    }

    public void setNumSalles(int numSalles) {
        this.numSalles = numSalles;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cours{" + "numCours=" + numCours + ", numSalles=" + numSalles + ", nomCours=" + nomCours + ", nomCoach=" + nomCoach + ", horraire=" + horraire + ", duree=" + duree + ", type=" + type + '}';
    }

    
   


}

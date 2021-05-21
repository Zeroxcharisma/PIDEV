/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entitie;

/**
 *
 * @author yossr
 */
public class Cours {
    int id;
    String nom;
    int nbHeure;
    String nomCoach;

    public Cours() {
    }

    public Cours(int id, String nom, int nbHeure, String nomCoach) {
        this.id = id;
        this.nom = nom;
        this.nbHeure = nbHeure;
        this.nomCoach = nomCoach;
    }

    public Cours(String nom, int nbHeure, String nomCoach) {
        this.nom = nom;
        this.nbHeure = nbHeure;
        this.nomCoach = nomCoach;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbHeure(int nbHeure) {
        this.nbHeure = nbHeure;
    }

    public void setNomCoach(String nomCoach) {
        this.nomCoach = nomCoach;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNbHeure() {
        return nbHeure;
    }

    public String getNomCoach() {
        return nomCoach;
    }
    
    
}

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
public class Participant {
    int id;
    String nom;
    int evenenment;
    String dateParticipation;

    public Participant() {
    }

    public Participant(int id, String nom, int evenenment, String dateParticipation) {
        this.id = id;
        this.nom = nom;
        this.evenenment = evenenment;
        this.dateParticipation = dateParticipation;
    }

    public Participant(String nom, int evenenment, String dateParticipation) {
        this.nom = nom;
        this.evenenment = evenenment;
        this.dateParticipation = dateParticipation;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getEvenenment() {
        return evenenment;
    }

    public String getDateParticipation() {
        return dateParticipation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEvenenment(int evenenment) {
        this.evenenment = evenenment;
    }

    public void setDateParticipation(String dateParticipation) {
        this.dateParticipation = dateParticipation;
    }
    
    
}

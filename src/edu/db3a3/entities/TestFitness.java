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
public class TestFitness {
    private int id;
    private int duree;
    private String cours;
    private String dateE;
      public TestFitness(int id, int duree, String cours) {
        this.id = id;
        this.duree = duree;
        this.cours = cours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getCours() {
        return cours;
    }

    public void setCours(String cours) {
        this.cours = cours;
    }

    public TestFitness(int duree, String dateE) {
        this.duree = duree;
        this.dateE = dateE;
    }
    

    public TestFitness() {
    }

    public String getDateE() {
        return dateE;
    }

    public void setDateE(String dateE) {
        this.dateE = dateE;
    }

    public TestFitness(int id, int duree, String cours, String dateE) {
        this.id = id;
        this.duree = duree;
        this.cours = cours;
        this.dateE = dateE;
    }

    public TestFitness(int duree, String cours, String dateE) {
        this.duree = duree;
        this.cours = cours;
        this.dateE = dateE;
    }
    
}

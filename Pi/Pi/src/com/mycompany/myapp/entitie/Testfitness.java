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
public class Testfitness {
    int id;
    int duree;
    String dateTest;
    

    public Testfitness() {
    }

    public Testfitness(int id, int duree, String dateTest) {
        this.id = id;
        this.duree = duree;
        this.dateTest = dateTest;
    }

    public Testfitness(int duree, String dateTest) {
        this.duree = duree;
        this.dateTest = dateTest;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setDateTest(String dateTest) {
        this.dateTest = dateTest;
    }

    public int getId() {
        return id;
    }

    public int getDuree() {
        return duree;
    }

    public String getDateTest() {
        return dateTest;
    }


    
    
}

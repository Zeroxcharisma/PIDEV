/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entitie;

import java.util.Date;

/**
 *
 * @author Ahmed laifi
 */
public class Evenement {
    
    private int id;
    private String lieu;
    private String description;
    private String type;
    private String date;

    public Evenement() {
    }
 public Evenement( String lieu, String description, String type, String date) {

        this.lieu = lieu;
        this.description = description;
        this.type = type;
        this.date = date;
    }
    
    public Evenement(int id, String lieu, String description, String type, String date) {
        this.id = id;
        this.lieu = lieu;
        this.description = description;
        this.type = type;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLieux() {
        return lieu;
    }

    public void setLieux(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", lieu=" + lieu + ", description=" + description + ", type=" + type + ", date=" + date + '}';
    }


    
}

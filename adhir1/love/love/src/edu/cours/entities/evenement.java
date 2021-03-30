/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.entities;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Comparator;

/**
 *
 * @author maalaoui
 */
public class evenement {
    private int id;
    private String lieu ;
    private String type;
    private String dcr;
    private String date;

    public evenement() {
    }

    public evenement(int id, String lieu, String type, String dcr, String date) {
        this.id = id;
        this.lieu = lieu;
        this.type = type;
        this.dcr = dcr;
        this.date = date;
    }

    public evenement(String lieu, String type, String dcr, String  date) {
        this.lieu = lieu;
        this.type = type;
        this.dcr = dcr;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getLieu() {
        return lieu;
    }

    public String getType() {
        return type;
    }

    public String getDcr() {
        return dcr;
    }

    public String  getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDcr(String dcr) {
        this.dcr = dcr;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "evenement{" + "id=" + id + ", lieu=" + lieu + ", type=" + type + ", dcr=" + dcr + ", date=" + date + '}';
    }
    
    







}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.entities;

import java.sql.Date;

/**
 *
 * @author maalaoui
 */
public class evenement {
     private int id;
    private String lieu;
    private String  type;
    private String  dcr;
    private Date  date;
    

    public evenement() {
    }

    public evenement(int id,  String lieu, String type, String dcr, Date date) {
        this.id = id;
        this.lieu = lieu;
        this.type = type;
        this.dcr = dcr;
        this.date = date;
        
    }
    public int getId() {
        return id;
    }

    public String getlieu() {
        return lieu;
    }

    public String gettype() {
        return type;
    }
    public String getdcr() {
        return dcr;
    }

    public Date getdate() {
        return date;
    }

   

   

    public void setId(int id) {
        this.id = id;
    }

    public void setlieu(String lieu) {
        this.lieu = lieu;
    }

    public void settype(String typr) {
        this.type = type;
    }

    public void setdcr(String dcr) {
        this.dcr = dcr;
    }

    public void setdate(Date date) {
        this.date = date;
    }

    
    }

  
    
   






/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.entities;

import java.util.Date;

/**
 *
 * @author sofie
 */
public class Participation {
 
  private  int      id_event;
   private  String      type ;   
  private String dcr;
  private String date;

    public Participation(int id_event, String type, String dcr, String date) {
        this.id_event = id_event;
        this.type = type;
        this.dcr = dcr;
        this.date = date;
    }

    

    public Participation() {
    }

   

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDcr() {
        return dcr;
    }

    public void setDcr(String dcr) {
        this.dcr = dcr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Participation{" + "id_event=" + id_event + ", type=" + type + ", dcr=" + dcr + ", date=" + date + '}';
    }

   

    
  
  
  
  
  
}

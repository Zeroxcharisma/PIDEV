   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salles.entities;

/**
 *
 * @author dell
 */
public class Salles {
    
   
    private int numSalles;
     private String nomSalles;
    private String  specialite;
   

    public Salles() {
    }

     

    public Salles(int numSalles, String nomSalles, String specialite) {
        this.numSalles = numSalles;
        this.nomSalles = nomSalles;
        this.specialite = specialite;
    }

   

    public int getNumSalles() {
        return numSalles;
    }

    public String getNomSalles() {
        return nomSalles;
    }

    public String getSpecialite() {
        return specialite;
    }
     

  

    public void setNumSalles(int numSalles) {
        this.numSalles = numSalles;
    }

    public void setNomSalles(String nomSalles) {
        this.nomSalles = nomSalles;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
     

    @Override
    public String toString() {
        return "Salles{" + "numSalles=" + numSalles + ", nomSalles=" + nomSalles + ", specialite=" + specialite + '}';
    }
     

    
   


}
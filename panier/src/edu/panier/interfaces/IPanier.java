/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.panier.interfaces;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IPanier<P> {
    
     public void ajouterPanier(P p);
     public void supprimerPanier(P p);
     public void updatePanier(P p);
     public List<P> displayPanier();
    
}

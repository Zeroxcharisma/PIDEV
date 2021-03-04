/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.PiD.interfaces;

import java.util.List;

/**
 *
 * @author House
 */
public interface IReclamation<T> {
     public void ajouterReclamation(T t);
     public void supprimerReclamation(T t);
     public void updateReclamation(T t);
     public List<T> displayReclamations();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.interfaces;

import java.util.List;

/**
 *
 * @author sofie
 */
public interface IUtilisateur<T> {
    public void ajouterUtilisateur(T t);
     public void supprimerUtilisateur(T t);
     public void modifierUtilisateur(T t);
     public List<T> uesersList();
    
}

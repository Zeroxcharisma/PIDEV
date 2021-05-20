/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class Home2Form extends Form {

    Form current;
    private Resources theme;
    
    /*Garder traçe de la Form en cours pour la passer en paramètres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la méthode showBack*/
    
    public Home2Form() {
        theme =UIManager.initFirstTheme("/theme");
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnUtilisateur = new Button("Utilisateur");
        Button btnevent = new Button("Evenement");
        Button btnproduit = new Button("Produit");
        Button btnpanier = new Button("Panier");
        Button btnCours = new Button("Cours");
        Button btnReclamation = new Button("Reclamation");
        Button btnAbonnement = new Button("Abonnement");
        
        

        btnUtilisateur.addActionListener(e -> new HomeForm(current).show());
        
       // btnDeleteTasks.addActionListener(e -> new DeleteTasksForm(current).show());
        addAll(btnUtilisateur, btnevent,btnproduit,btnpanier,btnCours,btnReclamation,btnAbonnement);
         
    }

}

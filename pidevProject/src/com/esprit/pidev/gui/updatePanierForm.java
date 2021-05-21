/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.pidev.entities.Panier;
import com.esprit.pidev.services.ServicePanier;

/**
 *
 * @author ASUS
 */
public class updatePanierForm extends BaseForm{
    Form current;
    public updatePanierForm(Resources res ,Panier p,Form prev) {
        super("Panier",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Panier");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        
              
       Label ltitre = new Label("Produit : "+p.getNomProduit(),"NewsTopLine2");
        Label ldesc = new Label("Prix : "+p.getPrix(),"NewsTopLine2");
        Label ldateAjout = new Label("Quantite : ","NewsTopLine2"  );
        
        TextField objet = new TextField(String.valueOf(p.getQuantite()) , "Quantite" , 14 , TextField.ANY);
        objet.setUIID("NewsTopLine");       
        objet.setSingleLineTextArea(true);
        
 
        
        
        
        
        
        
        
        Button btnModifier = new Button("Confirmer");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           try{
           p.setQuantite(Integer.parseInt(objet.getText()));
           ServicePanier.getInstance().ModifierPanier(p);
           new PanierListForm(res).show();
           }catch(Exception e){
               Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
           }
           
           
        });
       Button btnAnnuler = new Button("Retour");
       btnAnnuler.addActionListener(e -> {
           prev.showBack();
       });
       
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                ltitre,
                ldesc,
                ldateAjout,
                objet,
                createLineSeparator(),//ligne de séparation
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
    
}

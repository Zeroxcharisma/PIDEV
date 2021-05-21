/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Home;

import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.gui.front.Testfitness.ListCours;
import com.mycompany.myapp.gui.front.Testfitness.ListTest;
import com.mycompany.myapp.gui.front.abonnement.ListAbonnement;
import com.mycompany.myapp.gui.front.evenement.EvenementAffiche;
import com.mycompany.myapp.gui.front.produit.ListCateg;

public class HomeClient extends Form{
 Form current;
    public HomeClient(Form previous) {
                 current=this;
             setTitle("Home Client");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
         
                Button btnCateg = new Button("Catalogue");
        Button btnTest= new Button("Test de fitness");
         Button btnCours= new Button("Cours");
        Button btnAbonnement = new Button("Abonnement");
      
        
        Button btnEv = new Button("Evenement");
          
     btnCateg.addActionListener(e-> new ListCateg(current).show());      
      
        
        btnEv.addActionListener(e-> new EvenementAffiche(current).show());

        btnAbonnement.addActionListener(e-> new ListAbonnement(current).show());
        btnTest.addActionListener(e-> new ListTest(current).show());
        btnCours.addActionListener(e-> new ListCours(current).show());
            this.addAll(btnAbonnement,btnCateg,btnEv,btnTest,btnCours);
    }
    
}

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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.gui.front.chart.ChartDemosForm;
import com.mycompany.myapp.gui.front.evenement.AjouterEvenement;
import com.mycompany.myapp.gui.front.evenement.EvenementAfficheTrier;
import com.mycompany.myapp.gui.front.evenement.MapForm;
import com.mycompany.myapp.gui.front.produit.AjouterProd;
import com.mycompany.myapp.gui.front.produit.ListProdAdmin;

public class HomeAdmin extends Form{
    Resources res;
     Form current;
    public HomeAdmin(Form previous) {
                 current=this;
             setTitle("Home Admin");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
         Button btnGOOGLEMAP = new Button(" MAP ");
    btnGOOGLEMAP.addActionListener(e-> new MapForm(res));
    Button btnaddprod = new Button("Ajouter Produit");
    btnaddprod.addActionListener(e-> new AjouterProd(current).show());
     Button btnprod = new Button("Consulter Produit");
    btnprod.addActionListener(e-> new ListProdAdmin(current).show());
    Button btnAdEv = new Button("Add Evenement");
    Button btnAdEvTr = new Button("Evenement Trier");
      Button btnvalchart = new Button(" stat ");
    btnAdEv.addActionListener(e-> new AjouterEvenement(current).show());
        btnAdEvTr.addActionListener(e-> new EvenementAfficheTrier(current).show());
    
      this.addAll(btnGOOGLEMAP,btnaddprod,btnprod,btnAdEv,btnAdEvTr,btnvalchart);
                            /**************************************************************************************************/
        btnvalchart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                new ChartDemosForm().show();
            }
        });
    }
   
    
}

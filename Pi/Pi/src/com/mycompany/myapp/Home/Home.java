/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Home;

import com.codename1.components.ImageViewer;
import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.mycompany.myapp.MyApplication;
import com.mycompany.myapp.gui.front.Testfitness.ListCours;
import com.mycompany.myapp.gui.front.Testfitness.ListTest;
import com.mycompany.myapp.gui.front.abonnement.ListAbonnement;
import com.mycompany.myapp.gui.front.chart.ChartDemosForm;
import com.mycompany.myapp.gui.front.evenement.AjouterEvenement;
import com.mycompany.myapp.gui.front.evenement.EvenementAffiche;
import com.mycompany.myapp.gui.front.evenement.EvenementAfficheTrier;
import com.mycompany.myapp.gui.front.evenement.MapForm;
import com.mycompany.myapp.gui.front.produit.AjouterProd;
import com.mycompany.myapp.gui.front.produit.ListCateg;

/**
 *
 * @author yossr
 */
public class Home extends Form  {
    Form current;
    int badgeNumber = 0;
    Resources res;
    public Home(Resources res) {
       super(new BorderLayout());
         current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});



  Button btnAdmin = new Button(" Admin ");
    Button btnClient = new Button(" Shop ");

     
 btnClient.addActionListener(e-> new HomeClient(current).show());
  btnAdmin.addActionListener(e-> new HomeAdmin(current).show());

        //**
        this.addAll(btnClient,btnAdmin);
        
 
      
    }
    }
      

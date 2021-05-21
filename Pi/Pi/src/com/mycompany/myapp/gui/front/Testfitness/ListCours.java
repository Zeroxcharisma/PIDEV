/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.Testfitness;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entitie.Cours;
import com.mycompany.myapp.services.CoursService;

import java.util.ArrayList;

/**
 *
 * @author yossr
 */
public class ListCours extends Form{
  Form currentB;
   static Cours c=new Cours();
   ArrayList<Cours> listCategorie=new ArrayList<>();
    public ListCours(Form previous) {
             
           currentB=this;
             setTitle("cours");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
  //insert code of listing all products 
//SpanLabel sp = new SpanLabel();
// sp.setText(ServiceProduct.getInstance().getAllProductsAction().toString());
  //add(sp);
  /***********************************************************************************/
  
         ArrayList<Cours> liste=CoursService.getInstance().getAllCoursAction();
         System.out.println(liste);
  
         Style s3=getAllStyles();
   Container listss = new Container(BoxLayout.y());
        Container lists = new Container(BoxLayout.y());
           for(Cours c1 : liste) {
            listss.add(createCoursContainer(c1));
        }
      /*************************/
            Style st=lists.getAllStyles();
        st.setMargin(Component.BOTTOM,20);
        Tabs t = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
         t.setUIID("Tab");        
        t.addTab("cours", listss);
        t.setScrollableY(true);
         add(t);
    }
     private Container createCoursContainer(Cours categs) {
           
            Button bt=new Button("SHOW");
            Style butStylebn=bt.getAllStyles();

            //butStylebnm.setFgColor(0x000000);   
              butStylebn.setBgTransparency(255);
        butStylebn.setMarginUnit(Style.UNIT_TYPE_DIPS);
        butStylebn.setMargin(Component.BOTTOM, 2);
        butStylebn.setMargin(Component.TOP,3);
        butStylebn.setMargin(Component.LEFT,2);
        
        
           
            //butStylebbn.setFgColor(0x000000);

            
            Label nom1 = new Label("Cours:");

     
//SpanLabel sp = new SpanLabel(); pour le retour a la ligne
            SpanLabel nom =  new SpanLabel("");


 
           Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           cnt.getStyle().setBgColor(0xFFFFFF);
        cnt.getStyle().setBgTransparency(255);
        nom.getAllStyles().setFgColor(0x000000);

         nom1.getAllStyles().setFgColor(0xff6600);

        
        
        
            cnt.add(nom1);
            cnt.add(nom);
 
            

            Style st=cnt.getAllStyles();
            st.setMargin(Component.BOTTOM,2);


            nom.setText(categs.getNom());    


           Container c4=BoxLayout.encloseX(bt);

    //btm.addActionListener(e->{ b=products ;});
    bt.addActionListener(e->{ c=c;new ShowCour().show(); });
       
            /***************************/
     
          
                   return BorderLayout.center(cnt).add(BorderLayout.EAST,c4);
                   
                   
        }

  
    }
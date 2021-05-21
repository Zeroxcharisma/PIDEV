/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.produit;

import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entitie.Categorie;
import com.mycompany.myapp.entitie.Produit;
import com.mycompany.myapp.services.ProduitService;

import java.util.ArrayList;

/**
 *
 * @author yossr
 */
public class ListProd extends Form{
    Form currentB;
   static Produit b=new Produit();
      static String  rechercher;
   ArrayList<Produit> listProduit=new ArrayList<>();
    public ListProd(Form previous) {
             
           currentB=this;
             setTitle("All Products");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
  //insert code of listing all products 
//SpanLabel sp = new SpanLabel();
// sp.setText(ServiceProduct.getInstance().getAllProductsAction().toString());
  //add(sp);
  /***********************************************************************************/
  
         ArrayList<Produit> liste=ProduitService.getInstance().getAllProductsCategAction(ListCateg.c.getId());
/*****************************************Rechercher*****************************************************************/
TextArea recherche  =new TextArea("Type your search here");
 Button btnRechercher = new Button("Rechercher");
    btnRechercher.addActionListener(e->{ rechercher=recherche.getText(); new HomeProduitSearched(currentB).show(); });          
/**********************************************************************************************************/
Container RechercheCont=BoxLayout.encloseY(recherche,btnRechercher);
RechercheCont.getStyle().setBgColor(0x4e9fea);
       RechercheCont.getStyle().setBgTransparency(250);
  
  /***********************************************************************************/
  System.out.println("categ "+ ListCateg.c.getId());
    System.out.println( liste);
         Style s3=getAllStyles();
   Container listss = new Container(BoxLayout.y());
        Container lists = new Container(BoxLayout.y());
           for(Produit c1 : liste) {
            listss.add(createCoursContainer(c1));
        }
      /*************************/
            Style st=lists.getAllStyles();
        st.setMargin(Component.BOTTOM,900);
        Tabs t = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
         t.setUIID("Tab");        
        t.addTab("ma liste", listss);
        t.setScrollableY(true);
         addAll(RechercheCont,t);
    }
     private Container createCoursContainer(Produit products) {
           
            Button bt=new Button("");
            Style butStylebn=bt.getAllStyles();
        
            Button btm=new Button("");
           
            
           
            //butStylebnm.setFgColor(0x000000);   
              butStylebn.setBgTransparency(255);
        butStylebn.setMarginUnit(Style.UNIT_TYPE_DIPS);
        butStylebn.setMargin(Component.BOTTOM, 50);
        butStylebn.setMargin(Component.TOP,30);
        butStylebn.setMargin(Component.LEFT,2);
        
            Button bt1=new Button("");
          Style butStylebnm=bt1.getAllStyles();
            butStylebnm.setBgTransparency(255);
            butStylebnm.setMarginUnit(Style.UNIT_TYPE_DIPS);
            butStylebnm.setMargin(Component.BOTTOM, 50);
            butStylebnm.setMargin(Component.TOP,30);
            butStylebnm.setMargin(Component.LEFT,2);
            butStylebnm.setMargin(Component.LEFT,0);
           
            //butStylebbn.setFgColor(0x000000);

            
            Label nom1 = new Label("NOM:");
            Label prix1 = new Label("PRIX:");
            Label type1 = new Label("TYPE:");
            Label image1 = new Label("IMAGE:");
            Label description1 = new Label("DESCRIPTION:");
     
//SpanLabel sp = new SpanLabel(); pour le retour a la ligne
            SpanLabel nom =  new SpanLabel("");
            SpanLabel prix =  new SpanLabel("");
            SpanLabel type =  new SpanLabel("");
            SpanLabel image =  new SpanLabel("");
            SpanLabel description =  new SpanLabel("");

 
           Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           cnt.getStyle().setBgColor(0xFFFFFF);
        cnt.getStyle().setBgTransparency(255);
        nom.getAllStyles().setFgColor(0x000000);
         prix.getAllStyles().setFgColor(0x000000);
        image.getAllStyles().setFgColor(0x000000);  
        type.getAllStyles().setFgColor(0x000000);
        description.getAllStyles().setFgColor(0x000000);
         nom1.getAllStyles().setFgColor(0xff6600);
        image1.getAllStyles().setFgColor(0xff6600);
        prix1.getAllStyles().setFgColor(0xff6600);
        type1.getAllStyles().setFgColor(0xff6600);
        description1.getAllStyles().setFgColor(0xff6600);
        
        
        
            cnt.add(nom1);
            cnt.add(nom);
            cnt.add(image1);
            cnt.add(image);
            cnt.add(prix1);
            cnt.add(prix);
            cnt.add(type1);
            cnt.add(type);
            cnt.add(description1);
            cnt.add(description);
            

            Style st=cnt.getAllStyles();
            st.setMargin(Component.BOTTOM,2);


            nom.setText(products.getNom());    
            prix.setText("" + products.getPrix());
            type.setText("" + products.getType());
            description.setText(products.getDescription());
                   image.setText(products.getImage());
   

           Container c4=BoxLayout.encloseX(bt,bt1);
            bt1.addActionListener(e->{ 
                listProduit=ProduitService.getInstance().DeleteProductAction(products.getId());
                listProduit=ProduitService.getInstance().getAllProductsCategAction(ListCateg.c.getId());
                 String messagep
                = " ATTENTION UN PRODUIT SUPPRIME  "  + "\t";
                            SendSms.sendSMS(messagep);
                            ToastBar.showInfoMessage("message Sent to:\t " + SendSms.to + " successfully");
                        
           
                Dialog.show("Success", "Voulez-vous supprimer ce Produit?", new Command("OK"));

                cnt.remove();
                c4.remove();
    });
    //btm.addActionListener(e->{ b=products ;});
   // bt.addActionListener(e->{ b=products;new ModifierProd(currentB).show(); });
       
            /***************************/
     
          
                   return BorderLayout.center(cnt).add(BorderLayout.EAST,c4);
                   
                   
        }


  

  
    }
       
   
        

    
    

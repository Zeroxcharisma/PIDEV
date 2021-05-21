/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.abonnement;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entitie.Commentaire;
import com.mycompany.myapp.services.CommentaireService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author yossr
 */
public class ShowAbonnement extends Form{
Form currentC;

     public static ArrayList<Commentaire> listeC;
    public ShowAbonnement(Form previous) {
                 currentC=this;
                        setTitle("Detail Abonnement");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
            getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new ListAbonnement(currentC).show();});
            
           
          Container c=new Container(new FlowLayout(Container.CENTER));
        //c.add(a);
        c.getAllStyles().setMargin(Component.TOP,70);
        add(c);
          Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
   
 /***********************************************************************************/
        
        /*************************************Type*****************************************/
        Label title  =new Label("");
        title.setText(ListAbonnement.a.getType());
        title.getAllStyles().setFgColor(0x000000);
        /******************************************************************************/
        /***********************************Price************************************************/
         Label price  =new Label("");
        price.setText(""+ListAbonnement.a.getPrix()+" TND");
          price.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        price.getAllStyles().setFgColor(0x000000);
        /******************************************************************************/

        /*************************************duree*****************************************/
       Label duree  =new Label("");
       duree.setText(""+ListAbonnement.a.getDuree());
       duree.getAllStyles().setFgColor(0x000000);
        
  /**************************************************************************************************/   
                     Container cnt3=new Container(new FlowLayout(Container.CENTER));
/***********************************************************************************/


c.getAllStyles().setMargin(Component.BOTTOM,150);

Container MainCont=BoxLayout.encloseY( title,price,duree);
MainCont.getAllStyles().setMargin(Component.TOP,1);
MainCont.getAllStyles().setMargin(Component.LEFT,1);
MainCont.getAllStyles().setMargin(Component.RIGHT,1);
MainCont.getAllStyles().setMargin(Component.BOTTOM,1);
MainCont.getStyle().setBgColor(0xFFFFFF);
MainCont.getStyle().setBgTransparency(255);
/*************************************API Display****************************************/
/***********************Commentaire Display****************************************/
//listeC est la liste des commentaire on a besoin de lid produit
listeC=CommentaireService.getInstance().getAllCommentaireAction(ListAbonnement.a.getId());
 Style s3=getAllStyles();
   Container listss = new Container(BoxLayout.y());
        Container lists = new Container(BoxLayout.y());
           for(Commentaire comm : listeC) {
            listss.add(createCoursContainer(comm));
        }
      /*************************/
            Style st=lists.getAllStyles();
        st.setMargin(Component.BOTTOM,900);
        st.setMargin(Component.TOP,50);
        Tabs t = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
         t.setUIID("Tab");        
        t.addTab("Comments", listss);
        t.setScrollableY(true);
        /************************************************************************************************/
        /*************************************Commentaire new****************************************/
        Label comment  =new Label("Leave a comment:");
        TextField comment1 = new TextField("", "Type here...");
        Button btnComment=new Button("New Comment");
                        btnComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((comment1.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        String comment12 = comment1.getText();

                        Commentaire c = new Commentaire(ListAbonnement.a.getId(),comment12);
         
                        if(CommentaireService.getInstance().addCommentaire(c,ListAbonnement.a.getId()))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "id product must be a number", new Command("OK"));
                    }
                    new ShowAbonnement(previous).show();
                }
                
                
            }
        });
                        Container F1=BoxLayout.encloseX(comment, comment1);
                         Container FC=BoxLayout.encloseY(F1, btnComment);
        /************************************************************************************************/
       
addAll(MainCont,t,FC);
    }
    //for the listing of COMMENTS
    private Container createCoursContainer(Commentaire commentaires) {
           
            Button bt=new Button("Like");
            
            Style butStylebn=bt.getAllStyles();
       
            //butStylebnm.setFgColor(0x000000);   
              butStylebn.setBgTransparency(255);
        butStylebn.setMarginUnit(Style.UNIT_TYPE_DIPS);
        butStylebn.setMargin(Component.BOTTOM, 50);
        butStylebn.setMargin(Component.TOP,30);
        butStylebn.setMargin(Component.LEFT,2);

            Label titre1 = new Label("Contenu:");
            Label likes = new Label("");
     
//SpanLabel sp = new SpanLabel(); pour le retour a la ligne
            SpanLabel titre =  new SpanLabel("");


           

           Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           cnt.getStyle().setBgColor(0xFFFFFF);
        cnt.getStyle().setBgTransparency(255);
        titre.getAllStyles().setFgColor(0x000000);
      
         titre1.getAllStyles().setFgColor(0xff6600);
       
        
        
        
            cnt.add(titre1);
            cnt.add(titre);
           cnt.add(likes);
            cnt.add(bt);
            

        Style st=cnt.getAllStyles();
        st.setMargin(Component.BOTTOM,2);


            titre.setText(commentaires.getDescription());    
           likes.setText("("+commentaires.getLikes()+")");
     
Container c4=BoxLayout.encloseX();
    //btm.addActionListener(e->{ b=products ;});
  //pur le bouton like:
                bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
         
              
                    try {
                        if(CommentaireService.getInstance().LikezCommentaire(commentaires.getId()))
                            Dialog.show("Success","Likez",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "id must be a number", new Command("OK"));
                    }
                    new ShowAbonnement(currentC).show();
                
                
                
            }
        });
       
            /***************************/
     
          
                   return BorderLayout.center(cnt).add(BorderLayout.EAST,c4);
                   
                   
        }}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.evenement;

import com.mycompany.myapp.gui.front.produit.SendSms;
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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entitie.Evenement;
import com.mycompany.myapp.services.EvenementService;
import com.mycompany.myapp.services.ParticipantService;



import java.util.ArrayList;

/**
 *
 * @author yossr
 */
public class EvenementAffiche extends Form{
    Form currentB;
   static Evenement b=new Evenement();
   ArrayList<Evenement> listEvenement=new ArrayList<>();
    public EvenementAffiche(Form previous) {
             
           currentB=this;
             setTitle("All events");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

         
                                        /*********************************/
  
         ArrayList<Evenement> liste=EvenementService.getInstance().AllEvenementAction();

  
         Style s3=getAllStyles();
   Container listss = new Container(BoxLayout.y());
        Container lists = new Container(BoxLayout.y());
           for(Evenement c1 : liste) {
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
         add(t);
    }
     private Container createCoursContainer(Evenement ev) {
           
            Button bt=new Button("Participants");
            Style butStylebn=bt.getAllStyles();

           
            
           
            //butStylebnm.setFgColor(0x000000);   
              butStylebn.setBgTransparency(255);
        butStylebn.setMarginUnit(Style.UNIT_TYPE_DIPS);
        butStylebn.setMargin(Component.BOTTOM, 5);
        butStylebn.setMargin(Component.TOP,0);
        butStylebn.setMargin(Component.LEFT,2);
        
            Button bt1=new Button("Participé");
          Style butStylebnm=bt1.getAllStyles();
            butStylebnm.setBgTransparency(255);
            butStylebnm.setMarginUnit(Style.UNIT_TYPE_DIPS);
            butStylebnm.setMargin(Component.BOTTOM, 5);
            butStylebnm.setMargin(Component.TOP,0);
            butStylebnm.setMargin(Component.LEFT,2);
            butStylebnm.setMargin(Component.LEFT,0);
           
            //butStylebbn.setFgColor(0x000000);


            Label lieu1 = new Label("LIEUX:");
            Label description1 = new Label("DESCRIPTION:");
            Label type1 = new Label("TYPE:");
            Label EndAt1 = new Label("DATE:");
     

            SpanLabel lieu =  new SpanLabel("");
            SpanLabel description =  new SpanLabel("");
            SpanLabel type =  new SpanLabel("");
            SpanLabel EndAt =  new SpanLabel("");
     

 
           Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           cnt.getStyle().setBgColor(0xFFFFFF);
        cnt.getStyle().setBgTransparency(255);
        lieu.getAllStyles().setFgColor(0x000000);
        type.getAllStyles().setFgColor(0x000000);  
        EndAt.getAllStyles().setFgColor(0x000000);
        description.getAllStyles().setFgColor(0x000000);
         lieu1.getAllStyles().setFgColor(0xff6600);
        type1.getAllStyles().setFgColor(0xff6600);
        EndAt1.getAllStyles().setFgColor(0xff6600);
        description1.getAllStyles().setFgColor(0xff6600);
        
        
        
            cnt.add(lieu1);
            cnt.add(lieu);
            cnt.add(type1);
            cnt.add(type);
            cnt.add(EndAt1);
            cnt.add(EndAt);
            
            cnt.add(description1);
            cnt.add(description);
         
          
            

            Style st=cnt.getAllStyles();
            st.setMargin(Component.BOTTOM,2);


            lieu.setText(ev.getLieux());    
            type.setText("" + ev.getType());
            description.setText(ev.getDescription());
                   EndAt.setText(ev.getdate());


           Container c4=BoxLayout.encloseY(bt1,bt);
           //en cliquant sur bt1 donc on a un nouveau participant sur cet evenement
            bt1.addActionListener(e->{ 
                ParticipantService.getInstance().addParticipant(ev.getId());
                listEvenement=EvenementService.getInstance().AllEvenementAction();
                Dialog.show("Success", "Voulez-vous participer a cet Evenement?", new Command("OK"));
                String messagep
                = "Vous avez participé a cette  Evenement  "  + "\t";
                            SendSms.sendSMS(messagep);
                            ToastBar.showInfoMessage("message Sent to:\t " + SendSms.to + " successfully");
                        
           

    });
    //bt permet d'afficher toutes les particpants
  bt.addActionListener(e->{ b=ev;new ParticipantAffiche(currentB).show(); });
       
            /***************************/
     
          
                   return BorderLayout.center(cnt).add(BorderLayout.EAST,c4);
                   
                   
        }


  

  
    }
       
   
        

    
    

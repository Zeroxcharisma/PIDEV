/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.evenement;

import com.codename1.components.SpanLabel;
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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entitie.Evenement;
import com.mycompany.myapp.entitie.Participant;
import com.mycompany.myapp.services.EvenementService;
import com.mycompany.myapp.services.ParticipantService;
import java.util.ArrayList;

/**
 *
 * @author yossr
 */
public class ParticipantAffiche extends Form{
        Form currentB;
   static Participant p=new Participant();
   ArrayList<Participant> listParticipant=new ArrayList<>();
    public ParticipantAffiche(Form previous) {
           currentB=this;
             setTitle("Participants");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

         
                                        /*********************************/
  
         ArrayList<Participant> liste=ParticipantService.getInstance().getAllParticipantAction(EvenementAffiche.b.getId());

  
         Style s3=getAllStyles();
   Container listss = new Container(BoxLayout.y());
        Container lists = new Container(BoxLayout.y());
           for(Participant c1 : liste) {
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
     private Container createCoursContainer(Participant participant) {

           
            //butStylebbn.setFgColor(0x000000);


            Label nom1 = new Label("Nom participant:");
            Label date1 = new Label("DATE:");
     
            SpanLabel nom =  new SpanLabel("");
            SpanLabel date =  new SpanLabel("");
     

 
           Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           cnt.getStyle().setBgColor(0xFFFFFF);
        cnt.getStyle().setBgTransparency(255);
        nom.getAllStyles().setFgColor(0x000000);  
        date.getAllStyles().setFgColor(0x000000);
        nom1.getAllStyles().setFgColor(0xff6600);
        date1.getAllStyles().setFgColor(0xff6600);

        
        
        
            cnt.add(nom1);
            cnt.add(nom);
            cnt.add(date1);
            cnt.add(date);
            

            Style st=cnt.getAllStyles();
            st.setMargin(Component.BOTTOM,2);


            nom.setText(participant.getNom());    
            date.setText(participant.getDateParticipation());



           Container c4=BoxLayout.encloseY();

       
            /***************************/
     
          
                   return BorderLayout.center(cnt).add(BorderLayout.EAST,c4);
                   
                   
        }


  

  
    }
   

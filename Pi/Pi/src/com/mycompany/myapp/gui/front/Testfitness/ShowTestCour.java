/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.Testfitness;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.entitie.Cours;
import com.mycompany.myapp.services.CoursService;

import java.util.ArrayList;

/**
 *
 * @author yossr
 */
public class ShowTestCour extends Form{
    Form currentC;
 public static ArrayList<Cours> listeC;
    public ShowTestCour(Form previous) {
                 currentC=this;
                        setTitle("Detail Abonnement");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
            getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new ListTest(currentC).show();});
            
           
          Container c=new Container(new FlowLayout(Container.CENTER));
        //c.add(a);
        c.getAllStyles().setMargin(Component.TOP,70);
        add(c);
          Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
   
 /***********************************************************************************/
        
/*************************************test ID*****************************************/
        Label title  =new Label("");
        title.setText("Test n°"+ListTest.a.getId());
        title.getAllStyles().setFgColor(0x000000);
/******************************************************************************/
/*************************************duree*****************************************/
       Label duree  =new Label("");
       duree.setText(""+ListTest.a.getDuree());
       duree.getAllStyles().setFgColor(0x000000);
       
/**************************************************************************************************/   
/************************************* Date de test*****************************************/
        Label date  =new Label("");
        date.setText("Date de test"+ListTest.a.getDateTest());
        date.getAllStyles().setFgColor(0x000000);
/******************************************************************************/
              Container cnt3=new Container(new FlowLayout(Container.CENTER));
/***********************************************************************************/


c.getAllStyles().setMargin(Component.BOTTOM,150);

Container MainCont=BoxLayout.encloseY( title,duree,date);
MainCont.getAllStyles().setMargin(Component.TOP,1);
MainCont.getAllStyles().setMargin(Component.LEFT,1);
MainCont.getAllStyles().setMargin(Component.RIGHT,1);
MainCont.getAllStyles().setMargin(Component.BOTTOM,1);
MainCont.getStyle().setBgColor(0xFFFFFF);
MainCont.getStyle().setBgTransparency(255);

addAll(MainCont);
    }
}

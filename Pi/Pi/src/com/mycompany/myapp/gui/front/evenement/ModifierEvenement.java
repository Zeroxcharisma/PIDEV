/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.evenement;

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
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.util.StringUtil;
import com.mycompany.myapp.services.EvenementService;


/**
 *
 * @author yossr
 */
public class ModifierEvenement extends Form{
Form currentC;
    public ModifierEvenement(Form previous) {
         currentC=this;
                        setTitle("Update Evenement");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
            getToolbar().addMaterialCommandToLeftBar("back", 
                FontImage.MATERIAL_BACKUP, ev->{new EvenementAffiche(currentC).show();});

 
          Container c=new Container(new FlowLayout(Container.CENTER));
        //c.add(a);
        c.getAllStyles().setMargin(Component.TOP,70);
        add(c);
          Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
         //insert code here code de modifer
         /****************************Title*******************************************************/

         
        Label lieu  =new Label("Lieu  :");
   TextArea lieu1  =new TextArea(""+EvenementAffiche.b.getLieux());
        lieu.getAllStyles().setMargin(Component.BOTTOM,120);

        lieu1.getAllStyles().setMargin(Component.BOTTOM,7);

        Style butStyle3=lieu1.getAllStyles();
        butStyle3.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        lieu.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   lieu1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   lieu1.getAllStyles().setFont(Font.createSystemFont(TOP, TOP, 500));
   lieu.getAllStyles().setFgColor(0xFFFFFF);
   lieu1.getAllStyles().setFgColor(0x000000);

         
         /*****************************************************************************************/
         /********************************En Type***************************************************/
   
         
        Label type  =new Label("Type :");
         TextArea type1  =new TextArea(""+EvenementAffiche.b.getType());
        type.getAllStyles().setMargin(Component.BOTTOM,120);

        type1.getAllStyles().setMargin(Component.BOTTOM,7);

        Style butStyle=type1.getAllStyles();
        butStyle.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        type.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   type1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   type1.getAllStyles().setFont(Font.createSystemFont(TOP, TOP, 500));
   type.getAllStyles().setFgColor(0xFFFFFF);
   type1.getAllStyles().setFgColor(0x000000);


         /****************************DATE*******************************************************/

           
        Label date  =new Label("Date :");
        Picker date1 = new Picker();
        
        date.getAllStyles().setMargin(Component.BOTTOM,120);

        date1.getAllStyles().setMargin(Component.BOTTOM,7);

        Style butStyle1=date1.getAllStyles();
        butStyle1.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        date.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   date.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   date1.getAllStyles().setFont(Font.createSystemFont(TOP, TOP, 500));
   date.getAllStyles().setFgColor(0xFFFFFF);
date1.getAllStyles().setFgColor(0x000000);
/***********************************************************************************/

         /****************************Description*******************************************************/

        Label description  =new Label("Description :");
         TextArea description1  =new TextArea(""+EvenementAffiche.b.getDescription());
        description.getAllStyles().setMargin(Component.BOTTOM,120);

        description1.getAllStyles().setMargin(Component.BOTTOM,7);

        Style butStyle2=description1.getAllStyles();
        butStyle2.setBorder(RoundRectBorder.create().
                strokeColor(0).
                strokeOpacity(120).
                stroke(borderStroke));
        description.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   description.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
   description1.getAllStyles().setFont(Font.createSystemFont(TOP, TOP, 500));
   description.getAllStyles().setFgColor(0xFFFFFF);
description1.getAllStyles().setFgColor(0x000000);
/***********************************************************************************/
    /**************************************************************************************************/             
                        Button valider = new Button("modifier");

          

     
  /**************************************************************************************************/   
                     Container cnt3=new Container(new FlowLayout(Container.CENTER));
/***********************************************************************************/
Container c1=BoxLayout.encloseY(lieu,type,date,description);

Container c3=BoxLayout.encloseY(lieu1,type1,date1,description1);


setScrollableY(false);

cnt3.add(valider);
Container c4=BoxLayout.encloseX(c1,c3);

c.getAllStyles().setMargin(Component.BOTTOM,150);
c4.getAllStyles().setMargin(Component.TOP,10);
c4.getAllStyles().setMargin(Component.LEFT,50);
c4.getAllStyles().setMargin(Component.RIGHT,50);
c4.getStyle().setBgColor(0xff6600);
c4.getStyle().setBgTransparency(250);

                
      valider.addActionListener(e->{
         
              
        EvenementAffiche.b.setLieux(lieu1.getText());         
        EvenementAffiche.b.setDescription(description1.getText());
         String resultDate = StringUtil.replaceAll(date1.getText(), "/", "-");
        EvenementAffiche.b.setdate(resultDate);
        EvenementAffiche.b.setType(type1.getText());
 

  
if(EvenementService.getInstance().UpdateEvenementAction(EvenementAffiche.b))
{                            Dialog.show("Success","Evenement modifié ",new Command("OK"));


} else                             Dialog.show("ERROR", " Server error", new Command("OK"));

});             
      
      
      Container MainCont=BoxLayout.encloseY(c4, cnt3);
MainCont.getAllStyles().setMargin(Component.TOP,1);
MainCont.getAllStyles().setMargin(Component.LEFT,1);
MainCont.getAllStyles().setMargin(Component.RIGHT,1);
MainCont.getAllStyles().setMargin(Component.BOTTOM,1);
MainCont.getStyle().setBgColor(0xFFFFFF);
MainCont.getStyle().setBgTransparency(255);

addAll(MainCont);
/***********************************************************************************/
  /*******************************************************************************************/       
         /*********************************/
          


    
        
    }
    
}

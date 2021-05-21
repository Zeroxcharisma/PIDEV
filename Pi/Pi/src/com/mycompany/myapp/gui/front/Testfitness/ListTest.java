/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.Testfitness;

import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
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
import com.mycompany.myapp.entitie.Testfitness;
import com.mycompany.myapp.services.TestfitnessService;
import java.util.ArrayList;

/**
 *
 * @author yossr
 */
public class ListTest extends Form{
  Form currentB;
   static Testfitness a=new Testfitness();
   static int minA ;
              static      int  maxA;
   ArrayList<Testfitness> listTestfitness=new ArrayList<>();
    public ListTest(Form previous) {
             
           currentB=this;
             setTitle("Test Fitness");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
  //insert code of listing all products 
//SpanLabel sp = new SpanLabel();
// sp.setText(ServiceProduct.getInstance().getAllProductsAction().toString());
  //add(sp);
  /***********************************************************************************/
           ArrayList<Testfitness> liste=TestfitnessService.getInstance().AllTestfitnessAction();
  /*************************************Filtre Bar****************************************/

          Label pricef  =new Label("Price Range :");
          pricef.getStyle().setBgColor(0xffffff);
         TextArea pricef1  =new TextArea("0");
         TextArea pricef2  =new TextArea("0");
          Button btnFiltrer = new Button("Filtrer");
            try {

               btnFiltrer.addActionListener(e->{minA=(int) Float.parseFloat(pricef1.getText());maxA= (int) Float.parseFloat(pricef2.getText());new ListTestFiltred(currentB).show(); });
                  }
            catch(NumberFormatException e){
              Dialog.show("ERROR", "price must be a number", new Command("OK"));  
            }
                          Container F2=BoxLayout.encloseX(pricef,pricef1,pricef2);
     
              
        Container FiltreCont=BoxLayout.encloseY(F2,btnFiltrer);
        FiltreCont.getStyle().setBgColor(0xff6600);
        FiltreCont.getStyle().setBgTransparency(250);
/**********************************************************************************************************/


  
         Style s3=getAllStyles();
   Container listss = new Container(BoxLayout.y());
        Container lists = new Container(BoxLayout.y());
           for(Testfitness c1 : liste) {
            listss.add(createCoursContainer(c1));
        }
      /*************************/
            Style st=lists.getAllStyles();
        st.setMargin(Component.BOTTOM,20);
        Tabs t = new Tabs();
        Style s = UIManager.getInstance().getComponentStyle("Tab");
         t.setUIID("Tab");        
        t.addTab("ma liste", listss);
        t.setScrollableY(true);
           Container mainCont = BoxLayout.encloseY(FiltreCont, t);
         //add(FiltreCont,t);
         add(mainCont);
    }
     private Container createCoursContainer(Testfitness test) {
           
            Button bt=new Button("SHOW");
            Style butStylebn=bt.getAllStyles();

            //butStylebnm.setFgColor(0x000000);   
              butStylebn.setBgTransparency(255);
        butStylebn.setMarginUnit(Style.UNIT_TYPE_DIPS);
        butStylebn.setMargin(Component.BOTTOM, 2);
        butStylebn.setMargin(Component.TOP,3);
        butStylebn.setMargin(Component.LEFT,2);
        
        
           
            //butStylebbn.setFgColor(0x000000);

            
            Label nom1 = new Label("Test"+test.getId());
            Label duree1 = new Label("Durée:");
            Label datetest1 = new Label("Date Test:");
     
//SpanLabel sp = new SpanLabel(); pour le retour a la ligne
            SpanLabel duree =  new SpanLabel("");
            SpanLabel datetest =  new SpanLabel("");

 
           Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
           cnt.getStyle().setBgColor(0xFFFFFF);
        cnt.getStyle().setBgTransparency(255);
         nom1.getAllStyles().setFgColor(0xff6600);

        
        
        
            cnt.add(nom1);
            cnt.add(duree1);
            cnt.add(duree);
            cnt.add(datetest1);
            cnt.add(datetest);
            cnt.add(bt);
            Style st=cnt.getAllStyles();
            st.setMargin(Component.BOTTOM,2);
  
            duree.setText(""+test.getDuree());    
            datetest.setText(""+test.getDateTest());    


           Container c4=BoxLayout.encloseX();

    //btm.addActionListener(e->{ b=products ;});
    bt.addActionListener(e->{ a=test;new ShowTestCour(currentB).show(); });
       
            /***************************/
     
          
                   return BorderLayout.center(cnt).add(BorderLayout.EAST,c4);
                   
                   
        }


  

  
    }

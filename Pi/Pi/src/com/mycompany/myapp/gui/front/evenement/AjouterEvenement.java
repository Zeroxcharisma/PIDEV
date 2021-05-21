/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.evenement;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.util.StringUtil;
import com.mycompany.myapp.entitie.Evenement;
import com.mycompany.myapp.services.EvenementService;


/**
 *
 * @author yossr
 */
public class AjouterEvenement extends Form{
  

    
    public AjouterEvenement(Form previous) {
                setTitle("Add Event");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
        //insert code here
        TextField tflieu = new TextField("","lieu");
         TextField tftype = new TextField("", "type");
        TextField tfdesc = new TextField("", "description");
         Label dated  =new Label("date:");

         Picker date1 = new Picker();
         Button btnValider = new Button("Add");
                btnValider.addActionListener((ActionListener) (ActionEvent evt) -> {
                    if ((tflieu.getText().length()==0)||(tfdesc.getText().length()==0))
                        Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                    else
                    {
                        try {
                            String lieu = tflieu.getText();
                            String type = tftype.getText();
                            String description = tfdesc.getText();
                            String resultDate = StringUtil.replaceAll(date1.getText(), "/", "-");

                         
                            Evenement e = new Evenement(lieu,type,description,resultDate);
                            if(EvenementService.getInstance().addEvenement(e))
                                Dialog.show("Success","Connection accepted",new Command("OK"));
                            else
                                Dialog.show("ERROR", "Server error", new Command("OK"));
                        } catch (NumberFormatException e) {
                            Dialog.show("ERROR", "price must be a number", new Command("OK"));
                        }
                        
                    }
                });
        
        addAll(tflieu,tftype,tfdesc,dated,date1,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}

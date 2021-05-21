/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.front.produit;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entitie.Produit;
import com.mycompany.myapp.services.ProduitService;


/**
 *
 * @author yossr
 */
public class AjouterProd extends Form{
  

    
    public AjouterProd(Form previous) {
                setTitle("Add Product");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToOverflowMenu("Exit",
                                              null, ev-> {Display.getInstance().exitApplication();});
        //insert code here
        TextField tfnom = new TextField("","nom");
         TextField tfprix = new TextField("", "prix");
         TextField tftype = new TextField("", "type");
        TextField tfImage = new TextField("", "image");
        TextField tfdesc = new TextField("", "description");
         Button btnValider = new Button("Add");
                btnValider.addActionListener((ActionListener) (ActionEvent evt) -> {
                    if ((tfnom.getText().length()==0)||(tfdesc.getText().length()==0))
                        Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                    else
                    {
                        try {
                            String nom = tfnom.getText();
                            float prix = Float.parseFloat(tfprix.getText());
                            String type = tftype.getText();
                            String image = tfImage.getText();
                            String description = tfdesc.getText();
                            
                     
                            Produit p = new Produit(nom,prix,type,image,description);
                            if(ProduitService.getInstance().addProduct(p))
                            {
                                Dialog.show("Success","Connection accepted",new Command("OK"));
                            
        LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("It's time to take a break and look at me");
        n.setAlertTitle("Break Time!");
        n.setAlertSound("/notification_sound_bells.mp3"); //file name must begin with notification_sound


        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency
        );
      
                        }         
                            else
                                Dialog.show("ERROR", "Server error", new Command("OK"));
                        } catch (NumberFormatException e) {
                            Dialog.show("ERROR", "price must be a number", new Command("OK"));
                        }
                        
                    }
                });
        
        addAll(tfnom,tfprix,tftype,tfImage,tfdesc,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}

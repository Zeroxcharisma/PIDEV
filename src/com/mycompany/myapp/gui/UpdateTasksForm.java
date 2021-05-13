/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.services.ServiceUtilisateur;


/**
 *
 * @author sofie
 */
public class UpdateTasksForm extends Form{

    public UpdateTasksForm(Form previous) {
        
        
         /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Add a new User");
        setLayout(BoxLayout.y());
        
        TextField tfUsername = new TextField("","Username");
        TextField tfNom= new TextField("", "Nom");
        TextField tfPrenom = new TextField("","Prenom");
        TextField tfPassword = new TextField("","Password");
        TextField tfTel = new TextField("","Telephone");
        TextField tfAdresse = new TextField("","Adresse");
        TextField tfEmail = new TextField("","email");
        Button btnValider = new Button("Add Utilisateur");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfUsername.getText().length()==0)||(tfNom.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                                     
                        Utilisateur t = new Utilisateur(tfUsername.getText(),tfNom.getText(),tfPrenom.getText(),tfPassword.getText(),tfTel.getText(),tfAdresse.getText(),tfEmail.getText());
                        if( ServiceUtilisateur.getInstance().addTask(t))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfUsername,tfNom,tfPrenom,tfPassword,tfTel,tfAdresse, tfEmail, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
                
    }
    
    }
    
    
    


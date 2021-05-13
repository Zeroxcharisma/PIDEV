/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;



import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.ServiceUtilisateur;
/**
 *
 * @author sofie
 */
public class SingInForm extends BaseForm {

    public SingInForm(Resources res) {
        super(new BorderLayout());
        
        if(!Display.getInstance().isTablet()) {
            BorderLayout bl = (BorderLayout)getLayout();
            bl.defineLandscapeSwap(BorderLayout.NORTH, BorderLayout.EAST);
            bl.defineLandscapeSwap(BorderLayout.SOUTH, BorderLayout.CENTER);
        }
        getTitleArea().setUIID("Container");
        setUIID("SignIn");
        
        add(BorderLayout.NORTH, new Label(res.getImage("Logo.png"), "LogoLabel"));
        
        TextField username = new TextField("", "Username", 20, TextField.ANY);
        TextField password = new TextField("", "Password", 20, TextField.PASSWORD);
        username.setSingleLineTextArea(false);
        password.setSingleLineTextArea(false);
        Button signIn = new Button("Sign In");
        Button signUp = new Button("Sign Up");
        
        //mot de passe oublié 
        Button mp =new Button("oublié mot de passe","CenterLabel");
        
        
        
        
        
        signUp.addActionListener(e -> new SignUpForm(res).show());
        signUp.setUIID("Link");
        Label doneHaveAnAccount = new Label("vouz n aver acune compte ?");
        
        Container content = BoxLayout.encloseY(
                new FloatingHint(username),
                createLineSeparator(),
                new FloatingHint(password),
                createLineSeparator(),
                signIn,
                FlowLayout.encloseCenter(doneHaveAnAccount, signUp),mp
        );
        content.setScrollableY(true);
        add(BorderLayout.SOUTH, content);
        signIn.requestFocus();
        signIn.addActionListener(e -> {
           
            ServiceUtilisateur.getInstance().signin(username,password,res);
            
        }
        
        
        
        );
        
        mp.addActionListener(e->{
            
            new ActivateForm(res).show();
            
        } );
        
        
        
        //signIn.addActionListener(e -> new NewsfeedForm(res).show());
    }
    
}
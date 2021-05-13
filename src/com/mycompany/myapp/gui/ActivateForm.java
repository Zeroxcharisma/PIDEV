/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package com.mycompany.myapp.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;



import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.ServiceUtilisateur;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author sofie
 */
public class ActivateForm extends BaseForm {
    TextField email;
    public ActivateForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("Container");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
        setUIID("Activate");
        
        add(BorderLayout.NORTH, 
                BoxLayout.encloseY(
                        new Label(res.getImage("oublié.png"), "LogoLabel"),
                        new Label("Mot de passe oublié!", "LogoLabel")
                )
        );
        
        email = new TextField("", "saisir votre email", 20, TextField.ANY);
        email.setSingleLineTextArea(false);
        
        Button Valider = new Button("Validez");
        Label haveAnAccount = new Label("Retour se connectez ?");
        Button signin = new Button("Renouvelez votre mot de passe");
        signin.addActionListener(e->previous.showBack());
        signin.setUIID("CenterLink");
        
        Container content =BoxLayout.encloseY(
          
                
                new FloatingHint(email),
                createLineSeparator(),
                Valider,
                FlowLayout.encloseCenter(haveAnAccount,signin)
                
                
        );
        
        
        content.setScrollableY(true);
        add(BorderLayout.CENTER,content);
        Valider.requestFocus();
        Valider.addActionListener(e->{
            
            InfiniteProgress ip = new InfiniteProgress();
            final Dialog ipDialog = ip.showInfiniteBlocking();
            
            
            sendMail(res);
            ipDialog.dispose();
            Dialog.show("Mot de passe","nous avons envoyer le mot de pass par votre mail . Veiller verifier votre boite de reception",new Command("ok"));
            new SingInForm(res).show();
            refreshTheme();
        }
        
        
        
        );
        
       
        System.out.println(email.getText());
        
        
    }
    // send mail 
    
    public void sendMail(Resources res){
        try{
            
            String host ="smtp.gmail.com" ;
                        String user = "pidevusers@gmail.com";
                        String pass = "Pidev123*";
                        String to =email.getText() ;
                        String from ="pidevusers@gmail.com" ;
                        String subject = "Coaching Privé : Confirmation du";
                        String mp= ServiceUtilisateur.getInstance().getPasswordByEmail(email.getText().toString(), res);
                         String txt ="Bienvenu Sur VClub : tapez ce mot de passe :"+mp+"dans le champs requis et appuier sur confirmer";
       
                        String messageText = txt;
                        boolean sessionDebug = false;
                        
                        Properties props = new Properties();
                        
                        props.put("mail.smtp.starttls.enable", "true");
                        props.put("mail.smtp.host", host);
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.required", "true");
                        
                       
                        Session mailSession = Session.getDefaultInstance(props, null);
                        mailSession.setDebug(sessionDebug);
                        Message msg = new MimeMessage(mailSession);
                        msg.setFrom(new InternetAddress(from));
                        InternetAddress[] address = {new InternetAddress(to)};
                        msg.setRecipients(Message.RecipientType.TO, address);
                        msg.setSubject(subject); msg.setSentDate(new Date());
                        msg.setText(messageText);
                        
                        Transport transport=mailSession.getTransport("smtp");
                        transport.connect(host, user, pass);
                        transport.sendMessage(msg, msg.getAllRecipients());
                        transport.close();
                        System.out.println("message send successfully");
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
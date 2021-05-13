/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

import com.mycompany.myapp.entities.Utilisateur;
import com.mycompany.myapp.gui.ListTasksForm;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;


/**
 *
 * @author sofie
 */
public class ServiceUtilisateur {
  public ArrayList<Utilisateur> Users;
    
    public static ServiceUtilisateur instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    String json;

    private ServiceUtilisateur() {
         req = new ConnectionRequest();
    }

    public static ServiceUtilisateur getInstance() {
        if (instance == null) {
            instance = new ServiceUtilisateur();
        }
        return instance;
    }

    public boolean addTask(Utilisateur t) {
        String url = Statics.BASE_URL + "/utilisateur/list/users/new?" +"username="+ t.getUsername() + "&nom=" + t.getNom()+ "&prenom=" + t.getPrenom()+ "&password=" + t.getPassword()+ "&tel=" + t.getTel()+ "&adresse=" + t.getAdresse() + "&idRole=1" + "&etat=0"+ "&email=" + t.getEmail(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Utilisateur> parseTasks(String jsonText){
        try {
            Users=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Utilisateur t = new Utilisateur();
                
                float id = Float.parseFloat(obj.get("idUtilisateur").toString());
                
                t.setId_utilisateur((int) id);
               
                 t.setUsername(obj.get("username").toString());
                t.setNom(obj.get("nom").toString());
                t.setPrenom(obj.get("prenom").toString());
                t.setPassword(obj.get("password").toString());
                t.setTel(obj.get("tel").toString());
                t.setAdresse(obj.get("adresse").toString());
               // t.setId_role(Integer.parseInt(obj.get("idRole").toString()));
               // t.setEtat(Integer.parseInt(obj.get("etat").toString()));
                t.setEmail(obj.get("email").toString());
               
                 
                
               
               
                
                //Ajouter la tâche extraite de la réponse Json à la liste
                Users.add(t);
                System.out.println(Users);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return Users;
    }
    
    public ArrayList<Utilisateur> getAllUsers(){
        String url = Statics.BASE_URL+"/utilisateur/list/users";
        
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Users = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Users;
    }
    
    
    //signup
    public void signup(TextField username,TextField nom,TextField prenom,TextField email,TextField password,TextField adresse,TextField tel,TextField idRole,TextField etat ,ComboBox roles ,Resources res){
    
    
    String url = Statics.BASE_URL+ "/user/signup?" +"username="+username.getText().toString()+ "&nom=" +nom.getText().toString()+ "&prenom=" +prenom.getText().toString()+ "&password=" +password.getText().toString()+ "&tel=" +tel.getText().toString()+ "&adresse=" + adresse.getText().toString()+ "&idRole=1" + "&etat=0"+ "&email=" +email.getText().toString()+ "&roles=" + roles.getSelectedItem().toString();
    req.setUrl(url);
    
    if(username.getText().equals(" ") &&nom.getText().equals(" ")&&prenom.getText().equals(" ")&&adresse.getText().equals(" ")&&email.getText().equals(" ")&&tel.getText().equals(" ")&&adresse.getText().equals(" ") ){
        Dialog.show("erreur","veillez rempllir les champs ","OK",null);
    }
    req.addResponseListener((e)->{
        
       
        byte[]data =(byte[])e.getMetaData();
        String responseData = new String(data);
        System.out.println("data =====>"+responseData);
        
    
    });
            NetworkManager.getInstance().addToQueueAndWait(req);
            
    }
    
    public void signin(TextField username ,TextField password,Resources res){
        
        
        
        String url = Statics.BASE_URL+"/user/signin?username="+username.getText().toString()+"&password="+password.getText().toString();
        req = new ConnectionRequest(url , false);
        req.setUrl(url);
        
        req.addResponseListener((e)->{
        System.out.println("rani lenna");
        JSONParser j = new JSONParser();
        String json = new String(req.getResponseData())+"";
        
        try {
            
        if(json.equals("failed")){
            Dialog.show("echec d authentification ","username ou password incorrect ","ok",null);
        }
        else
        {
            
            System.out.println("data =="+json);
            Map<String,Object> user =j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            if(user.size() >0)
                
                Dialog.show("Authentification reussite  ","merci ","ok",null);
            
            
            
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    });
        
         NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public String getPasswordByEmail(String email,Resources res){
        
         String url = Statics.BASE_URL+"/user/getPasswordByEmail?email="+email;
        req = new ConnectionRequest(url , false);
        req.setUrl(url);
         req.addResponseListener((e)->{
             
             JSONParser j = new JSONParser();
         json = new String(req.getResponseData())+"";
        
         try {
             System.out.println("data =="+json);
            Map<String,Object> password =j.parseJSON(new CharArrayReader(json.toCharArray()));
            
            
         }catch(Exception ex){
            ex.printStackTrace();
        }
             
         });
         
          NetworkManager.getInstance().addToQueueAndWait(req);
          return json;
         }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


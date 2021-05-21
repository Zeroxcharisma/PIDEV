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
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entitie.Abonnement;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yossr
 */
public class AbonnementService {
        
         public boolean resultOK;
         public ArrayList<Abonnement> listAbonnement ;
         public static AbonnementService instance=null;

    public AbonnementService() {
    }      
            public static AbonnementService getInstance() {
        if (instance == null) {
            instance = new AbonnementService();
        }
        return instance;}
            
       public ArrayList<Abonnement> parseJsonAction(String jsonText) throws IOException{
        try {
            listAbonnement =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> ListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
 
            List<Map<String,Object>> list = (List<Map<String,Object>>) ListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Abonnement a = new Abonnement();
                float id = Float.parseFloat(obj.get("id").toString());
                a.setId((int)id);
               float date = Float.parseFloat(obj.get("duree").toString());
               a.setDuree((int)date);
               float prix = Float.parseFloat(obj.get("prix").toString());
               a.setPrix(prix);
               a.setType(obj.get("type").toString());
               
              
                listAbonnement.add(a);
            }
  
        } catch (IOException ex) {  
        }
        return listAbonnement;
        }
    
    
    public ArrayList<Abonnement> AllAbonnementAction(){

        String url = Statics.BASE_URL+"abonnement/displayAbonnement";
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listAbonnement = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listAbonnement;
    }
         
}

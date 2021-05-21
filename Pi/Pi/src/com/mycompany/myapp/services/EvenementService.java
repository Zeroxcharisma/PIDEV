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
import com.mycompany.myapp.entitie.Evenement;
import com.mycompany.myapp.entitie.Evenement;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ahmed laifi
 */
public class EvenementService {
    
    
         public boolean resultOK;
         public ArrayList<Evenement> listEvenement ;
         public static EvenementService instance=null;

    public EvenementService() {
     
    }
        
            public static EvenementService getInstance() {
        if (instance == null) {
            instance = new EvenementService();
        }
        return instance;
    }
   

    
            public boolean addEvenement(Evenement e){
         String url = Statics.BASE_URL+"evenement/addEvenement/"+ "?lieu="+e.getLieux()+"&description="+e.getDescription()+"&type="+e.getType()+"&date="+e.getdate();
                 ConnectionRequest req1 = new ConnectionRequest(url);
                 req1.setPost(false);
                  req1.addResponseListener((evt)->{
             
                  resultOK= req1.getResponseCode() == 200; // code http 200 OK
              
        });
        NetworkManager.getInstance().addToQueueAndWait(req1);
         return resultOK;
     }
       
            
         
    public ArrayList<Evenement> parseJsonAction(String jsonText) throws IOException{
        try {
            listEvenement =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> productsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
 
            List<Map<String,Object>> list = (List<Map<String,Object>>) productsListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Evenement e = new Evenement();
                float id = Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
                  
                e.setLieux(obj.get("lieu").toString());
              e.setType(obj.get("type").toString());
                  e.setDescription(obj.get("description").toString());

                    e.setdate(obj.get("date").toString());
              
                listEvenement.add(e);
            }
  
        } catch (IOException ex) {  
        }
        return listEvenement;
        }
    
    
    public ArrayList<Evenement> AllEvenementAction(){

        String url = Statics.BASE_URL+"evenement/displayEvents";
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listEvenement = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listEvenement;
    }
    
    
    
    
    /************************************************************************************************/    
   public ArrayList<Evenement> DeleteEvenementAction(int id){
        String url =Statics.BASE_URL + "evenement/deleteEvenement" + "?id=" + id;
         ConnectionRequest req = new ConnectionRequest(url);
         System.out.println(url);
         req.setUrl(url);
         req.setPost(false);
         req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
            
                    req.removeResponseListener(this);
              
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listEvenement;
    }   

    
    public boolean UpdateEvenementAction(Evenement e) {
        String url = Statics.BASE_URL+"evenement/updateEvenement" + "?id=" + e.getId()+ "&lieu="+e.getLieux()+"&description="+e.getDescription()+"&type="+e.getType()+"&date="+e.getdate();
        ConnectionRequest req = new ConnectionRequest(url);
     req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;   }

    
    
    
    
    public ArrayList<Evenement> evTrierMobileAction(){

        String url = Statics.BASE_URL+"evenement/MobileEvTrier";
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listEvenement = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listEvenement;
    }
 
    
    }

        
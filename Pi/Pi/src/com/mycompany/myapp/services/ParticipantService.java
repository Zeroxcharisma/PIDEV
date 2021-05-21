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
import com.mycompany.myapp.entitie.Participant;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yossr
 */
public class ParticipantService {
             public boolean resultOK;
         public  ArrayList<Participant> listParticipant ;

         public static ParticipantService instance=null;

    public ParticipantService() {
     
    }
        
            public static ParticipantService getInstance() {
        if (instance == null) {
            instance = new ParticipantService();
        }
        return instance;
    }
            
        //ADD : Insert

    
            public boolean addParticipant(int idevenement){
         String url = Statics.BASE_URL+"participant/addParticipant"+ "?idevenement="+idevenement;
                 ConnectionRequest req1 = new ConnectionRequest(url);
                 req1.setPost(false);
                  req1.addResponseListener((evt)->{
             
                  resultOK= req1.getResponseCode() == 200; // code http 200 OK
              
        });
        NetworkManager.getInstance().addToQueueAndWait(req1);
         return resultOK;
     }
            
        public ArrayList<Participant> parseJsonAction(String jsonText) throws IOException{
        try {
            listParticipant =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> ListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
 
            List<Map<String,Object>> list = (List<Map<String,Object>>) ListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Participant p = new Participant();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setId((int)id);
                p.setNom(obj.get("nom").toString());
                String date = obj.get("dateParticipation").toString();
                p.setDateParticipation(date);
                listParticipant.add(p);
            }
  
        } catch (IOException ex) {  
        }
        return listParticipant;
        }
        
            /***************selon l'évenement*********************************************************************************/
    
        public ArrayList<Participant> getAllParticipantAction(int event){

        String url = Statics.BASE_URL+"participant/displayParticipant?evenement="+event;
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listParticipant= parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listParticipant;
    }
}

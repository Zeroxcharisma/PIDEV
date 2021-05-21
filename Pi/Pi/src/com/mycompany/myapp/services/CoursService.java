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
import com.mycompany.myapp.entitie.Cours;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yossr
 */
public class CoursService {
               public boolean resultOK;
         public ArrayList<Cours> listCours ;
         public static CoursService instance=null;  

    public CoursService() {
    }
         
            public static CoursService getInstance() {
        if (instance == null) {
            instance = new CoursService();
        }
        return instance;}
            //parsing
public ArrayList<Cours> parseJsonAction(String jsonText) throws IOException{
        try {
            listCours =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> ListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
 
            List<Map<String,Object>> list = (List<Map<String,Object>>) ListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Cours cours = new Cours();
                 float id = Float.parseFloat(obj.get("id").toString());
                cours.setId((int)id);
                cours.setNom(obj.get("nom").toString());
                float heure = Float.parseFloat(obj.get("nbHeure").toString());
                cours.setNbHeure((int)heure);
                cours.setNomCoach(obj.get("nomCoach").toString());
                listCours.add(cours);

            }
  
        } catch (IOException ex) {  
        }
        return listCours;
        }
              
public ArrayList<Cours> getAllCoursAction(){

        String url = Statics.BASE_URL+"cours/displayCours";
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listCours = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(listCours);
                      
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listCours;
    }
}

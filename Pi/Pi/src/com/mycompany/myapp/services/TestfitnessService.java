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
import com.mycompany.myapp.entitie.Testfitness;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author yossr
 */
public class TestfitnessService {
           public boolean resultOK;
         public ArrayList<Testfitness> listTestfitness ;
         public static TestfitnessService instance=null;  

    public TestfitnessService() {
    }
         
            public static TestfitnessService getInstance() {
        if (instance == null) {
            instance = new TestfitnessService();
        }
        return instance;}
            //parsing
public ArrayList<Testfitness> parseJsonAction(String jsonText) throws IOException{
        try {
            listTestfitness =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> ListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
 
            List<Map<String,Object>> list = (List<Map<String,Object>>) ListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Testfitness a = new Testfitness();
                float id = Float.parseFloat(obj.get("id").toString());
                a.setId((int)id);
               float date = Float.parseFloat(obj.get("duree").toString());
               a.setDuree((int)date);
               a.setDateTest(obj.get("dateTest").toString());
                listTestfitness.add(a);
            }
  
        } catch (IOException ex) {  
        }
        return listTestfitness;
        }
              
public ArrayList<Testfitness> AllTestfitnessAction(){

        String url = Statics.BASE_URL+"testfitness/displayTest";
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listTestfitness = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listTestfitness;
    }


       public ArrayList<Testfitness> getFiltredProductsAction(int min,int max){
   //      ArrayList<Product> result = new  ArrayList<> ;
        String url = Statics.BASE_URL+"testfitness/displayTestFiltred"+"?min="+min+"&max="+max;
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                try {
                    listTestfitness = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                   }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listTestfitness;
    }
}

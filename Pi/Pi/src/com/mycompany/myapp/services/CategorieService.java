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
import com.mycompany.myapp.entitie.Categorie;
import com.mycompany.myapp.entitie.Produit;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yossr
 */
public class CategorieService {
    
         public boolean resultOK;
         public ArrayList<Categorie> listCategorie ;
         public static CategorieService instance=null;

    public CategorieService() {
    }
         
                     public static CategorieService getInstance() {
        if (instance == null) {
            instance = new CategorieService();
        }
        return instance;
    }
       //parsing
    public ArrayList<Categorie> parseJsonAction(String jsonText) throws IOException{
        try {
            listCategorie =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> productsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
 
            List<Map<String,Object>> list = (List<Map<String,Object>>) productsListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Categorie c = new Categorie();
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
          
                c.setDescription(obj.get("description").toString());
                listCategorie.add(c);
            }
  
        } catch (IOException ex) {  
        }
        return listCategorie;
        }
    
    public ArrayList<Categorie> getAllCategsAction(){

        String url = Statics.BASE_URL+"categorie/displayCategs";
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listCategorie = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listCategorie;
    }
}

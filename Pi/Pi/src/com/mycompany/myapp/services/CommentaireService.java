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
import com.mycompany.myapp.entitie.Commentaire;

import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yossr
 */
public class CommentaireService {
             public boolean resultOK;
         public ArrayList<Commentaire> listCommentaire ;
         public static CommentaireService instance=null;

    public CommentaireService() {
    }
         
                public static CommentaireService getInstance() {
        if (instance == null) {
            instance = new CommentaireService();
        }
        return instance;}
                
     //ADD : Insert

    
 public boolean addCommentaire(Commentaire c,int idAb){
     String url = Statics.BASE_URL+"commentaire/addCommentaire?abonnement="+idAb+"&description="+c.getDescription();
                 ConnectionRequest req1 = new ConnectionRequest(url);
                 req1.setPost(false);
                  req1.addResponseListener((evt)->{
             
                  resultOK= req1.getResponseCode() == 200; // code http 200 OK
              
        });
        NetworkManager.getInstance().addToQueueAndWait(req1);
         return resultOK;
     }
            
        public ArrayList<Commentaire> parseJsonAction(String jsonText) throws IOException{
        try {
            listCommentaire =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> ListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
 
            List<Map<String,Object>> list = (List<Map<String,Object>>) ListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Commentaire c = new Commentaire();
                float id = Float.parseFloat(obj.get("id").toString());
                c.setId((int)id);
                c.setDescription(obj.get("Description").toString());
                String date = obj.get("createdAt").toString();
              
              
                c.setDate(date);
                  float like = Float.parseFloat(obj.get("likes").toString());
                  c.setLikes((int)like);
                listCommentaire.add(c);
            }
  
        } catch (IOException ex) {  
        }
        return listCommentaire;
        }
        
            /***************selon l'abonnement*********************************************************************************/
    
        public ArrayList<Commentaire> getAllCommentaireAction(int idAb){

        String url = Statics.BASE_URL+"commentaire/displayCommentaire?abonnement="+idAb;
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listCommentaire= parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listCommentaire;
    }
        
                            //Likez : Insert
     public boolean LikezCommentaire(int c){
         String url = Statics.BASE_URL+"commentaire/likezCommentaire?commentaire="+ c;
                 ConnectionRequest req1 = new ConnectionRequest(url);
                 req1.setPost(false);
                  req1.addResponseListener((evt)->{
             
                  resultOK= req1.getResponseCode() == 200; // code http 200 OK
              
        });
        NetworkManager.getInstance().addToQueueAndWait(req1);
         return resultOK;
     }
     
}

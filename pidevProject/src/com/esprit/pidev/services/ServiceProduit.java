/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.pidev.services;




import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.pidev.utils.Statics;
import java.util.List;
import com.esprit.pidev.entities.Produit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceProduit {
    
    
    //singleton 
    public static ServiceProduit instance = null ;
    
    public static boolean resultOk = true;
   
    ArrayList<Produit> produits = new ArrayList<>();

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServiceProduit getInstance() {
        if(instance == null )
            instance = new ServiceProduit();
        return instance ;
    }
    
    
    
    public ServiceProduit() {
        req = new ConnectionRequest();
        
    }
    
     public ArrayList<Produit> parseProduits(String jsonText){
        
        try {
            produits=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List
                    <Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            //System.out.println(list);
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Produit p = new Produit();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setId((int)id);
                p.setNom(obj.get("nom").toString());
                p.setPrix(Float.parseFloat(obj.get("prix").toString()));
                p.setType(obj.get("type").toString());
                p.setDescription(obj.get("description").toString());
                try{
                    p.setImage(obj.get("image").toString());
                }catch(Exception e){
                
            }
                produits.add(p);
            }
            
            
        } catch (IOException ex) {
            
        }
        return produits;
    }
    
    public ArrayList<Produit>affichageProduits() {
         String url = Statics.BASE_URL+"/panier/list/panierpo";
        req.setUrl(url);
        req.setPost(false);
        req.setHttpMethod("GET");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //System.out.println("printing all data");
                //System.out.println(new String(req.getResponseData()));
                produits = parseProduits(new String(req.getResponseData()));
                //System.out.println(reclamations);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produits;
    }
    
}

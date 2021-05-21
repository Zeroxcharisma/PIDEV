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
import com.esprit.pidev.entities.Panier;
import com.esprit.pidev.entities.Produit;
import com.esprit.pidev.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServicePanier {
    
    //singleton 
    public static ServicePanier instance = null ;
    
    public static boolean resultOk = true;
   
    ArrayList<Panier> paniers = new ArrayList<>();

    //initilisation connection request 
    private ConnectionRequest req;
    
    
    public static ServicePanier getInstance() {
        if(instance == null )
            instance = new ServicePanier();
        return instance ;
    }
    
    public ServicePanier() {
        req = new ConnectionRequest();
        
    }
    
    public void ajoutPanier(Produit p) {
        
        String url =Statics.BASE_URL+"/panier/list/panieer/new?idproduit="+p.getId()+"&idUser=1";        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    
    public void ModifierPanier(Panier p) {
        
        String url =Statics.BASE_URL+"/panier/list/panieer/edit?id="+p.getId()+"&quantite="+p.getQuantite();        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
    public void SupprimerPanier(Panier p) {
        
        String url =Statics.BASE_URL+"/panier/list/panieer/delete/"+p.getId();        
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());//Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        
    }
    
     public ArrayList<Panier> parsePanier(String jsonText){
        
        try {
            paniers=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List
                    <Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            //System.out.println(list);
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Panier p = new Panier();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setId((int)id);
                p.setIdUser((int)Float.parseFloat(obj.get("idUser").toString()));
                p.setPrix(Float.parseFloat(obj.get("prix").toString()));
                p.setNomProduit(obj.get("nomproduit").toString());
                p.setQuantite((int)Float.parseFloat(obj.get("quantity").toString()));
                try{
                    p.setImage(obj.get("img").toString());
                }catch(Exception e){
                
            }
                paniers.add(p);
            }
            
            
        } catch (IOException ex) {
            
        }
        return paniers;
    }
    
    public ArrayList<Panier>affichagePanier() {
         String url = Statics.BASE_URL+"/panier/list/panierlist";
        req.setUrl(url);
        req.setPost(false);
        req.setHttpMethod("GET");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //System.out.println("printing all data");
                //System.out.println(new String(req.getResponseData()));
                paniers = parsePanier(new String(req.getResponseData()));
                //System.out.println(reclamations);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return paniers;
    }
    
}

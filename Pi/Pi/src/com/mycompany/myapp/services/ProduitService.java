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
import com.mycompany.myapp.entitie.Produit;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author Ahmed laifi
 */
    public class ProduitService {
    
         public boolean resultOK;
         public  ArrayList<Produit> listProduit ;
                  public ArrayList<Produit> listProduitC ;
         public static ProduitService instance=null;

    public ProduitService() {
     
    }
        
            public static ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }
    //ADD : Insert

    
            public boolean addProduct(Produit p){
         String url = Statics.BASE_URL+"produit/addProduct/"+ "?nom="+p.getNom()+"&prix="+p.getPrix()+"&type="+p.getType()+"&image="+p.getImage()+"&description="+p.getDescription();
                 ConnectionRequest req1 = new ConnectionRequest(url);
                 req1.setPost(false);
                  req1.addResponseListener((evt)->{
             
                  resultOK= req1.getResponseCode() == 200; // code http 200 OK
              
        });
        NetworkManager.getInstance().addToQueueAndWait(req1);
         return resultOK;
     }
       
    public ArrayList<Produit> parseJsonAction(String jsonText) throws IOException{
        try {
            listProduit =new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            Map<String,Object> productsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
 
            List<Map<String,Object>> list = (List<Map<String,Object>>) productsListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Produit p = new Produit();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setId((int)id);
                p.setNom(obj.get("nom").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                p.setPrix(prix);
                p.setType(obj.get("type").toString());
                p.setImage(obj.get("image").toString());
                p.setDescription(obj.get("description").toString());
                listProduit.add(p);
            }
  
        } catch (IOException ex) {  
        }
        return listProduit;
        }
    
    
    public ArrayList<Produit> getAllProductsAction(){

        String url = Statics.BASE_URL+"produit/displayProducts";
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listProduit = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listProduit;
    } 
    /***************selon categ*********************************************************************************/
    
        public ArrayList<Produit> getAllProductsCategAction(int categ){

        String url = Statics.BASE_URL+"produit/displayProductsCteg?categorie="+categ;
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
     
                try {
                    listProduit = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listProduit;
    }
    
    /************************************************************************************************/    
   public ArrayList<Produit> DeleteProductAction(int id){
        String url =Statics.BASE_URL + "produit/deleteProduct" + "?id=" + id;
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
        return listProduit;
    }   

    public boolean UpdateProductAction(Produit p) {
        String url = Statics.BASE_URL+"produit/updateProduct" + "?id=" + p.getId()+ "&nom="+p.getNom()+"&prix="+p.getPrix()+"&type="+p.getType()+"&image="+p.getImage()+"&description="+p.getDescription();
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

        //SEARCH
public ArrayList<Produit> getSearcheProduitAction(String search){
   //      ArrayList<Product> result = new  ArrayList<> ;
        String url = Statics.BASE_URL+"produit/searchA?searchValue="+search;
        ConnectionRequest req = new ConnectionRequest(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
              try {
                    listProduit = parseJsonAction(new String(req.getResponseData())); // Logger.getLogger(ServiceProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    
                }
                
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return listProduit;
    }
    
    }

        
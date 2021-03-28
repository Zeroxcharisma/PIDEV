/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.services;

import edu.db3a3.entities.evenement;
import edu.db3a3.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author maalaoui
 */
     public class evenementCRUD {
         public ObservableList<evenement> observableListLocataire = FXCollections.observableArrayList();
     public void ajouterevenement(evenement e){
    String requete= "INSERT INTO evenement(id,lieu,type,dcr,date)" + "VALUES(?,?,?,?,?)";
    
        try {
             PreparedStatement pst1 = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);               // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            ///singloton c'st un patron de conception maykhalinich naamel dima new haja il nous permet d'optenir une seule instance de la classe dans la memoire  
        
           
             pst1.setInt(1,e.getId());
             pst1.setString(2,e.getLieu());
             pst1.setString(3,e.getType());
             pst1.setString(4,e.getDcr());
             pst1.setString(5,e.getDate());
            
            pst1.executeUpdate();
            System.out.println("evenement ajoutée");
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     

               
          
    
      public java.util.List<evenement> afficherevenement() {
          List<evenement> evenementList = new ArrayList<>();
           try {
            String requete = "select * from evenement";
            Statement ab = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = ab.executeQuery(requete);
            while(rs.next()){
                evenement r = new evenement();
                r.setId(rs.getInt(1));
                r.setLieu(rs.getString(2));
                r.setType(rs.getString(3));
                r.setDcr(rs.getString(4));
                r.setDate(rs.getString(5));
               evenementList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenementList;
    }
       public void update (evenement e) {
        try {
            String requete = "UPDATE evenement SET Id='"+e.getId()
                    + "',lieu='"+e.getLieu()+ "',type='"+e.getType()
                    +"',dcr='"+e.getDcr()+"',date='"+e.getDate()
                    + "' WHERE Id=" + e.getId();
   PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);                
            int rowsUpdated = pst.executeUpdate(requete);
            if (rowsUpdated > 0) {
            }
 System.out.println("evenement modifiee");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void delete(int Id) {
        try {
            String requete= "DELETE FROM `evenement` WHERE `evenement`.`Id` = ? ";
             PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);              // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            pst.setInt(1, Id);
            pst.executeUpdate();
             System.out.println("evenement supprime");
        } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(evenement evenementss) {
        try {
            String requete= "DELETE FROM `evenement` WHERE `evenement`.`Id` = ? ";
           PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);                         // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            pst.setInt(1, evenementss.getId());
            pst.executeUpdate();
             System.out.println("evenement supprime");
        } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public List<evenement> displayevenement() {
//         List<evenement> evenementList = new ArrayList<>();
//        try {
//            String requete = "SELECT * FROM evenement";
//            Statement pst =  new MyConnection().cn.prepareStatement();
//            ResultSet rs =  pst.executeQuery(requete);
//            while(rs.next()){
//                evenement e = new evenement();
//                e.setId(rs.getInt("id"));
//                e.setlieu(rs.getString("lieu"));
//                e.settype(rs.getString("type"));
//                e.setdcr(rs.getString("dcr"));
//                e.setdate(rs.getDate("date"));
//                evenementList.add(e);
//                System.out.println("Affichage effectue");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return evenementList;
//  }
//     public List<evenement> evenementListe() {
//        List<evenement> list = new ArrayList<>();
//        
//        String requete = "SELECT * FROM evenement";
//        try {
//            
//            PreparedStatement pst = 
//                    new MyConnection().cn.prepareStatement(requete);
//            ResultSet rs = pst.executeQuery(requete);
//            while (rs.next()) {
//                evenement e =new evenement();
//                e.setId(rs.getInt("id"));
//                e.setlieu(rs.getString("lieu"));
//                e.settype(rs.getString("type"));
//                e.setdcr(rs.getString("dcr"));
//                e.setdate(rs.getDate("date"));
//              
//                
//                list.add(e);
//            }
//            
//        } catch(SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return list;
//    }
//       
//public List<evenement> trieParType(){
//    List<evenement> l= this.evenementListe();
//    Collections.sort(l,new evenement());
//    Collections.reverse(l);
//    return l;
//}
    
      public java.util.List<evenement> displaybylieu() {
     ArrayList<evenement> listevenement = new ArrayList<>();
        try {
             String requete= "select * FROM evenement ORDER by lieu ";

            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);                          // howa el boustaji eli yhez requete ywasalha  lel sever w men server yjib el rep   nasn3ou a travers el cn  +s
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                        listevenement.add(new evenement(
                         
                      rs.getInt(1),
                      rs.getString(2),
                      rs.getString(3),
                      rs.getString(4),
                      rs.getString(5)));                                                        
            }
        pst.close();
         System.out.println("evenement trie selon lieu");
      } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listevenement;
    }
      public ArrayList<evenement> FindevenementBytype(String type)  {
  ArrayList<evenement> listevenement = new ArrayList<>();   
   try {
          String requete= "select * from evenement WHERE type='" + type + "' ";
        PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);          
        ResultSet res = pst.executeQuery("select * from evenement WHERE type='" + type + "' ");
        evenement com = null;
        while (res.next()) { 
            com = new evenement(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
            listevenement.add(com);   
        }
        } catch (SQLException ex) {
            Logger.getLogger(evenementCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
                 return listevenement ;
 
    }

   // public void ajouterevenement(evenement evenement) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    public int supprimerevenement(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List chercherevenement(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
//}
//public String Filter(String dcr){int index =dcr.indexOf("bhim");
//if(index!=-1){
  // String str=dcr;
    //for(int i=0;i<4;i++){
      //  str=replaceChar(str,'*',index+i);
        
    //}
    //return str;
    
//}
//return dcr;
    //}
//public String replaceChar(String str, char ch,int index){return str.substring(0,index)+ ch + str.substring(index+1);}

    //public void replaceChar(String str) {
    //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
     
     
     //public void compter(evenement e) {
       // try {
            //evenement con = null;
            //PreparedStatement ste = con.prepareStatement("update evenement set Interstednumber=Interstednumber-1 WHERE id=" + e.getId());
           
           // ste.executeUpdate();
        //} catch (SQLException ex) {
          //  Logger.getLogger(evenement.class.getName()).log(Level.SEVERE, null, ex);
        //}
    //}
     //}
//}
    
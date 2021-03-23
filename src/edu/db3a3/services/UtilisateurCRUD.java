/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.services;

import edu.db3a3.entities.Utilisateur;
import edu.db3a3.gui.DisplayAllController;
import edu.db3a3.interfaces.IUtilisateur;
import edu.db3a3.tools.MyConnection;
import java.sql.Connection;
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
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;

/**
 *
 * @author sofie
 */
public class UtilisateurCRUD implements IUtilisateur<Utilisateur> {
    
  public ObservableList<Utilisateur> observableListLocataire = FXCollections.observableArrayList();     
    
    

    @Override
    public void ajouterUtilisateur(Utilisateur t) {
        try {
            String requete = "INSERT INTO utilisateur (username,nom,prenom,password,tel,adresse,id_role,etat,email)"
                    + "VALUES ('"+t.getUsername()+"','"+t.getPrenom()+"','"+t.getNom()+"','"+md5(t.getPassword())+"','"+t.getTel()+"','"+t.getAdresse()+"','"+t.getId_role()+"','"+t.getEtat()+"','"+t.getEmail()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println("Utilisateur ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerUtilisateur(Utilisateur t) {
     try {
            String requete = "DELETE FROM utilisateur where id_utilisateur=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId_utilisateur());
            pst.executeUpdate();
            System.out.println("Utilisateur supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void modifierUtilisateur(Utilisateur t) {
         try {
            String requete = "update utilisateur set  username =?,nom =?,prenom=?,password=?,tel=?,adresse=?, id_role=?,etat=?, email=? where id_utilisateur=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId_utilisateur());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getNom());
            pst.setString(4, t.getPrenom());
            pst.setString(5, md5(t.getPassword()));
            pst.setInt(6, t.getTel());
            pst.setString(7, t.getAdresse());
            pst.setInt(8, t.getId_role());
            pst.setInt(9, t.getEtat());
            pst.setString(10, t.getEmail());
            
            pst.executeUpdate();
            System.out.println("Utilisateur modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public List<Utilisateur> uesersList() {
        List<Utilisateur> usersList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM utilisateur";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                Utilisateur p = new Utilisateur();
                p.setId_utilisateur(rs.getInt("id_utilisateur"));
                p.setUsername(rs.getString(2));
                p.setNom(rs.getString(3));
                p.setPrenom(rs.getString(4));
                p.setPassword(rs.getString(5));
                p.setTel(rs.getInt("tel"));
                p.setAdresse(rs.getString(7));
                p.setId_role(rs.getInt(8));
                p.setEtat(rs.getInt("etat"));
                p.setEmail(rs.getString(10));
                usersList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usersList;
    }
    public void modifierUtilisateur2(String id_utilisateur, String username, String nom ,String prenom ,String password ,String tel , String adresse , String id_role , String etat , String email) {
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE utilisateur SET username= '"+username+"', nom = '"+nom+"', prenom = '"+prenom+"', password = '"+md5(password)+"' , tel= '"+tel+"' , adresse= '"+adresse+"', id_role= '"+id_role+"', etat= '"+etat+"', email= '"+email+"' WHERE id_utilisateur = '"+id_utilisateur+"' ");
            pst.executeUpdate();
            System.out.println("Utilisateur modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

 public String  validerLogin(String username, String password  ) throws SQLException{
      String k= null;
               String requete = "select count(*) as total from utilisateur where username=? and password=? and etat=0";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             pst.setString(1,username );
              pst.setString(2,md5(password ));
                  
             ResultSet rs=pst.executeQuery();
             rs.next();
             int l1=rs.getInt("total");
             System.out.println("nbr" +l1);
             rs.close();
      
          if (l1!=1){
              k= "utilisateur n'existe pas ";
          }
            else  k=  "utilisateur correct ";
         
         return k;
       
  }
  
 public int getIdUtilisateur (String username, String password) throws SQLException{
        int k=0;
        String requete = "select id_utilisateur  from utilisateur where username=? and password=?";
          
          PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             pst.setString(1,username );
              pst.setString(2,md5(password) );
               ResultSet rs=pst.executeQuery();
              while(rs.next()){
                k=   rs.getInt("id_utilisateur");}
              
              return k;
     }
 
 public int typeUsernumero(String username ) {
         try {
             String requete = "select id_role from utilisateur where username=?";
              PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             pst.setString(1, username );
             ResultSet rs=pst.executeQuery();
              while(rs.next()){
                    int k=   rs.getInt("id_role");
             
              return k ;}
         } catch (SQLException ex) {
             Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
         return 0;
  }
 public String getPassword(String email){
          Utilisateur u =new Utilisateur();
          String s="";
         try {
             String requete = "select * from utilisateur where email=?";
             PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             pst.setString(1, email );
             ResultSet rs=pst.executeQuery();
              while(rs.next()){
       s=rs.getString("password");
              ;}
         } catch (SQLException ex) {
             Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
         return s;
         
     }
 public String md5(String md5) {
   try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
}
 
 
    public void updatePassword(int parseInt ,String password) {
     try {
         String requete = "update utilisateur set password=? where tel=?";
           PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
         
            pst.setString(1, md5(password));
               pst.setInt(2,parseInt);
             
            pst.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    }

public ObservableList<Utilisateur> afficherUtilisateur3()
{
    try {
            
            String requete = "SELECT * from utilisateur";
            Statement st;
            st = MyConnection.getInstance().getCnx()
                    .createStatement();
             ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                                                        
                observableListLocataire.add( new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getInt(9),rs.getString(10)));
            }
    }
             catch (SQLException ex) {
            Logger.getLogger(DisplayAllController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          return observableListLocataire;
    
    
    
}
    
    public void afficherUtilisateur() {
       try {
         
           String requete="select username ,id_utilisateur ,nom ,prenom ,password,tel ,adresse ,libelle ,etat ,email from utilisateur  INNER JOIN role where utilisateur.id_role=role.id_role ";
          PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
           ResultSet rs=pst.executeQuery();
           while(rs.next()){

               System.out.println("persnne id= "+rs.getInt("id_utilisateur")+ "username"+rs.getString("username")+" nom : "+rs.getString("nom")+" prenom : "+rs.getString("prenom")+" motsde passe : "+rs.getString("password")+" tel: "+rs.getInt("tel")+" adresse : "+rs.getString("adresse")+" role : "+rs.getString("libelle")  );
           }
       } catch (SQLException ex) {
           Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    public void setEtat(int i) {
       try {
           
           String requete="update utilisateur set etat=0 where id_utilisateur=?";
           PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
      
         
            
               pst.setInt(1,i);
             
            pst.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    
    }
    
      public boolean debloquer(Integer id_utilisateur) {
           boolean s=false;
       try {
            String requete="update utilisateur set etat=? where id_utilisateur=?";
     PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
         s=true;
             pst.setInt(1,0);
               pst.setInt(2,id_utilisateur );
             
            pst.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    return s;   
    
    }
          public boolean bloquer (Integer id_utilisateur ){
          boolean s=false;
       try {
           
             String requete="update utilisateur set etat=? where id_utilisateur=?";
     PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
        
         s=true;
             pst.setInt(1,2);
               pst.setInt(2,id_utilisateur );
             
            pst.executeUpdate();
       } catch (SQLException ex) {
           Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
    return s;
    
    }
          
          public Utilisateur getUtilisaeur(int id){
          Utilisateur u =new Utilisateur();
         try {
             String requete="select * from utilisateur where id_utilisateur=?";
             PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
        
             pst.setInt(1, id );
             ResultSet rs=pst.executeQuery();
              while(rs.next()){
           
  u =new Utilisateur(rs.getInt("id_utilisateur"),rs.getString("username"),rs.getString("nom"),rs.getString("prenom"),rs.getString("password"),rs.getInt("tel"),rs.getString("adresse"),rs.getInt("id_role"),rs.getInt("etat"),rs.getString("email"))  ;
              ;}
         } catch (SQLException ex) {
             Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
         return u;
         
     }
          
          
              public String ajouterUtilisateur2(Utilisateur t){
        String m="non valide";
       try {
           String requete="select * from utilisateur where username =? and password=?";
           PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, t.getUsername());
             pst.setString(2, md5(t.getPassword()));
            ResultSet rs=pst.executeQuery();
  if(rs.next())
  { 
      System.out.println( "utilisateur existe ");
   
  
  }
  else
  {
         
          String requete2 = "INSERT INTO utilisateur (username,nom,prenom,password,tel,adresse,id_role,etat,email)"
                    + "VALUES ('"+t.getUsername()+"','"+t.getPrenom()+"','"+t.getNom()+"','"+t.getPassword()+"','"+t.getTel()+"','"+t.getAdresse()+"','"+t.getId_role()+"','"+t.getEtat()+"','"+t.getEmail()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete2);
            System.out.println("Utilisateur ajoutée");
       m="vous ete inscrit";
          
  }
       } catch (SQLException ex) {
           Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
       }
       return m;
    }
               public String typeUserView(String username ) {
       String m=null;
         try {
             
             String requete="select nom,libelle from utilisateur INNER JOIN role where utilisateur.id_role=role.id_role and  username=?";
             PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             
             pst.setString(1, username );
             ResultSet rs=pst.executeQuery();
              while(rs.next()){
            
                       m=   rs.getString("libelle");
              ;}
         } catch (SQLException ex) {
             Logger.getLogger(UtilisateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
         return m;
  }
 
}

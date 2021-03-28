/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.PiD.services;

/**
 *
 * @author Asus
 */

import edu.PiD.entities.Reclamation;
import edu.PiD.entities.Utilisateur;
import edu.PiD.interfaces.IReclamation;
import edu.PiD.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class ReclamationCRUD implements IReclamation<Reclamation>{

  @Override
    public void ajouterReclamation(Reclamation t) {
     try {
            String requete = "INSERT INTO reclamation (email,sujet,description,id_user,id_coach)"
                    + "VALUES ('"+t.getEmail()+"','"+t.getSujet()+"','"+t.getDescription()
                    +"','"+t.getId_user()+"','"+t.getId_coach()+"')";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            st.executeUpdate(requete);
            System.out.println("Reclamation ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }
  
    public void ajouterReclamation2(Reclamation t) {
           try {
            String requete= "INSERT INTO reclamation(email,sujet,description,id_user,etat)"
            + "VALUES ('"+t.getEmail()+"','"+t.getSujet()+"','"+t.getDescription()
                    +"','"+t.getId_user()+"','"+t.getEtat()+"')";
            Statement pst = MyConnection.getInstance().getCnx()
                    .createStatement();
         
            pst.executeUpdate(requete);
            System.out.println("Reclamation inserée");  
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

    @Override
    public void supprimerReclamation(Reclamation t) {
  try {
            String requete = "DELETE FROM reclamation where id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId());
            pst.executeUpdate();
            System.out.println("Reclamation supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  }

    @Override
    public void updateReclamation(Reclamation t) {
   try {
            String requete = "UPDATE reclamation SET email=?,sujet=?,description=? WHERE id_user="+t.getId_user();
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
          
            pst.setString(1, t.getEmail());
            pst.setString(2, t.getSujet());
            pst.setString(3, t.getDescription());
            pst.executeUpdate();
            System.out.println("Reclamation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  }
    
 
 public void modifierReclamation2(Integer id, String email, String sujet ,String description ) {
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement("UPDATE reclamation SET email= '"+email+"', sujet = '"+sujet+"', description = '"+description+"'  WHERE id = '"+id+"' ");
            pst.executeUpdate();
            System.out.println("Reclamation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
 
 
 
 
  
   
 
  

    @Override
    public List<Reclamation> displayReclamations() {
       List<Reclamation> reclamationList = new ArrayList<>();
        try {
            String requete = "SELECT * FROM reclamation";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                Reclamation r = new Reclamation();
                r.setId(rs.getInt("id"));
                r.setEmail(rs.getString("email"));
                r.setSujet(rs.getString("sujet"));
                r.setDescription(rs.getString("description"));
               
                reclamationList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamationList;

   
}

     public List<Reclamation>  recherche(String sujet ) {
       List<Reclamation> reclamationList = new ArrayList<>();
         try {
             String requete = "select * from reclamation where sujet='"+sujet+"'";
              PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
             
             ResultSet rs=pst.executeQuery();
              while(rs.next()){
                Reclamation r = new Reclamation();
                r.setId(rs.getInt("id"));
                r.setEmail(rs.getString("email"));
                r.setSujet(rs.getString("sujet"));
                r.setDescription(rs.getString("description"));
               
                reclamationList.add(r);
            }
         } catch (SQLException ex) {
             Logger.getLogger(ReclamationCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
               return reclamationList;
  }
    
     
     
     
       public Reclamation FindReclamationById(int id) {
         Reclamation r = new Reclamation();
        try {
            String requete = "select * from reclamation WHERE id= "+id;
 PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
       ResultSet rs=pst.executeQuery();
       
            while (rs.next()) {
           
                r.setId(rs.getInt("id"));
                r.setEmail(rs.getString("email"));
                r.setSujet(rs.getString("sujet"));
                r.setDescription(rs.getString("description"));
                r.setId_user(rs.getInt("id_user"));
                 }

        } catch (SQLException ex) {
            Logger.getLogger(ReclamationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
       return r;
    }

       
        public void suppReclamation(int id) {
        try {
            String requete = "DELETE FROM reclamation where id=?";
         PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);  pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Réclamation supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }            
    }
        
        
        
        
        
          public List<Reclamation> dReclamations() {
       List<Reclamation> reclamationList = new ArrayList<>();
        try {
            String requete = "SELECT * from utilisateur u,reclamation r where  u.email=r.email ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete);
            while(rs.next()){
                Reclamation r = new Reclamation();
                r.setId(rs.getInt("id"));
               
                r.setEmail(rs.getString("email"));
                r.setSujet(rs.getString("sujet"));
                r.setDescription(rs.getString("description"));
        
                reclamationList.add(r);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamationList;

   
}
        
        
 public List<Utilisateur> getAllCoachs(){
 
                ArrayList<Utilisateur> listuser=new ArrayList<>();

      try {
          String requete="select id_utilisateur,nom,tel from utilisateur where id_role=2";
          Statement st = MyConnection.getInstance().getCnx()
                  .createStatement();
          ResultSet rs= st.executeQuery(requete);
          while(rs.next()){
                        Utilisateur coach= new Utilisateur();

              coach.setId_utilisateur(rs.getInt("id_utilisateur"));
              coach.setNom(rs.getString("nom"));
              coach.setTel(rs.getString("tel"));
              listuser.add(coach);
          }
      } catch (SQLException ex) {
          Logger.getLogger(ReclamationCRUD.class.getName()).log(Level.SEVERE, null, ex);
      }
                return listuser;

 } 
        
        
public int getNumberOfReclamation(int id_coach){
    int b = 0;
    try {
          String requete="select count(*) from reclamation where id_coach="+id_coach;
          Statement st= MyConnection.getInstance().getCnx()
                  .createStatement();
          ResultSet rs = st.executeQuery(requete);
           while(rs.next()){
          b=rs.getInt(1);
           }
           return b;
          
      } catch (SQLException ex) {
          Logger.getLogger(ReclamationCRUD.class.getName()).log(Level.SEVERE, null, ex);
      }
    System.out.println(b);
    return b; 
     
}
public void coachBanner(int id){
      try {
          String requete="UPDATE utilisateur SET etat=0 where id_utilisateur="+id;
          Statement st= MyConnection.getInstance().getCnx()
                  .createStatement();
          st.executeUpdate(requete);
      } catch (SQLException ex) {
          Logger.getLogger(ReclamationCRUD.class.getName()).log(Level.SEVERE, null, ex);
      }
          

}
        
       
    
 }
    







 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.tools;

import edu.cours.entities.evenement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class MyConnection {
  public String url="jdbc:mysql://localhost:3306/evenement";  
  public String login="root";  
  public String pwd=""; 
  public Connection cn;
  private static MyConnection instance;

    public MyConnection() {
   
      try {
         cn= DriverManager.getConnection(url, login,pwd);
         System.out.println("Connexion etablie");
      } catch (SQLException ex) {
        System.out.println("Erreur de Connexion ");
        System.out.println(ex.getMessage());
        
        
         
      }
    }
  
        public Connection getCnx() {
        return cn;
    }
    
    
    public static MyConnection getInstance(){
        if(instance == null){
            instance = new MyConnection();
        }
        return instance;

}

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cours.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class MyConnection {
  public String url="jdbc:mysql://localhost:3306/esprit20";  
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
  
  
  public Connection getConnection(){
  
  return cn;
  
 }
  
 public static MyConnection getInstance(){
 
 if(instance == null){
     
     instance = new MyConnection();
 }
 return instance;
 
 
 } 
  
  
}

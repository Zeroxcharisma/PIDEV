/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.services;

import edu.db3a3.entities.TestFitness;
import edu.db3a3.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moham
 */
public class TestFitnessService {
    private final Connection connexion;
    private Statement ste;

       
       public TestFitnessService() {
     
              connexion= MyConnection.getInstance().getCnx();
    }
       public void ajouterTestFitness(TestFitness e) throws SQLException {
        String req = "INSERT INTO `testfitness` (`duree`, `cours`, `dateE`) VALUES ( ?, ?, ?) ";
        PreparedStatement pstm = connexion.prepareStatement(req);
        pstm.setInt(1, e.getDuree());
        pstm.setString(2, e.getCours());
        pstm.setString(3, e.getDateE());
        pstm.executeUpdate();
    }
       List<TestFitness> getAllTestFitness() throws SQLException {
        List<TestFitness> examen = new ArrayList<>();
        String req = "select * from testfitness";
        Statement stm = connexion.createStatement();
        ResultSet result =  stm.executeQuery(req);    
        while(result.next()){
            TestFitness e = new TestFitness(result.getInt("duree"),result.getString("cours"),result.getString("dateE"));
            examen.add(e);
        }
        
        return examen;
    }
    
    public boolean updateTestFitness(TestFitness e) throws SQLException {
        String sql = "UPDATE testfitness SET duree=?, cours=?, dateE=?  WHERE id=?";

        PreparedStatement statement = connexion.prepareStatement(sql);
        statement.setInt(1, e.getDuree());
        statement.setString(2, e.getCours());
        statement.setString(3, e.getDateE());
        statement.setInt(4, e.getId());
        System.out.println(e.getId());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing product was updated successfully!");
        }
        return true;
    }
    public boolean deleteTestFitness(TestFitness e) throws SQLException {
        PreparedStatement pre = connexion.prepareStatement("DELETE FROM testfitness where id =?");
        pre.setInt(1, e.getId());
        pre.executeUpdate();
        int rowsDeleted = pre.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A Child was deleted successfully!");
        }
        return true;
    }
    public List<TestFitness> readAll() throws SQLException {
        List<TestFitness> arr = new ArrayList<>();
        ste = connexion.createStatement();
        ResultSet rs = ste.executeQuery("select * from testfitness");
        while (rs.next()) {
            int id = rs.getInt(1);
            int duree = rs.getInt("duree");
            String cours = rs.getString("cours");
            String dateE= rs.getString("dateE");
            TestFitness e = new TestFitness(id, duree, cours,dateE);
            arr.add(e);
        }
        return arr;
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import edu.db3a3.entities.Panier;
import edu.db3a3.tools.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficheController implements Initializable {
    
    @FXML
    private TableView<Panier> table;

    @FXML
    private TableColumn<Panier, Integer> id;

    @FXML
    private TableColumn<Panier, String> nom;

    @FXML
    private TableColumn<Panier, String> prix;
    
    @FXML
    private TableColumn<Panier, Integer> qte;
    
    @FXML
    private TableColumn<Panier, Integer> total;
  
    ObservableList<Panier> list = FXCollections.observableArrayList(
            
    );
    @FXML
    private Button tfModifier;
    @FXML
    private Button tfSupprimer;
    @FXML
    private TextField txt_id;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_prix;
    
 
     int index = -1;
    @FXML
    private Button event;
    @FXML
    private Button produit;
    @FXML
    private Button reclamation;
    @FXML
    private Button abonnement;
    @FXML
    private Button panier;
    @FXML
    private Button planning;
    @FXML
    private Label imagePath;
    @FXML
    private Button export;
 
    //methode select //
    void getSelected(MouseEvent event){
        index = table.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            
            return;
        }
        txt_id.setText(id.getCellData(index).toString());
        txt_nom.setText(nom.getCellData(index).toString());
        txt_prix.setText(qte.getCellData(index).toString());
    }
    
    @FXML
     public void edit(ActionEvent event){
       try {
           Connection mc = MyConnection.getInstance().getCnx();
            int value1 = Integer.parseInt(txt_id.getText());
            String value2 = txt_nom.getText();
            String value3 = txt_prix.getText();
            
           String sql = "update panier set id='"+value1+"',nom= '"+value2+"',qte='"+value3+"' where id='"+value1+"' ";
           PreparedStatement pst = mc.prepareStatement(sql);
           pst= mc.prepareStatement(sql);
           pst.execute();
           
           int responce=JOptionPane.showConfirmDialog(null, "voulez-vous modifier ?","vérification",JOptionPane.YES_NO_OPTION);
            if (responce==JOptionPane.YES_OPTION){
                  table.getItems().clear();
            refresh(true);
             TrayNotification tray = null;
        tray = new TrayNotification("produit modifiee", "Votre produit a ete modifiee avec succes ,Merci ", NotificationType.SUCCESS);
       
        tray.showAndDismiss(javafx.util.Duration.seconds(5));
 
            } else{
                System.out.println("modification annuler");
            }
           
           //JOptionPane.showMessageDialog(null, "update");
           //refresh(true);
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
        }    
    }
     
    @FXML
     public void delete(){
         
         Connection mc = MyConnection.getInstance().getCnx();
         String sql = "delete from panier where id = ?";
         try {
             PreparedStatement pst = mc.prepareStatement(sql);
             pst.setString(1,txt_id.getText());
             pst.execute();
            
int responce=JOptionPane.showConfirmDialog(null, "voulez-vous supprimer ?","vérification",JOptionPane.YES_NO_OPTION);
            if (responce==JOptionPane.YES_OPTION){
                  table.getItems().clear();
            refresh(true);
        
        
 
            } else{
                System.out.println("modification annuler");
            }

// JOptionPane.showMessageDialog(null, "supprimer");
             //refresh(true);
             
         } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
         }
              TrayNotification tray = null;
        tray = new TrayNotification("produit supprimer", "Votre produit a ete supprimer avec succes ,Merci ", NotificationType.SUCCESS);
       
        tray.showAndDismiss(javafx.util.Duration.seconds(5));
     }
     
     
    
    /**
     * Initializes the controller class.
     */
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          refresh(true);
              try {
              Connection c= MyConnection.getInstance().getCnx();
              PreparedStatement pt;
              pt = c.prepareStatement("SELECT * from panier");
              ResultSet rs=pt.executeQuery();
             
              while(rs.next()){
                Panier r = new Panier();
                
                r.setId(rs.getInt(1));
                r.setNom(rs.getString(2));
                r.setPrix(rs.getInt(3));
                r.setQte(rs.getInt(4));
                 int  pr = r.getQte();
                 int po = r.getPrix();
                 int total = pr*po;
                r.setTotal(rs.getInt(3*4));
               
           
               list.add(r);}
              refresh(true);
              
              
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          }             
    }    
    
    
    
    
  /*   @FXML
    private void export(ActionEvent event) throws SQLException, IOException {
        
           Connection c= MyConnection.getInstance().getCnx();
           PreparedStatement pt;
           pt = c.prepareStatement("SELECT * from panier");
              ResultSet rs=pt.executeQuery();
           // String requete = "SELECT * FROM panier";
            //Statement st = MyConnection.getInstance().getCnx().createStatement();
           // ResultSet rs =  st.executeQuery(requete);
            
            XSSFWorkbook wb=new XSSFWorkbook();
            XSSFSheet sheet=wb.createSheet("panier");
            XSSFRow header=sheet.createRow(0);
            header.createCell(0).setCellValue("id");
            header.createCell(1).setCellValue("nom");
            header.createCell(2).setCellValue("prix");
            header.createCell(3).setCellValue("qte");
            header.createCell(4).setCellValue("total");
            int index=1;
            while(rs.next()){
                XSSFRow row=sheet.createRow(index);
                row.createCell(0).setCellValue(rs.getInt("id"));
                row.createCell(1).setCellValue(rs.getString("nom"));
                row.createCell(2).setCellValue(rs.getString("prix"));
                row.createCell(3).setCellValue(rs.getDouble("qte"));
                row.createCell(4).setCellValue(rs.getDouble("total"));
                
                index++;
            }
            
        try {
                try (FileOutputStream fileOut = new FileOutputStream ("panier.xlsx")) {
                    wb.write(fileOut);
                }
Alert alert=new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(null);
alert.setContentText("Facture exported successfully");
alert.showAndWait();
c.close();
rs.close();

       
        } catch (FileNotFoundException ex) {
            
        }

    }
    
    */
    
    
    
    
    
    
    
    
    
    public void setTextID(String message) {
        this.id.setText(message);
    }

    public void setTextNom(String message) {
        this.nom.setText(message);
    }

    public void setTextPrix(String message) {
        this.prix.setText(message);
    }

    void setTextqte(String message) {
        this.qte.setText(message);
    }

    void setTexttotale(String message) {
       this.total.setText(message);
    }
    
    
    public void refresh(boolean x){
    if(x==true){
        try {
              Connection c= MyConnection.getInstance().getCnx();
          PreparedStatement pt;
              pt = c.prepareStatement("SELECT * from panier");
              ResultSet rs=pt.executeQuery();
               
               while(rs.next()){
                Panier r = new Panier();
                
                r.setId(rs.getInt(1));
                r.setNom(rs.getString(2));
                r.setPrix(rs.getInt(3));
                r.setQte(rs.getInt(4));
                 int  pr = r.getQte();
                 int po = r.getPrix();
                r.setTotal(pr*po);
                
           
               list.add(r);}  
              
          } catch (SQLException ex) {
              System.out.println(ex.getMessage());
          };
        id.setCellValueFactory(new PropertyValueFactory<Panier,Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Panier,String>("nom"));
        prix.setCellValueFactory(new PropertyValueFactory<Panier,String>("prix"));
        qte.setCellValueFactory(new PropertyValueFactory<Panier,Integer>("qte"));
        total.setCellValueFactory(new PropertyValueFactory<Panier,Integer>("total"));
        
        
        table.setItems(list);   
    
    }
    else
    {}
    
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void produit(ActionEvent event) {
    }

    @FXML
    private void reclamation(ActionEvent event) {
    }

    @FXML
    private void abonnement(ActionEvent event) {
    }

    @FXML
    private void panier(ActionEvent event) {
    }

    @FXML
    private void planning(ActionEvent event) {
    }
    
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.db3a3.gui;

import java.awt.Desktop;
import java.awt.Window;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import edu.db3a3.entities.evenement;
import edu.db3a3.services.evenementCRUD;
import edu.db3a3.tools.MyConnection;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 * FXML Controller class
 *
 * @author sofie
 */
public class EvenementController implements Initializable {

     @FXML
    private TextField tflieu;
    @FXML
    private TextField tftype;
    @FXML
    private Button btnajouterExA;
    @FXML
    private Button btnmodifierExA;
    @FXML
    private Button btnsupprimerExA;
    @FXML
    private Button btnafficherExA;
    @FXML
    private TableView<evenement> tableExA;
    @FXML
    private TableColumn<evenement, String> colidprofile;
    @FXML
    private TableColumn<evenement, String> collieu;
    @FXML
    private TableColumn<evenement, String> coltype;
    @FXML
    private TableColumn<evenement, String> coldcr;
    @FXML
    private TableColumn<evenement, String> coldate;
    @FXML
    private TextField tfdcr;
    @FXML
    private TextField tfid;
    @FXML
    private Button btnchercherExA;
    @FXML
    private Button btntrierExA;
    @FXML
    private TextField tfdate;
    @FXML
    private Button btnyoga;
    @FXML
    private Button btnnatation;
    @FXML
    private Button btnimprimer;
    private javafx.stage.Window evenement;
    @FXML
    private TextField tfatrouver;
  //  @FXML
    //private Object recList;
    //@FXML
   // private Button stat;
    @FXML
    private Button btnstat;
    @FXML
    private Button btnexcel;
    @FXML
    private Button mail;
    @FXML
    private Button event;
    @FXML
    private Button abonnement;
    @FXML
    private Button produit;
    @FXML
    private Button planning;
    @FXML
    private Button reclamation;
    @FXML
    private Button panier;
    @FXML
    private Button user;

    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherevenement() ;
        // TODO
    }    

    @FXML
    private void ajouterevenement(ActionEvent event) throws SQLException, IOException {
        
        if(tfid.getText().isEmpty() | tflieu.getText().isEmpty()|tftype.getText().isEmpty()|tfdcr.getText( ).isEmpty()|tfdate.getText().isEmpty()){      
        
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setHeaderText(null);
        al.setContentText("remplir les champs vides svp");
        al.showAndWait();
            
            
        
        }else{
        
        evenementCRUD e = new evenementCRUD();
        
        int i =Integer.parseInt(tfid.getText());
        
        
        e.ajouterevenement(new evenement(i,tflieu.getText(),tftype.getText(),tfdcr.getText(),tfdate.getText()));
        
       colidprofile.setCellValueFactory(new PropertyValueFactory<>("Id"));
          collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
          coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
          coldcr.setCellValueFactory(new PropertyValueFactory<>("dcr"));
         coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        JOptionPane.showMessageDialog(null,"evenement Ajouté");
        /////////
        
    
//   
//        InputStream music;
//        try {
//            music = new FileInputStream("click.wav");
//            AudioStream audios= new AudioStream(music);
//            AudioPlayer.player.start(audios);
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
//             JOptionPane.showMessageDialog(null, " n'existe pas");
//        }
//        
//        
  }
//        
        
    
        
//      SmsController s= new SmsController();
//          s.send("evenement crée ! ", "b");
       
         
    }

    @FXML
   
        
    private void modifierevenement(ActionEvent event) {
        
           evenement test = (evenement) tableExA.getSelectionModel().getSelectedItem();
           evenementCRUD r = new evenementCRUD();int opt = JOptionPane.showConfirmDialog(null, "Confirmer la Modification ?","Modifier",JOptionPane.YES_NO_OPTION);
      if(opt==0){
           r.update(new evenement (test.getId(),tflieu.getText(),tftype.getText(),tfdcr.getText(),tfdate.getText()));
           JOptionPane.showMessageDialog(null,"evenement modifieé");
        afficherevenement();
        tableExA.refresh();
           
    }}

    @FXML
    private void supprimerevenement(ActionEvent event) {
           evenement r =tableExA.getSelectionModel().getSelectedItem();
    evenementCRUD UC = new evenementCRUD();
    int opt = JOptionPane.showConfirmDialog(null, "Confirmer la supression ?","supprimer",JOptionPane.YES_NO_OPTION);
      if(opt==0){
    UC.delete(r);
    
//    UpdateTable();
        tableExA.refresh();
         JOptionPane.showMessageDialog(null,"evenement suprimer");
         
    }}

    @FXML
    
           private void afficherevenement() {
     ObservableList<evenement> listre = FXCollections.observableArrayList();
        colidprofile.setCellValueFactory(new PropertyValueFactory<>("id"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
        coldcr.setCellValueFactory(new PropertyValueFactory<>("dcr"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        evenementCRUD r = new evenementCRUD();
        List old = r.afficherevenement();
        listre.addAll(old);
        tableExA.setItems(listre);    

    }
    

    @FXML
    private void chercherevenement(ActionEvent event) {
       
                    try {
                   ObservableList<evenement> ofList = FXCollections.observableArrayList();
        colidprofile.setCellValueFactory(new PropertyValueFactory<>("id"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
        coldcr.setCellValueFactory(new PropertyValueFactory<>("dcr"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        /////////////////////////////////////////////////////////////////////////////
        evenementCRUD rt = new evenementCRUD();
        List old = rt.FindevenementBytype(tfatrouver.getText());
        ofList.addAll(old);
        tableExA.setItems(ofList);
        tableExA.refresh();
         JOptionPane.showMessageDialog(null,"evenement trouver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
    

    @FXML
    private void trierevenement(ActionEvent event) {

        ObservableList<evenement> recList = FXCollections.observableArrayList();
        colidprofile.setCellValueFactory(new PropertyValueFactory<>("id"));
        collieu.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
        coldcr.setCellValueFactory(new PropertyValueFactory<>("dcr"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        evenementCRUD rt = new evenementCRUD();
        List old = rt.displaybylieu();
        recList.addAll(old);
        tableExA.setItems(recList);
        tableExA.refresh();
         JOptionPane.showMessageDialog(null,"evenement trier ");
    }
    

    private void UpdateTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void ajouterv1(ActionEvent event) throws IOException {
        
        Desktop.getDesktop().open(new File("1.mp4"));
    }
        
        
    @FXML
    private void ajouterv2(ActionEvent event) throws IOException {
       
        
        Desktop.getDesktop().open(new File("2.mp4"));}
    

    @FXML
    private void imprimerevenement(ActionEvent event) {
  
    System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(evenement); 
            
    Node root = this.tableExA;
           job.printPage(root);
           job.endJob(); }
    
}

   /* @FXML
    private void satistiqueevenement(ActionEvent event) {
       
        try {
            evenement a=new evenement();
            String requete="SELECT type,lieu from evenement ORDER BY type ASC ";
            XYChart.Series<String,String> series=new XYChart.Series<>();
            
            //execute querry and store it in resulttest
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
             ResultSet rs =  pst.executeQuery();
           while(rs.next()){
           series.getData().add(new XYChart.Data<>(rs.getString("type"),rs.getString("lieu")));
           chart.getData().add(Series);
           
           
           }

            
            
        } catch (SQLException ex) {
            Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

//    private static class chart {
//
//        private static Object getData() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        }
//
//        public chart() {
//        }
//    }
//
//    private static class StatController {
//
//        public StatController() {
//        }
//    }

    @FXML
    private void statevenement(ActionEvent event) {
        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        
                        FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("stat.fxml"));
                        try {
                            loader.load();
                           
                           
                              } catch (IOException ex) {
                            Logger.getLogger(EvenementController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Parent parent = loader.getRoot();
                        stage.setScene(new Scene(parent));
                        stage.show();
        
        
    }
private void Excel(File file) throws FileNotFoundException, IOException {

        try {
            //System.out.println("Clicked,waiting to export....");

            FileOutputStream fileOut;
            fileOut = new FileOutputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet workSheet = workbook.createSheet("sheet 0");

            workSheet.setColumnWidth(1, 25);

            HSSFFont fontBold = workbook.createFont();
            fontBold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.setFont(fontBold);

            Row row1 = workSheet.createRow((short) 0);
            workSheet.autoSizeColumn(7);
            row1.createCell(0).setCellValue("Id");
            row1.createCell(1).setCellValue("lieu");
            row1.createCell(2).setCellValue("type");
            row1.createCell(3).setCellValue("dcr");
            row1.createCell(4).setCellValue("date");
            Row row2;

            String req = "SELECT * from evenement ";
            Statement ab = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = ab.executeQuery(req);
            while (rs.next()) {
                int a = rs.getRow();
                row2 = workSheet.createRow((short) a);

                row2.createCell(0).setCellValue(rs.getInt(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));

            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();

        } catch (SQLException e) {
            System.out.println("controllers.CommandeBack.ExcelAction()");

        }
    }

    @FXML
    private void excel(ActionEvent event) throws IOException {
         FileChooser chooser = new FileChooser();
        // Set extension filter
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Excel Files(.xls)", ".xls");
        chooser.getExtensionFilters().add(filter);
        // Show save dialog
        File file = chooser.showSaveDialog(btnexcel.getScene().getWindow());
        if (file != null) {
            Excel(file);
        }
    }

    @FXML
   
        void sendMail(){
        String to = "ma123adhir@gmail.com";
        String from = "maalaouimalaoui1@gmail.com";
        String host = "smtp.gmail.com";
        final String username = "maalaouimalaoui1@gmail.com";
        final String password ="adhir.123.4";
        ////SETUP SERVER
        Properties props = System.getProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        try{
            javax.mail.Session session = javax.mail.Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username, password);
            }
        });
            //create mail
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            m.setSubject("evenement Ajouter");
            Integer id = Integer.parseInt(tfid.getText());
            String lieu = tflieu.getText();
            String type = tftype.getText();
            String desc = tfdcr.getText();
            String date = tfdate.getText();
            m.setText("Votre evennement est ajoutee avec succes "
                    + "\n id = "+id
                    + "\n Lieu = "+lieu
                    + "\n type = "+type
                    + "\n description = "+desc
                    + "\n Date = "+date
            );
            //send mail
            Transport.send(m);
            //sentBoolValue.setVisible(true);
            System.out.println("Message sent!");
        }   catch (javax.mail.MessagingException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void event(ActionEvent event) {
    }

    @FXML
    private void abonnement(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }


    @FXML
    private void produit(ActionEvent event) {
    }

    @FXML
    private void planning(ActionEvent event) {
        
        try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("IAdmin.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
    }

    @FXML
    private void reclamation(ActionEvent event) {
        
        try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("DelRec.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
        
        
    }

    @FXML
    private void panier(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("GestionPanier.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
        
    }

    @FXML
    private void user(ActionEvent event) {
         try {
           Parent exercices_parent = FXMLLoader.load(getClass().getResource("DisplayAll.fxml"));
           Scene ex_section_scene = new Scene(exercices_parent);
           Stage second_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
           
           second_stage.setScene(ex_section_scene);
           second_stage.show();
                   
                   
                   } catch (IOException ex) {
         
       }
        
    }
    

    
    class frmV {

        public frmV() {
        }}
    
         private void selection (MouseEvent event){
    evenement test = (evenement) tableExA.getSelectionModel().getSelectedItem();
    tfid.setText(Integer.toString(test.getId()));
    tflieu.setText(test.getLieu());
    tftype.setText(test.getType());
    tfdcr.setText(test.getDcr());
    tfdate.setText(test.getDate());
    

}
       
}


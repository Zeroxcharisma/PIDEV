package edu.db3a3.gui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import com.pdfjet.A4;
import com.pdfjet.Cell;
import com.pdfjet.CoreFont;
import com.pdfjet.Font;
import com.pdfjet.PDF;
import com.pdfjet.Page;
import com.pdfjet.Table;

import edu.db3a3.services.BonPlanService;
import static edu.db3a3.services.BonPlanService.ACCOUNT_SID;
import static edu.db3a3.services.BonPlanService.AUTH_TOKEN;


import edu.db3a3.entities.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;

public class GestionProduit {
	@FXML
	private TextField research;

	@FXML
	private Button Rechercher;

	@FXML
	private TableView<Produit> Tableau;
	
	ObservableList<Produit> produits = FXCollections.observableArrayList();
	ObservableList<Produit> selectedproduit;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

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
	private Button user;

	@FXML
	private TableColumn<Produit, String> nom;

	@FXML
	private TableColumn<Produit, String> descr;
	@FXML
	private TableColumn<Produit, Double> prix;

	@FXML
	private TableColumn<Produit, String> typeva;

	@FXML
	private TableColumn<Produit, byte[]> img;

	@FXML
	private Button Ajouter;

	@FXML
	private Button modif;

	@FXML
	private Button Supprimer;
	
    @FXML
    private Button tableaubord;

	@FXML
	void abonnement(ActionEvent event) {

	}
	
    @FXML
    private Button generate;

     
    //pdf        
    @FXML
    void Startgenerationpdf(ActionEvent event) throws Exception {
    	LocalDateTime date = LocalDateTime.now();
    	File out = new File("Extraction"+date.getNano()+".pdf") ; 
        FileOutputStream fos = new FileOutputStream(out) ;
        PDF pdf = new PDF(fos) ; 
        Page page = new Page(pdf, A4.PORTRAIT)  ; 
        Font f1 = new Font(pdf, CoreFont.HELVETICA_BOLD) ;
        Font f2 = new Font(pdf, CoreFont.HELVETICA) ;
        Table table = new Table() ; 
        List<List<Cell>> tabledata = new ArrayList<List<Cell>>() ;       
        List<Cell> tablerow = new ArrayList<Cell>() ; 
        Cell cell = new Cell(f1,"Nom");
        tablerow.add(cell) ; 
        cell = new Cell(f1, "Description");
        tablerow.add(cell) ;
        cell = new Cell(f1, "Type");
        tablerow.add(cell) ;
        cell = new Cell(f1, "Prix");
        tablerow.add(cell) ;   
    tabledata.add(tablerow) ;     
   List<Produit> items = Tableau.getItems() ; 
	for (Produit co : items) {
		Cell nc = new Cell(f2, co.getNom_bp());
		Cell prc = new Cell(f2, co.getDesc_bp());
		Cell gc = new Cell(f2, co.getType_bp());
		Cell lc = new Cell(f2, String.valueOf((co.getPrix_bp())));
		tablerow = new ArrayList<Cell>();
		tablerow.add(nc);
		tablerow.add(prc);
		tablerow.add(gc);
		tablerow.add(lc);
		tabledata.add(tablerow) ; 
	}
        
    
    table.setData(tabledata);
    table.setPosition(10f, 60f);
    table.setColumnWidth(0, 90f); 
    table.setColumnWidth(1, 90f); 
    table.setColumnWidth(2, 90f); 
    table.setColumnWidth(3, 90f); 
    table.setColumnWidth(4, 250f);  
    
    
    while(true){
    table.drawOn(page) ; 
    if(!table.hasMoreData()){
    table.resetRenderedPagesCount(); 
    break ; 
    
    }
    
    page=new Page(pdf,A4.PORTRAIT) ; 
    
    
    }
    
    pdf.flush();
    fos.close(); 
        System.out.println("saved to "+out.getAbsolutePath());
        

    }
	
    @FXML
    void gotoTableau(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/PieChart.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

    }

	@FXML
	void event(ActionEvent event) {

	}

	@FXML
	void gotoAjouter(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/AjouterProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	void gotoModifier(ActionEvent event) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/gui/ModifierProduit.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		ModifierProduit modifier = loader.getController();
		if (Tableau.getSelectionModel() != null && Tableau.getSelectionModel().getSelectedItems().get(0) !=null) {
			modifier.initdata((Produit) Tableau.getSelectionModel().getSelectedItems().get(0));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		}
	}

	@FXML
	void gotoSupprimer(ActionEvent event) throws ClassNotFoundException {

		selectedproduit = Tableau.getSelectionModel().getSelectedItems();
		if (selectedproduit.size() > 0) {
			for (Produit produit : selectedproduit)
				BonPlanService.getInstance().supprimerBonPlan(produit);
			produits.clear();
			List<Produit> produitsaux = BonPlanService.getInstance().displayAllList();
			for (int i = 0; i < produitsaux.size(); i++) {
				produits.add(produitsaux.get(i));
			}
                        int opt = JOptionPane.showConfirmDialog(null, "Confirmer la supression ?","supprimer",JOptionPane.YES_NO_OPTION);
                      /*  SMS s=new SMS();
                       s.SendSMS("rourou2020","rourou@2020","un produit a étè supprimé","+21650089056","https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");*/
                        sendsms("Porduit Supprimmer !!") ; 
			Notifications notificationBuilder = Notifications.create().title("Produit supprime").graphic(null).hideAfter(javafx.util.Duration.seconds(5)).position(Pos.TOP_LEFT);
			notificationBuilder.show();
			Tableau.setItems(produits);
                      

  
		}
		else {
      
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Suppression du produit");
			alert.setContentText("Aucun choix n'est selectionne !");
			alert.showAndWait();
		}

	}

	@FXML
	void panier(ActionEvent event) {

	}

	@FXML
	void planning(ActionEvent event) {

	}

	@FXML
	void produit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GestionProduit.fxml"));
	Scene scene = new Scene(root);
	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stage.setScene(scene);
	stage.show();

	}

	@FXML
	void reclamation(ActionEvent event) {

	}

	@FXML
	void user(ActionEvent event) {

	}

	@FXML
	private Button ordonner;

	@FXML
	void gotoOrdononner(ActionEvent event) throws ClassNotFoundException {
		produits.clear();
		List<Produit> produitsaux = BonPlanService.getInstance().displayAllListtrie();
		if (!produitsaux.isEmpty()) {
			for (int i = 0; i < produitsaux.size(); i++) {
				produits.add(produitsaux.get(i));
			}
		}
		descr.setCellValueFactory(new PropertyValueFactory<Produit, String>("desc_bp"));
		nom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom_bp"));
		prix.setCellValueFactory(new PropertyValueFactory<Produit, Double>("prix_bp"));
		typeva.setCellValueFactory(new PropertyValueFactory<Produit, String>("type_bp"));
		Tableau.setItems(produits);

	}

	@FXML
	void gotoRechercher(ActionEvent event) throws ClassNotFoundException {
		String critere = research.getText().toLowerCase();
		if (critere.length() > 0) {
			produits.clear();
			List<Produit> produitsaux = BonPlanService.getInstance().displayRecherche(critere.toLowerCase());
			if (!produitsaux.isEmpty()) {
				for (int i = 0; i < produitsaux.size(); i++) {
					produits.add(produitsaux.get(i));
				}
			}
			descr.setCellValueFactory(new PropertyValueFactory<Produit, String>("desc_bp"));
			nom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom_bp"));
			prix.setCellValueFactory(new PropertyValueFactory<Produit, Double>("prix_bp"));
			typeva.setCellValueFactory(new PropertyValueFactory<Produit, String>("type_bp"));
			Tableau.setItems(produits);
		}
		else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setHeaderText("Recherche du produit");
			alert.setContentText("Critere non valide !");
			alert.showAndWait();
		}
	}//sms
         public void sendsms(String s){
          String ACCOUNT_SID =
            "AC90b331c56632553c2da783edd5eb986b";
     String AUTH_TOKEN =
            "46a67e21e2b778f17bcd67515fcadd88";
          Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
       Message message = Message.creator(new PhoneNumber("+21650089056"),
        new PhoneNumber("+12028497924"),s).create();
    
    } 
	@FXML
	void initialize() throws ClassNotFoundException {
		assert event != null : "fx:id=\"event\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert produit != null : "fx:id=\"produit\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert reclamation != null
				: "fx:id=\"reclamation\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert abonnement != null
				: "fx:id=\"abonnement\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert panier != null : "fx:id=\"panier\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert planning != null : "fx:id=\"planning\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert imagePath != null : "fx:id=\"imagePath\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert nom != null : "fx:id=\"nom\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert descr != null : "fx:id=\"descr\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert typeva != null : "fx:id=\"typeva\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert img != null : "fx:id=\"img\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert Ajouter != null : "fx:id=\"Ajouter\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert modif != null : "fx:id=\"modif\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert Supprimer != null : "fx:id=\"Supprimer\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert prix != null : "fx:id=\"prix\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert Ajouter != null : "fx:id=\"Ajouter\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert ordonner != null : "fx:id=\"ordonner\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert research != null : "fx:id=\"research\" was not injected: check your FXML file 'GestionProduit.fxml'.";
		assert Rechercher != null : "fx:id=\"Rechercher\" was not injected: check your FXML file 'GestionProduit.fxml'.";
        assert tableaubord != null : "fx:id=\"tableaubord\" was not injected: check your FXML file 'GestionProduit.fxml'.";
        assert generate != null : "fx:id=\"generate\" was not injected: check your FXML file 'GestionProduit.fxml'.";

		List<Produit> produitsaux = BonPlanService.getInstance().displayAllList();
		if (!produitsaux.isEmpty()) {
			
			for (int i = 0; i < produitsaux.size(); i++) {
				produits.add(produitsaux.get(i));
			}
		}
		descr.setCellValueFactory(new PropertyValueFactory<Produit, String>("desc_bp"));
		nom.setCellValueFactory(new PropertyValueFactory<Produit, String>("nom_bp"));
		prix.setCellValueFactory(new PropertyValueFactory<Produit, Double>("prix_bp"));
		typeva.setCellValueFactory(new PropertyValueFactory<Produit, String>("type_bp"));
		Tableau.setItems(produits);

	}
}

package edu.db3a3.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import edu.db3a3.entities.Produit;
import edu.db3a3.services.BonPlanService;
import javax.imageio.ImageIO;

import org.controlsfx.control.Notifications;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ModifierProduit {
	public File imageload;
	@FXML
	private Button event;

	@FXML
	private Button produit;

	@FXML
	private Button precedant;
	@FXML
	private ImageView Imagevue = new ImageView();
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
	private TextField nom;

	@FXML
	private ComboBox<String> type;

	@FXML
	private TextField descri;

	@FXML
	private TextField prix;

	@FXML
	private Button addpic;

	@FXML
	private TextField pathfile;

	@FXML
	private Button valide;

	public File image;

	@FXML
	void abonnement(ActionEvent event) {

	}

	@FXML
	private void addImage(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
        new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        image = fileChooser.showOpenDialog(null);
        if (image !=null)
        	pathfile.setText(image.getAbsolutePath());
	}

	@FXML
	void event(ActionEvent event) {

	}

	@FXML
	void panier(ActionEvent event) {

	}

	@FXML
	void planning(ActionEvent event) {

	}

	@FXML
	void produit(ActionEvent event) {

	}

	@FXML
	void reclamation(ActionEvent event) {

	}
	
	int idproduit;

	@FXML
	void precedant(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gui/GestionProduit.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}
//modif
	@FXML
	void submit(ActionEvent event) throws FileNotFoundException, ClassNotFoundException {
		String nomval = nom.getText().toString().toLowerCase();
		String typeval = type.getSelectionModel().getSelectedItem().toString();
		;
		String descrival = descri.getText().toString().toLowerCase();
		String prixval = prix.getText().toString().toLowerCase();
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Gestion Salle de sport");
		alert.setHeaderText("Ajout de activite");
		boolean verif = true;
		if (!BonPlanService.ControleNom(nomval)) {
			verif = false;
			alert.setContentText("Verifiez le nom du produit !");
			alert.showAndWait();
		}

		if (!BonPlanService.ControleNom(descrival)) {
			verif = false;
			alert.setContentText("Verifiez la description du produit !");
			alert.showAndWait();
		}
		if (!BonPlanService.ControleFloat(prixval)) {
			verif = false;
			alert.setContentText("Verifiez le prix du produit !");
			alert.showAndWait();
		}
		if (verif) {

			if (image == null) {
				Produit produit = new Produit(idproduit, nomval, typeval, descrival, Float.valueOf(prixval));
				BonPlanService.getInstance().modifierBonPlansansimage(produit);
				
			} else {
				FileInputStream imageinput = new FileInputStream(image);
				Produit produit = new Produit(idproduit,nomval, typeval, descrival, imageinput, Float.valueOf(prixval));
				BonPlanService.getInstance().modifierBonPlan(produit, (int) image.length());
			}
			
			Notifications notificationBuilder = Notifications.create().title("Produit modifié").graphic(null).hideAfter(javafx.util.Duration.seconds(5)).position(Pos.TOP_LEFT);
			notificationBuilder.show();

		}

	}

	@FXML
	void user(ActionEvent event) {

	}

	@FXML
	void initialize() {
		assert event != null : "fx:id=\"event\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert produit != null : "fx:id=\"produit\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert reclamation != null
				: "fx:id=\"reclamation\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert abonnement != null
				: "fx:id=\"abonnement\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert panier != null : "fx:id=\"panier\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert planning != null : "fx:id=\"planning\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert imagePath != null : "fx:id=\"imagePath\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert user != null : "fx:id=\"user\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert nom != null : "fx:id=\"nom\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert type != null : "fx:id=\"type\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert descri != null : "fx:id=\"descri\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert prix != null : "fx:id=\"prix\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert addpic != null : "fx:id=\"addpic\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert pathfile != null : "fx:id=\"pathfile\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert valide != null : "fx:id=\"valide\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert precedant != null : "fx:id=\"precedant\" was not injected: check your FXML file 'AjouterProduit.fxml'.";
		assert Imagevue != null : "fx:id=\"Imagevue\" was not injected: check your FXML file 'ModifierProduit.fxml'.";

		List<String> list = new ArrayList<String>();
		list.add("Alimentaire");
		list.add("Accessoires");
		ObservableList obList = FXCollections.observableList(list);
		type.getItems().clear();
		type.setItems(obList);
	}

	public void initdata(Produit produit2) throws FileNotFoundException, MalformedURLException, IOException {
		idproduit = produit2.getId_bp();
		type.setValue(produit2.getType_bp());
		nom.setText(produit2.getNom_bp());
		prix.setText(String.valueOf(produit2.getPrix_bp()));
		descri.setText(produit2.getDesc_bp());
		InputStream is = produit2.getImg_bp();
		OutputStream os = new FileOutputStream(new File("photo.jpg"));
		byte[] content = new byte[1024];
		int size = 0;
		while ((size = is.read(content)) != -1) {
			os.write(content, 0, size);
		}
		os.close();
		is.close();
		Image image = new Image("file:photo.jpg", Imagevue.getFitWidth(), Imagevue.getFitHeight(), true, true);
		Imagevue.setImage(image);
	}
}

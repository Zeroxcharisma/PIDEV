/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.base.JFXTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import connexionDatabase.MyDB;
import entite.BonPlan;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.ChoiceBoxTreeTableCell;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static jdk.nashorn.internal.objects.NativeString.search;
import service.BonPlanService;

/**
 * FXML Controller class
 *
 * @author Radhi
 */
public class ProduitMineController implements Initializable {

    private double xOffset = 0;
    private double yOffset = 0;
    
    private static int idBP;
    
    @FXML
    private AnchorPane pane1;
    @FXML
    private JFXButton btnX;
    @FXML
    private JFXButton btnAddPlan;
    @FXML
    private JFXButton btnShowPlans;
    @FXML
    private JFXButton btnMesPlans;
    @FXML
    private JFXTextField search;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger ham1;
    @FXML
    private JFXTreeTableView<BonPlan> treeview;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                pane1.setOnMousePressed((javafx.scene.input.MouseEvent event) -> {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                });

                pane1.setOnMouseDragged((javafx.scene.input.MouseEvent event) -> {
                    Stage stage = (Stage) pane1.getScene().getWindow();
                    stage.setX(event.getScreenX()-xOffset);
                    stage.setY(event.getScreenY()-yOffset);
                });
        afficher();
        
    }    

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) btnX.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void makeAddPlan(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ProduitAdd.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    private void makeShowPlans(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/bonPlan.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }

    @FXML
    private void makeMesPlans(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ProduitMine.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/Content/style.css").toExternalForm());
        stage.show();
    }  


       
        
    
   
    
    
    private void afficher()
    {
        
        
        JFXTreeTableColumn<BonPlan,Image> Image = new JFXTreeTableColumn<>("");
        Image.setPrefWidth(250);
        Image.setCellValueFactory((TreeTableColumn.CellDataFeatures<BonPlan, Image> param) ->  
                new SimpleObjectProperty(new Image(param.getValue().getValue().getImg_bp())));
        
        JFXTreeTableColumn<BonPlan,String> Nom = new JFXTreeTableColumn<>("Nom");
        Nom.setPrefWidth(150);
        Nom.setCellValueFactory((TreeTableColumn.CellDataFeatures<BonPlan, String> param) ->  
                new SimpleStringProperty(param.getValue().getValue().getNom_bp()));
        
        JFXTreeTableColumn<BonPlan,String> Type = new JFXTreeTableColumn<>("Type");
        Type.setPrefWidth(150);
        Type.setCellValueFactory((TreeTableColumn.CellDataFeatures<BonPlan, String> param) ->  
                new SimpleStringProperty(param.getValue().getValue().getType_bp()));
        
       
        
        
        
        
        
       
        //ObservableList<entite.BonPlan> bonPlans = FXCollections.observableArrayList();  
        int idu = LoginController.getIdCnx();
        BonPlan bp = new BonPlan();
        service.BonPlanService bps = new BonPlanService(bp);
        ObservableList<BonPlan> bonPlans = bps.selectBonPlansByID(idu);
        
        
              
       
        
        final TreeItem<BonPlan> root = new RecursiveTreeItem<>(bonPlans,RecursiveTreeObject::getChildren);
        
        
        Image.setCellFactory(column -> new JFXTreeTableCell<BonPlan, Image>(){ 
        private final ImageView imageView1 = new ImageView();             
        private final ImageView imageView2 = new ImageView();             
        private final Tooltip tooltip = new Tooltip(); 

        { 
            DropShadow dp = new DropShadow();
            imageView1.setFitHeight(150);
            imageView1.setFitWidth(230); 
            //imageView1.setPreserveRatio(true); 
            imageView1.setSmooth(true); 
            imageView1.setEffect(dp);
            tooltip.setText(null); 
            imageView2.setFitHeight(300);
            tooltip.setGraphic(imageView2); 
        } 

        @Override 
        protected void updateItem(Image item, boolean empty) { 
            super.updateItem(item, empty);  
            setGraphic(null); 
            setText(null); 
            setTooltip(null); 
            if (!empty && item != null) { 
                imageView1.setImage(item); 
                imageView2.setImage(item); 
                setGraphic(imageView1); 
                setTooltip(tooltip); 
            } 
        }             
    });
        
        treeview.setEditable(true);
        treeview.getSelectionModel().getSelectedItem();
        //System.out.println(ch1);
        Nom.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
        
        Nom.setOnEditCommit((TreeTableColumn.CellEditEvent<BonPlan, String> event) -> {
            TreeItem<BonPlan> currentEditingBonPlan = treeview.getTreeItem(event.getTreeTablePosition().getRow());
            currentEditingBonPlan.getValue().setNom_bp(event.getNewValue());
            
            BonPlan bp1 = currentEditingBonPlan.getValue();
            service.BonPlanService bps1 = new BonPlanService(bp1);
            bps1.modifierBonPlan(bp1, bp1.getId_bp());

        
        });
        
        ObservableList<String> listType = FXCollections.observableArrayList();
        listType.addAll("Complément Alimentaires","Accéssoires");
        Type.setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(listType));
        
        
        Type.setOnEditCommit((TreeTableColumn.CellEditEvent<BonPlan, String> event) -> {
            TreeItem<BonPlan> currentEditingBonPlan = treeview.getTreeItem(event.getTreeTablePosition().getRow());
            currentEditingBonPlan.getValue().setType_bp(event.getNewValue());
            
            BonPlan bp1 = currentEditingBonPlan.getValue();
            System.out.println(currentEditingBonPlan.toString());
            service.BonPlanService bps1 = new BonPlanService(bp1);
            bps1.modifierBonPlan(bp1, bp1.getId_bp());

        
        });
        
     
       
        /*    BonPlan bp1 = currentEditingBonPlan.getValue();
            service.BonPlanService bps1 = new BonPlanService(bp1);
            bps1.modifierBonPlan(bp1, bp1.getId_bp());*/

        
        
        
        
        treeview.getColumns().addAll(Image,Nom,Type);
        treeview.setRoot(root);
        treeview.setShowRoot(false);
               search.textProperty().addListener(new ChangeListener<String>(){
             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        treeview.setPredicate(new Predicate<TreeItem<BonPlan>>() {
                            @Override
                            public boolean test(TreeItem<BonPlan> t) {
                                 Boolean flag= (t.getValue().getNom_bp().contains(newValue)||
                                                t.getValue().getType_bp().contains(newValue)
                                                //|| t.getValue().getLieu_bp().contains(newValue)
                                                );
                                 
                                 return flag;
                            }
                        });
             }
            
        });
        
    }
    
    private void identifyUser() throws SQLException
    {
                int id = LoginController.getIdCnx();
                System.out.println("ID = "+id);
                MyDB myDB = MyDB.getInstance();
                Statement stm = myDB.getConnexion().createStatement();
                ResultSet rest=stm.executeQuery("select * from user where id = "+id+"");
                
                entite.User u = new entite.User();
                while(rest.next())
                {


                    u.setId(rest.getInt(1));
                    u.setUsername(rest.getString(2));
                    u.setEmail(rest.getString(4));
                    u.setPassword(rest.getString(8));
                    u.setNom(rest.getString(13));
                    u.setPrenom(rest.getString(14));
                    u.setTel(rest.getString(15));
                    u.setPhoto(rest.getString(16));
                    u.setType(rest.getString(17));



                }
                
                /*labelUser.setText("Bienvenue "+u.getUsername()+"!");
                Circle circle = new Circle(75, 70, 67);
                circle.setEffect(new DropShadow());
                imgUser.setImage(new Image(u.getPhoto()));
                imgUser.setClip(circle);*/
                
    }

    @FXML
    private void makeContextMenu(ContextMenuEvent event) {
        
        System.out.println(treeview.getSelectionModel().getSelectedItem().toString());
        final ContextMenu contextMenu = new ContextMenu();
        MenuItem supp = new MenuItem("supprimer");
        
       
        contextMenu.getItems().add(supp);
        treeview.setContextMenu(contextMenu);
        
        supp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) 
            {
                idBP=treeview.getSelectionModel().getSelectedItem().getValue().getId_bp(); 
                
                    BonPlan bpsup = new BonPlan();
                    BonPlanService bpSsup = new BonPlanService(bpsup);
                    bpSsup.supprimerBonPlan(idBP);
                    
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                    stage.initStyle(StageStyle.TRANSPARENT);

                    alert.setTitle("Suppression");
                    alert.setContentText("produit supprimé!");
                    alert.showAndWait();
                    afficher();
                    
                
            
            }
        });
        
    }
    
    
    
}

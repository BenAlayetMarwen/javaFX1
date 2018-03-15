/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import connexionDatabase.MyDB;
import entities.produit;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marwen b-al
 */
public class ListeprodController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private TableView<produit> tableproduit;
    @FXML
    private TableColumn<produit, Integer> id;
    @FXML
    private TableColumn<produit, String> categorie;
    @FXML
    private TableColumn<produit, String> libelle;
    @FXML
    private TableColumn<produit, String> description;
    @FXML
    private TableColumn<produit, Float> prix;
    @FXML
    private TableColumn<produit, Float> remise;
    @FXML
    private TableColumn<produit, Integer> quantiteDispo;
    @FXML
    private TableColumn<produit, Float> prixLivraison;
    @FXML
    private TableColumn<produit, String> marque;
    @FXML
    private TableColumn<produit, String> photo;
    @FXML
    private TableColumn<produit, Date> dateFabrication;

    static produit produit ;
    public ObservableList<produit>data=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       try {
           
            
            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
               ResultSet rest=stm.executeQuery("select * from produit where 1");
               produit = new produit();
               while(rest.next())
               {
                   
                   data.add(new produit(rest.getInt(1),rest.getString(2),rest.getString(3),rest.getString(4),rest.getFloat(5),rest.getFloat(6),rest.getInt(7),rest.getFloat(8),rest.getString(9),rest.getString(10),rest.getString(11)));
                   
               }
           

            
        } catch (SQLException ex) {
            Logger.getLogger(produit.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       id.setCellValueFactory(new PropertyValueFactory<>("id") );
       categorie.setCellValueFactory(new PropertyValueFactory<>("categorie") );
       libelle.setCellValueFactory(new PropertyValueFactory<>("libelle") );
       description.setCellValueFactory(new PropertyValueFactory<>("description") );
       prix.setCellValueFactory(new PropertyValueFactory<>("prix") );
       remise.setCellValueFactory(new PropertyValueFactory<>("remise") );
       quantiteDispo.setCellValueFactory(new PropertyValueFactory<>("quantiteDispo") );
       prixLivraison.setCellValueFactory(new PropertyValueFactory<>("prixLivraison") );
       marque.setCellValueFactory(new PropertyValueFactory<>("marque") );
       photo.setCellValueFactory(new PropertyValueFactory<>("photo") );
       dateFabrication.setCellValueFactory(new PropertyValueFactory<>("dateFabrication") );

        tableproduit.setItems(data);
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
             Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/espaceAdmin.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/espaceadmin.css").toExternalForm());
        stage.show();
    }


}

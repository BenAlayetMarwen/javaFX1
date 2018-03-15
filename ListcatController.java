/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import connexionDatabase.MyDB;
import entities.categorie;
import entities.produit;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marwen b-al
 */
public class ListcatController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private TableView<categorie> tablecategorie;
    @FXML
    private TableColumn<categorie, Integer> id;
    @FXML
    private TableColumn<categorie, String> libelle;
    @FXML
    private TableColumn<categorie, String> description;

      static categorie categorie ;
    public ObservableList<categorie>data=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 try {
           
            
            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
               ResultSet rest=stm.executeQuery("select * from categorie where 1");
               categorie = new categorie();
               while(rest.next())
               {
                   
                   data.add(new categorie(rest.getInt(1),rest.getString(2),rest.getString(3)));
                   
               }
           

            
        } catch (SQLException ex) {
            Logger.getLogger(produit.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       id.setCellValueFactory(new PropertyValueFactory<>("id") );
       libelle.setCellValueFactory(new PropertyValueFactory<>("libelle") );
       description.setCellValueFactory(new PropertyValueFactory<>("description") );


        tablecategorie.setItems(data);  
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marwen b-al
 */
public class EspaceAdminController implements Initializable {

    @FXML
    private ImageView image2;
    @FXML
    private ImageView image1;
    @FXML
    private Button listeprod;
    @FXML
    private Button ajouterprod;
    @FXML
    private Tab categorie;
    @FXML
    private Button listcat;
    @FXML
    private Button ajoutcat;
    @FXML
    private Button suppprod;
    @FXML
    private Button modifprod;
    @FXML
    private Button suppcat;
    @FXML
    private Button modifcat;
    
       @FXML
    private void listeprod(ActionEvent event) throws IOException {
      
        
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/listeprod.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/listeprod.css").toExternalForm());
        stage.show();
    }
           @FXML
    private void ajouterprod(ActionEvent event) throws IOException {
      
        
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ajouterprod.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/ajouterprod.css").toExternalForm());
        stage.show();
    }
           @FXML
    private void listcat(ActionEvent event) throws IOException {
      
        
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/listcat.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/listcat.css").toExternalForm());
        stage.show();
    }
           @FXML
    private void ajoutcat(ActionEvent event) throws IOException {
      
        
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ajoutcat.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/ajoutcat.css").toExternalForm());
        stage.show();
    }
           @FXML
    private void suppprod(ActionEvent event) throws IOException {
      
        
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/suppprod.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/suppprod.css").toExternalForm());
        stage.show();
    }
           @FXML
    private void modifprod(ActionEvent event) throws IOException {
      
        
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/modifprod.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/modifprod.css").toExternalForm());
        stage.show();
    }
           @FXML
    private void suppcat(ActionEvent event) throws IOException {
      
        
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/suppcat.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/suppcat.css").toExternalForm());
        stage.show();
    }
           @FXML
    private void modifcat(ActionEvent event) throws IOException {
      
        
        
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/modifcat.fxml"));
        Parent root = loader.load();
      
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        scene1.getStylesheets().addAll(this.getClass().getResource("/content/modifcat.css").toExternalForm());
        stage.show();
    }
         
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }    

 
    
}

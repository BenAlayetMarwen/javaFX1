/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author marwen b-al
 */
public class SuppprodController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private TextField idrecherche;
    @FXML
    private TextField categorie;
    @FXML
    private TextField libelle;
    @FXML
    private TextField description;
    @FXML
    private TextField prix;
    @FXML
    private TextField remise;
    @FXML
    private TextField quantitedispo;
    @FXML
    private TextField prixlivraison;
    @FXML
    private TextField marque;
    @FXML
    private TextField photo;
    @FXML
    private TextField datefabrication;
    @FXML
    private Button rechercher;
    @FXML
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void rechercher(ActionEvent event) throws SQLException {
        
          if(idrecherche.getText().length()==0)
        {
            idrecherche.setStyle("-fx-text-inner-color: red");
            idrecherche.setStyle("-fx-prompt-text-fill: red");
            idrecherche.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez Saisir un identifiant du produit !");
            alert.showAndWait();
            idrecherche.setCursor(Cursor.WAIT);
            
            
        }
        else {
         String idrechercheA = idrecherche.getText();
    int id = Integer.parseInt(idrechercheA);
    service.ProduitService bp = new ProduitService();
     produit pr= bp.rechercherparid(id);
     
     if (pr.getQuantiteDispo()!=0)
     {

      categorie.setText(pr.getCategorie());
      libelle.setText(pr.getLibelle());
      description.setText(pr.getDescription());
      prix.setText(String.valueOf(pr.getPrix()));
      remise.setText(String.valueOf(pr.getRemise()));
      quantitedispo.setText(String.valueOf(pr.getQuantiteDispo()));
      prixlivraison.setText(String.valueOf(pr.getPrixLivraison()));
      marque.setText(pr.getMarque());
      photo.setText(pr.getPhoto());
      datefabrication.setText(pr.getDateFabrication());
     }
     else 
     {
          idrecherche.setStyle("-fx-text-inner-color: red");
            idrecherche.setStyle("-fx-prompt-text-fill: red");
            idrecherche.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("identifiant non trouvé");
            alert.showAndWait();
            idrecherche.setCursor(Cursor.WAIT);
         
     }
    }}

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        
        String idrechercheA = idrecherche.getText();
               
               int id = Integer.parseInt(idrechercheA);
                 
            service.ProduitService bps = new ProduitService();
            bps.supprimerProduit( id);
            
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Succès");
            alert.setContentText("Produit supprimé avec succes!");
            alert.showAndWait();
            
            Stage stageS = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/suppprod.fxml"));
            Parent root = loader.load();
            

            Scene scene1 = new Scene(root);
            stageS.setScene(scene1);
            scene1.getStylesheets().addAll(this.getClass().getResource("/content/suppprod.css").toExternalForm());
            stageS.show();
    }
    
    
}

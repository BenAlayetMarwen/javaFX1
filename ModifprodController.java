/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Upload;
import entities.produit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.FileUploader;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author marwen b-al
 */
public class ModifprodController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private Button Modifierp;
    @FXML
    private Button Rechercher;
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
    private TextField idrecherche;
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
    private void modifier(ActionEvent event) throws IOException {
          
 
        
          String categorieA = categorie.getText();
        String libelleA = libelle.getText();
        String descriptionA = description.getText();
        String prixA = prix.getText();
        String remiseA = remise.getText();
        String quantiteDispoA = quantitedispo.getText();
        String prixLivraisonA = prixlivraison.getText();
        String marqueA = marque.getText();
        String photoA = photo.getText();
         String dateFabricationAA = datefabrication.getText();

  String idrechercheA = idrecherche.getText();
  int id = Integer.parseInt(idrechercheA);
  
  
        Float prixAA = Float.parseFloat(prixA);
        Float remiseAA = Float.parseFloat(remiseA);
        int quantiteDispoAA = Integer.parseInt(quantiteDispoA);
        Float prixLivraisonAA = Float.parseFloat(prixLivraisonA);

     
            produit prod = new produit();
            
            prod.setCategorie(categorieA);
            prod.setLibelle(libelleA);
            prod.setDescription(descriptionA);
            prod.setPrix(prixAA);
            prod.setRemise(remiseAA);
            prod.setQuantiteDispo(quantiteDispoAA);
            prod.setPrixLivraison(prixLivraisonAA);
            prod.setMarque(marqueA);
            prod.setPhoto(photoA);
            prod.setDateFabrication(dateFabricationAA);
            
            service.ProduitService bps = new ProduitService(prod);
            bps.modifierProduit(prod, id);
          
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Succès");
            alert.setContentText("Produit modifé avec succes!");
            alert.showAndWait();
            
            Stage stageS = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/modifprod.fxml"));
            Parent root = loader.load();
            

            Scene scene1 = new Scene(root);
            stageS.setScene(scene1);
            scene1.getStylesheets().addAll(this.getClass().getResource("/content/modifprod.css").toExternalForm());
            stageS.show();
        
        

    }

    @FXML
    private void rechercher(ActionEvent event) throws SQLException, IOException  {
    
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
            alert.setContentText("identifier non trouvé !");
            alert.showAndWait();
            idrecherche.setCursor(Cursor.WAIT);
    
}

        }
    }
    
    
    
}

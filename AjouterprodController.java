/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.sun.prism.impl.Disposer.Record;
import connexionDatabase.MyDB;
import entities.Upload;
import entities.produit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
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
public class AjouterprodController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private TextField catgorie;
    @FXML
    private TextField libelle;
    @FXML
    private TextField description;
    @FXML
    private TextField marque;
    @FXML
    private Button photo;
    @FXML
    private DatePicker dateFabrication;
    @FXML
    private TextField prix;
    @FXML
    private TextField remise;
    @FXML
    private TextField quantiteDispo;
    @FXML
    private TextField prixLivraison;
    @FXML
    private Button ajouter;
  private String fileName = "No picture";
    
    @FXML
    void upload(ActionEvent event) throws IOException {
        
          FileChooser fileChooser = new FileChooser();
                     FileChooser.ExtensionFilter exjpg = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
                     FileChooser.ExtensionFilter exjpg2 = new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg");
                     FileChooser.ExtensionFilter expng = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
                     fileChooser.getExtensionFilters().addAll(exjpg,exjpg2, expng);
                     fileChooser.setTitle("Choose an image File");

                     File file = fileChooser.showOpenDialog(null);
                     
                     
                             if (file != null) {
            if (file.length() < 6000000) {
                
                
                                
                               fileName= file.getName();
                               Upload u = new Upload();
                               u.upload(file);
                               
                               System.out.println(fileName);
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Permiss");
                alert.setHeaderText("Permission denied");
                alert.setContentText("Your Image file is too big to upload \nplease choose another image");
            }


            }

    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
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
    private void AjouterProduit(ActionEvent event) throws IOException {
         
        
        if(catgorie.getText().length()==0)
        {
            catgorie.setStyle("-fx-text-inner-color: red");
            catgorie.setStyle("-fx-prompt-text-fill: red");
            catgorie.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez Saisir une categorie du produit!");
            alert.showAndWait();
            catgorie.setCursor(Cursor.WAIT);
            
            
        }
        else if(libelle.getText().length()==0)
        {
            
            libelle.setStyle("-fx-text-inner-color: red");
            libelle.setStyle("-fx-prompt-text-fill: red");
            libelle.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir la libelle du produit !");
            alert.showAndWait();
            libelle.setCursor(Cursor.WAIT);
            
            
            
        }
        else if(description.getText().length()==0)
        {
            description.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir une description du produit !");
            alert.showAndWait();
            
            
        }
        else if(prix.getText().length()==0  )
        {
            prix.setStyle("-fx-text-inner-color: red");
            prix.setStyle("-fx-prompt-text-fill: red");
            prix.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir le prix du produit");
            prix.setCursor(Cursor.WAIT);
            
            
        }
        else if(remise.getText().length()==0)
        {
            remise.setStyle("-fx-inner-color: red");
            remise.setStyle("-fx-prompt-text-fill: red");
            remise.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir une remise");
            alert.showAndWait();
            remise.setCursor(Cursor.WAIT);
            
            
        }
        else if(quantiteDispo.getText().length()==0)
            
        {
            quantiteDispo.setStyle("-fx-inner-color: red");
            quantiteDispo.setStyle("-fx-prompt-text-fill: red");
            quantiteDispo.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir une quantite disponible");
            alert.showAndWait();
            quantiteDispo.setCursor(Cursor.WAIT);
            
            
        }
                        else if(prixLivraison.getText().length()==0)
        {
            prixLivraison.setStyle("-fx-inner-color: red");
            prixLivraison.setStyle("-fx-prompt-text-fill: red");
            prixLivraison.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir prix de livraison !");
            alert.showAndWait();
            prixLivraison.setCursor(Cursor.WAIT);
            
            
        }
                                else if(marque.getText().length()==0)
        {
            marque.setStyle("-fx-inner-color: red");
            marque.setStyle("-fx-prompt-text-fill: red");
            marque.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir marque");
            alert.showAndWait();
            marque.setCursor(Cursor.WAIT);
            
            
        }
                                        else if(photo.getText().length()==0)
        {
            photo.setStyle("-fx-inner-color: red");
            photo.setStyle("-fx-prompt-text-fill: red");
            photo.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir une photo");
            alert.showAndWait();
            photo.setCursor(Cursor.WAIT);
            
            
        }
     else if(dateFabrication.getValue()== null)
        {
            dateFabrication.setStyle("-fx-inner-color: red");
            dateFabrication.setStyle("-fx-prompt-text-fill: red");
            dateFabrication.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir une date de fabrication");
            alert.showAndWait();
            dateFabrication.setCursor(Cursor.WAIT);
            
            
        }
        else
        {
          
            
            
          /*  String posS = lieuBP.getText();
            posS=posS.replace("'", "_");
            Position pos = new Position(0,posS,pos_lat,pos_long);
            PositionService ps = new PositionService(pos);
            ps.ajouterPosition(pos);
            Position pos1 = ps.selectPosition(lieuBP.getText());


            String nomS = nomBP.getText();
            String descS = descBP.getText();
            String typeS = typeBP.getValue();
            descS=descS.replace("'", "_");
            nomS=nomS.replace("'", "_");
            String imgS = imageBP1.getText();
            int lieuS = pos1.getId_pos();
            double prixS = Double.parseDouble(prixBP.getText());

            imgS = FileUploader.upload(imgS);
            imgS = "http://localhost:8181/bonplan/images/"+imgS;*/
            
            
           LocalDate dateFabricationA = dateFabrication.getValue();

         //Date dateFabricationAA =  java.sql.Date.valueOf( dateFabricationA );

        String categorieA = catgorie.getText();
        String libelleA = libelle.getText();
        String descriptionA = description.getText();
        String prixA = prix.getText();
        String remiseA = remise.getText();
        String quantiteDispoA = quantiteDispo.getText();
        String prixLivraisonA = prixLivraison.getText();
        String marqueA = marque.getText();
        String photoA = photo.getText();
         String dateFabricationAA = dateFabricationA.toString();


        Float prixAA = Float.parseFloat(prixA);
        Float remiseAA = Float.parseFloat(remiseA);
        int quantiteDispoAA = Integer.parseInt(quantiteDispoA);
        Float prixLivraisonAA = Float.parseFloat(prixLivraisonA);
         photoA = FileUploader.upload(photoA);
         //   photoA = "http://localhost/images/"+photoA;
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
            bps.ajouterProduit(prod);
             
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Succès");
            alert.setContentText("Produit ajouté avec succes!");
            alert.showAndWait();
            
            Stage stageS = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ajouterprod.fxml"));
            Parent root = loader.load();
            

            Scene scene1 = new Scene(root);
            stageS.setScene(scene1);
            scene1.getStylesheets().addAll(this.getClass().getResource("/content/ajouterprod.css").toExternalForm());
            stageS.show();
        }
        

    }
    
  @FXML  
     void addImage(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
           
         Upload u = new Upload();
      u.upload(selectedFile);
           photo.setText(selectedFile.getAbsolutePath());
            
                  
        }
}}

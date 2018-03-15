/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.categorie;
import entities.produit;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.CategorieService;
import service.ProduitService;

/**
 * FXML Controller class
 *
 * @author marwen b-al
 */
public class AjoutcatController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private Button ajouterCategorie;
    @FXML
    private TextField libelle;
    @FXML
    private TextField description;

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
    private void ajouterCategorie(ActionEvent event)  throws IOException {
         
        
        if(libelle.getText().length()==0)
        {
            libelle.setStyle("-fx-text-inner-color: red");
            libelle.setStyle("-fx-prompt-text-fill: red");
            libelle.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            
            alert.setTitle("Attention");
            alert.setContentText("Veuillez Saisir une libelle du produit!");
            alert.showAndWait();
            libelle.setCursor(Cursor.WAIT);
            
            
        }
        else if(description.getText().length()==0)
        {
            
            description.setStyle("-fx-text-inner-color: red");
            description.setStyle("-fx-prompt-text-fill: red");
            description.setStyle("-fx-border-color: red");
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Attention");
            alert.setContentText("Veuillez saisir une description du produit !");
            alert.showAndWait();
            description.setCursor(Cursor.WAIT);
            
            
            
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
            


        String libelleA = libelle.getText();
        String descriptionA = description.getText();

       
            categorie cat = new categorie();
            
            cat.setLibelle(libelleA);
            cat.setDescription(descriptionA);

            
            service.CategorieService bps = new CategorieService(cat);
            bps.ajouterCategorie(cat);
             
            
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.initStyle(StageStyle.TRANSPARENT);
            alert.setTitle("Succès");
            alert.setContentText("Categorie ajouté avec succes!");
            alert.showAndWait();
            
            Stage stageS = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ajoutcat.fxml"));
            Parent root = loader.load();
            

            Scene scene1 = new Scene(root);
            stageS.setScene(scene1);
            scene1.getStylesheets().addAll(this.getClass().getResource("/content/ajoutcat.css").toExternalForm());
            stageS.show();
        }
        

    }
    
}

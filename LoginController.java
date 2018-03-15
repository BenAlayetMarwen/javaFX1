/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marwen b-al
 */
public class LoginController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    
   
      
      
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    
    {
        
     //  if ( username.getText().equals("marwen") && password.getText().equals("marwen") )
       //{
          login.setOnAction(event -> {

            try {
                
                   if ( username.getText().equals("marwen") && password.getText().equals("marwen") )
       {
                Parent page1 = FXMLLoader.load(getClass().getResource("/views/espaceAdmin.fxml"));
                Scene scene = new Scene(page1);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               
	stage.setScene(scene);
                stage.show();
            }
                   else if (username.getText().equals("user") && password.getText().equals("user"))
                   {
                        Parent page1 = FXMLLoader.load(getClass().getResource("/views/espaceUser.fxml"));
                Scene scene = new Scene(page1);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               
	       stage.setScene(scene);
                stage.show();
                   
                   
                   }
            else {
           Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("Mot De Passe ou UserName est Incorrecte !!!!!");
        alert.show();
       }
            
            
            }
            catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

 
           
                   
        
           
        
    
    }
  
}

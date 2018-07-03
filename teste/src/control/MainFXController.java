/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Gabriel
 */
public class MainFXController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnArmadura;
    private Label lblArmadura;
    @FXML
    private void trocaTela(ActionEvent ev){
      
       

        
        System.out.println("trocando de tela");
        
        Parent root;
        try {
            
            //modo 2
            Stage stage = Inicio.stage;
            
            root = FXMLLoader.load(getClass().getResource("Armadura.fxml"));
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            
        } catch (NullPointerException | IOException ex) {
            System.out.println("Senhor programador verifique o nome do arquivo FXML");ex.printStackTrace();
        }
        
        
        
       
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

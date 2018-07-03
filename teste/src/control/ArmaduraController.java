/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Armadura;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author Gabriel
 */
public class ArmaduraController implements Initializable {
    
    
    @FXML
    private TextField nome;
    @FXML
    private TextField forca;
    @FXML
    private TextField destreza;
    @FXML
    private TextField inteligencia;
    @FXML
    private TextField carisma;
    @FXML
    private TextField armaduraFis;
    @FXML
    private TextField armaduraMag;
    @FXML
    private TextArea descricao;
    @FXML
    private TableView <Armadura> tabela;
    @FXML
    private TableColumn <Armadura, Integer> tabelaId;
    @FXML
    private TableColumn <Armadura, String> tabelaNome;
    @FXML
    private TableColumn <Armadura, Integer> tabelaForca;
    @FXML
    private TableColumn <Armadura, Integer> tabelaDestreza;
    @FXML
    private TableColumn <Armadura, Integer> tabelaInteligencia;
    @FXML
    private TableColumn <Armadura, Integer> tabelaCarisma;
    @FXML
    private TableColumn <Armadura, String> tabelaDescricao;
   
    @FXML
    private void Salvar(ActionEvent ev){
        
        Armadura armadura = new Armadura();
        armadura.setNome(nome.getText());
        armadura.setDescricao(descricao.getText());
        armadura.setForca(Integer.parseInt(forca.getText()));
        armadura.setDestreza(Integer.parseInt(destreza.getText()));
        armadura.setInteligencia(Integer.parseInt(inteligencia.getText()));
        armadura.setCarisma(Integer.parseInt(carisma.getText()));
        armadura.setArmaduraFis(Integer.parseInt(armaduraFis.getText()));
        armadura.setArmaduraMag(Integer.parseInt(armaduraMag.getText()));
        armadura.salvaArmadura();
       
    }
   @FXML
    private void test(ActionEvent ev){
     Armadura armadura = new Armadura();
     armadura.testa();
    }
        
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Armadura armadura = new Armadura();
        
        tabelaId.setCellValueFactory(
                new PropertyValueFactory<>("idCarta"));
        tabelaNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        tabelaCarisma.setCellValueFactory(
                new PropertyValueFactory<>("carisma"));
        tabelaForca.setCellValueFactory(
                new PropertyValueFactory<>("forca"));
        tabelaDestreza.setCellValueFactory(
                new PropertyValueFactory<>("destreza"));
        tabelaInteligencia.setCellValueFactory(
                new PropertyValueFactory<>("inteligencia"));
        tabelaDescricao.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));
        
        tabela.setItems(armadura.listaDeArmadura());
    }
   
}

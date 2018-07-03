/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Gabriel
 */
public class Armadura extends Carta {
    
    protected int armaduraFis;
    protected int armaduraMag;

    public int getArmaduraFis() {
        return armaduraFis;
    }

    public void setArmaduraFis(int armaduraFis) {
        this.armaduraFis = armaduraFis;
    }

    public int getArmaduraMag() {
        return armaduraMag;
    }

    public void setArmaduraMag(int armaduraMag) {
        this.armaduraMag = armaduraMag;
    }
     public void salvaArmadura(){
        
        
        String selectSQL = "SELECT MAX(idcarta) FROM carta ";
        String insertTableSQL;
        PreparedStatement ps;
        
        insertTableSQL = "INSERT INTO carta"
                + "(idcarta, nome, forca, destreza, inteligencia, carisma, descricao) VALUES"
                + "(?,?,?,?,?,?,?)";
        Conexao c = new Conexao();
        Connection dbConnection = c.getConexao();
        PreparedStatement preparedStatement = null;
        
        try{
            ps = dbConnection.prepareStatement(selectSQL);
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt("MAX(idcarta)"));
                this.setIdCarta(rs.getInt("MAX(idcarta)")+1);
            }
            preparedStatement.setInt(1, idCarta);
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, forca);
            preparedStatement.setInt(4, destreza);
            preparedStatement.setInt(5, inteligencia);
            preparedStatement.setInt(6, carisma);
            preparedStatement.setString(7, descricao);
            
            //execute insert SQL statement
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        
         insertTableSQL = "INSERT INTO armadura"
                + "(idcarta, armadurafis, armaduramag) VALUES"
                + "(?,?,?)";
        try{
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, this.idCarta);
            preparedStatement.setInt(2, this.armaduraFis);
            preparedStatement.setInt(3, this.armaduraMag);
            
            //execute insert SQL statement
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        

   }
    
      public ObservableList<Armadura> listaDeArmadura() {
          String selectSQL = "SELECT * FROM armadura "
                +"inner join carta on carta.idcarta = armadura.idcarta ";
        ArrayList<Armadura> lista = new ArrayList<>();
        Conexao c = new Conexao();
        Connection dbConnection = c.getConexao();
        Statement st;
        try{
           st = dbConnection.createStatement();
           ResultSet rs = st.executeQuery(selectSQL);
            while (rs.next()){
                Armadura armor = new Armadura();
                armor.setIdCarta(rs.getInt("idcarta"));
                armor.setNome(rs.getString("nome"));
                armor.setForca(rs.getInt("forca"));
                armor.setDestreza(rs.getInt("destreza"));
                armor.setCarisma(rs.getInt("carisma"));
                armor.setInteligencia(rs.getInt("inteligencia"));
                armor.setDescricao(rs.getString("descricao"));
                armor.setArmaduraFis(rs.getInt("armadurafis"));
                armor.setArmaduraMag(rs.getInt("armaduramag"));
                
                lista.add(armor);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(
             lista
        );
      }
      
    public void testa(){
        String selectSQL = "SELECT MAX(idcarta) FROM carta ";
        Conexao c = new Conexao();
        Connection dbConnection = c.getConexao();
        PreparedStatement preparedStatement = null;
        
        
        PreparedStatement ps;
        
        try{
            ps = dbConnection.prepareStatement(selectSQL);
          
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println(rs.getInt("MAX(idcarta)"));
               
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }   
}



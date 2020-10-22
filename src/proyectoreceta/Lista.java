/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoreceta;
 import java.util.*;
import java.sql.*;
/**
 *
 * @author Beimar2
 */
public class Lista {
   



       public Lista(){
        
    }
    public void agregar(String nombre,int nivel){
        try {
            Connection conex;
            conex = Conexiones.getConexion();
            Statement sta = conex.createStatement();
            ResultSet rs = sta.executeQuery("INSERT INTO Recetas VALUES ('"+ nombre + "' ," + nivel +")" );
            
           
            }catch (SQLException ex){
                
        }
     }
    public boolean verificar (String nom){
        boolean encontrado= false;
        try{
            Connection conex = Conexiones.getConexion();
            Statement sta = conex.createStatement();
            ResultSet rs = sta.executeQuery("SELECT nombre FROM Recetas ");
            while(rs.next()){
                if(nom.equals(rs.getString("nombre"))){
                    encontrado= true;
                }
            }
        } catch(SQLException ex){
            }
        return encontrado;
    }
  
}



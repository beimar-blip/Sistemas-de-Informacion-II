/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoreceta;

/**
 *
 * @author Sergio Soliz
 */
import java.sql.*;
public class Conexiones {
        public static Connection getConexion(){
        String conexionUrl = "jdbc:sqlserver://sisinf.database.windows.net:1433;"
                                        + "database=sisinf2;"
                                        +"user = proyecto;"
                                        +"password = SistemasdeInformacion2;"
                                        +"loginTimeout = 30;";
        try {
            Connection connection = DriverManager.getConnection(conexionUrl);
            System.out.println ("Conectado con exito");
            return connection;
        }catch (SQLException ex){
            System.out.println(ex.toString());
            System.out.println ("Conectado sin exito");
            return null;
        }
    }
}

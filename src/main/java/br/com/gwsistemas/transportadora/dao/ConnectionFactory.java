
package br.com.gwsistemas.transportadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class ConnectionFactory {
    
    // Conectando o Driver, URL, URL e PASS
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://192.168.0.71:5432/transportadora?charSet=LATIN1";
    private static final String USER = "postgres";
    private static final String PASS = "postgres@2018@";
    
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER).newInstance();
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Erro: Erro ao conectar ao Banco ", ex);
        }
    
    }
    
    
    
  // Metodo estatico para terminar a conexão
    // Evitar sobrecarga no sistema. 
    public static void closeConnection(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
//    }



}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author tony-
 */
import java.sql.*;

public class ConexionMySQL {
    
    Connection conn;
    
    public Connection open() throws Exception 
    {
        // Definimos las credenciales de la conexion con la BD
        String usuario = "root";
        String contrasenia = "root";
        
        //Definimos la URL de la conexion con MySQL
        String url = "jdbc:mysql://localhost:3306/sitioNoticias";
       
        // Cargamos el Driver de MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Abrimos la conexion con la BD
        conn = DriverManager.getConnection(url, usuario, contrasenia);
    
        //Devovemos el objeto que gestiona la conexion con MySQL
        return conn;
    }
    
    public void close(){
        try
        {
            //Cerramos la conexion con la BD :
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import core.ConexionMySQL;
import model.Personal;
import model.Usuario;

/**
 *
 * @author tony-
 */
public class ControllerLogin {
    
public class ControllerComentario {
    
}
    public Usuario  login (String usuario , String password ) throws Exception {

        String query = "{call login('"+usuario+"', '"+password+"')}";

        ConexionMySQL objC =new ConexionMySQL();
        Connection con= objC.open();
        
        Statement stmt=con.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        
        Usuario u = new Usuario();
        while(rs.next()){
            u.setIdPersonal(rs.getInt("idpersonal"));
            u.setIdusuario(rs.getInt("idusuario"));
            u.setInt_ext(rs.getBoolean("int_ext"));
            u.setUsuario(rs.getString("usuario"));
        }
        rs.close();
        stmt.close();
        con.close();
        objC.close();
        return u;
    }
}

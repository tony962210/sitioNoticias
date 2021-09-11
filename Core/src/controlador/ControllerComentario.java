/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import core.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.comentario;

/**
 *
 * @author tony-
 */
public class ControllerComentario {
    public List<comentario> getComentarios(int id) throws Exception {

        String query = "{call consultarComentario("+id+")}";

        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        PreparedStatement pstmt = conn.prepareStatement(query);

        ResultSet rs = pstmt.executeQuery();

        List<comentario> comentarios = new ArrayList<>();

        while (rs.next() != false) {
            Usuario obj=new Usuario();
            obj.setUsuario(rs.getString("usuario"));
            
            comentario n = new comentario(rs.getInt("idcomentario"),
            obj,rs.getString("comentario"),rs.getString("fechahora"));
            comentarios.add(n);
        }

        rs.close();
        pstmt.close();
        connMySQL.close();
        return comentarios;
    }
        public void setComentarios(int idNota, int idUsuario, String comentario,int idComentario) throws Exception {

        String query = "{call insertComentario('"+comentario+"',"+idUsuario+","+idNota+","+idComentario+")}";

        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        PreparedStatement pstmt = conn.prepareStatement(query);

        ResultSet rs = pstmt.executeQuery();
        

        rs.close();
        pstmt.close();
        connMySQL.close();
 
    }

}

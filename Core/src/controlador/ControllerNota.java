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
import model.Nota;
import model.Personal;
import model.Usuario;


/**
 *
 * @author tony-
 */
public class ControllerNota {
    
    
//    public int insert(Nota n) throws Exception {
//        //1. Generar la llamada al prcedure
//        String query = "{call sitionoticias(?," + "?," + "?)}";
//        ConexionMySQL connMySQL = new ConexionMySQL();
//        Connection conn = connMySQL.open();
//
//        CallableStatement cstmt = conn.prepareCall(query);
//
//        cstmt.setInt(1, n.getPersonal().getIdpersonal());
//  
//        cstmt.setString(2, n.getNota());
//
//
//        cstmt.registerOutParameter(3, Types.INTEGER);
//
//
//        cstmt.execute();
//
//    
//        n.setIdnota(cstmt.getInt(3));
//
//        cstmt.close();
//        connMySQL.close();
//        return n.getIdnota();
//    }
    
    public List<Nota> getAll() throws Exception {
        ControllerComentario comentarios = new ControllerComentario();
        String query = "SELECT * FROM v_notas";

        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        PreparedStatement pstmt = conn.prepareStatement(query);

        ResultSet rs = pstmt.executeQuery();

        List<Nota> notas = new ArrayList<>();

        while (rs.next() != false) {
          
           Usuario u = new Usuario();
           
           u.setUsuario(rs.getString("usuario"));
//           u.setIdusuario(rs.getInt("idusuario"));
            
            Nota n = new Nota();
            n.setUsuario(u);
            n.setIdnota(rs.getInt("idnota"));
            n.setNota(rs.getString("nota"));
            n.setFechaHora(rs.getString("fechahora"));
            n.setComentarios(comentarios.getComentarios(rs.getInt("idnota")));
            System.out.println("Nota: "+rs.getString("nota"));
            notas.add(n);
        }

        rs.close();
        pstmt.close();
        connMySQL.close();
        return notas;
    }
    
     public void setNotas(int idNota, int idpersonal, String nota) throws Exception {

        String query = "{call insertnota('"+nota+"',"+idpersonal+","+idNota+")}";

        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();

        PreparedStatement pstmt = conn.prepareStatement(query);

        ResultSet rs = pstmt.executeQuery();
        

        rs.close();
        pstmt.close();
        connMySQL.close();
 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tony-
 */
public class Nota {
  private int idnota;
  private Usuario Usuario;
  private String nota;
  private String fechaHora;
  List<comentario> comentarios = new ArrayList<>();
  
    public Nota(){
        
    }

    public Nota(int idnota, Usuario Usuario, String nota, String fechaHora) {
        this.idnota = idnota;
        this.Usuario = Usuario;
        this.nota = nota;
        this.fechaHora = fechaHora;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }


    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public List<comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }
    
  
}

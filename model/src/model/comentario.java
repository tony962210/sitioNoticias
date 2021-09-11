/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tony-
 */
public class comentario {  
    
    private int idcomentario;
    private Usuario usuario;
    private String comentario;
    private String fechaHora;


    public comentario() {
    }
    
    
    

    public comentario(int idcomentario, Usuario usuario, String comentario, String fechaHora) {
        this.idcomentario = idcomentario;
        this.usuario = usuario;
        this.comentario = comentario;
        this.fechaHora = fechaHora;
    }

    public int getIdcomentario() {
        return idcomentario;
    }

    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    
    
}

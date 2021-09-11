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
public class Usuario {
    private int idusuario;
    private String usuario;
    private String contrasenia;
    private boolean int_ext;
    private int idPersonal;
    
    public Usuario(){
    }

    public Usuario(int idusuario, String usuario, String contrasenia, boolean int_ext, int idPersonal) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.int_ext = int_ext;
        this.idPersonal = idPersonal;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public boolean isInt_ext() {
        return int_ext;
    }

    public void setInt_ext(boolean int_ext) {
        this.int_ext = int_ext;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }


    
}

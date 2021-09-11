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
public class Personal {
    private int idpersonal;
    private String apepaterno;
    private String apematerno;
    private String nombre;
    private String direcion;
    private String fechaingreso;

    private Usuario usuario;
    
    public Personal(){
        
    }

    public Personal(int idpersonal, String apepaterno, String apematerno, String nombre, String direcion, String fechaingreso, Usuario usuario) {
        this.idpersonal = idpersonal;
        this.apepaterno = apepaterno;
        this.apematerno = apematerno;
        this.nombre = nombre;
        this.direcion = direcion;
        this.fechaingreso = fechaingreso;
        this.usuario = usuario;
    }

    public int getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getApepaterno() {
        return apepaterno;
    }

    public void setApepaterno(String apepaterno) {
        this.apepaterno = apepaterno;
    }

    public String getApematerno() {
        return apematerno;
    }

    public void setApematerno(String apematerno) {
        this.apematerno = apematerno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
    
    
}

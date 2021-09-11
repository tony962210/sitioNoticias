/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.djfc.mypet.rest;


import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import controlador.ControllerLogin;
import javax.ws.rs.GET;
import model.Usuario;


/**
 *
 * @author Federal
 */

@Path("log")
public class RESTLogin extends Application {
    
    @POST
    @Path("in")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response in(@FormParam("nombre")@DefaultValue("0")String usuario,
                       @FormParam("contrasenia")@DefaultValue("0")String password

                       ){
     
        Usuario c = new Usuario();
        String out="";
        ControllerLogin cml = new ControllerLogin();
        
        System.out.print("aver");
        try{
            c = cml.login(usuario,password);
       
            
            if(c.getIdusuario()!= 0){
                
                out = new Gson().toJson(c);
  
            }
            else {
             out=null;
            
            }
        }
        
        catch(Exception e){
            
            
            out="(\"exeption\": \""+e.toString()+"\")";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    
    }
    

     
}


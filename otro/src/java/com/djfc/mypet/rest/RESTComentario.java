/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.djfc.mypet.rest;

import controlador.ControllerComentario;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author tony-
 */

    @Path("comentarios")
public class RESTComentario {

    @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("idNota") @DefaultValue("0") int idNota,
            @FormParam("idUsuario") @DefaultValue("0") int idUsuario,
            @FormParam("idComentario") @DefaultValue("0") int idComentario,
            @FormParam("comentario") @DefaultValue("0") String comentario
            
     ) {
        


        String out = "";
        ControllerComentario cm = new ControllerComentario();

        try {
            if (idNota != 0) {
                cm.setComentarios( idNota, idUsuario,comentario,idComentario);
            } else {
             out = "{\"exception\":\" NO SE MANDO NADA \"}";
            }

        } catch (Exception e) {
            //e.printStackTrace();
            out = "{\"exception\":\" " + e.toString() + " \"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    }

    


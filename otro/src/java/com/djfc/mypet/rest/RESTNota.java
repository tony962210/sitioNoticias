package com.djfc.mypet.rest;


import com.google.gson.Gson;
import controlador.ControllerComentario;
import controlador.ControllerNota;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Nota;

@Path("notas")
public class RESTNota extends Application {
    
    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        ControllerNota obj = new ControllerNota();
        List<Nota> notas = new ArrayList<>();
        String out = "";
        

        try {
            notas = obj.getAll();
            
            if (notas!=null) {
                out = new Gson().toJson(notas);
            } else {
                out = "{\"exception\":\"No hay datos\"}";
            }
        } catch (Exception e) {
            out = "{\"exceptionr\":\"" + e.toString() + "\"}";
         
        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
     @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("idNota") @DefaultValue("0") int idNota,
            @FormParam("idpersonal") @DefaultValue("0") int idpersonal,
            @FormParam("nota") @DefaultValue("0") String nota
            
     ) {
        

        String out = "";
        ControllerNota cm = new ControllerNota();

        try {
            if (idNota != 0) {
                cm.setNotas( idNota, idpersonal,nota);
            } else {
             out = "{\"exception\":\" NO SE MANDO NADA \"}";
            }

        } catch (Exception e) {
            e.printStackTrace();
            out = "{\"exception\":\" " + e.toString() + " \"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
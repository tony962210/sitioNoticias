/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var notas = [];
function login()
{
    
    var nombre = $("#txtUsuario").val();
    var contrasenia = $("#txtPassword").val();

    var data= {nombre:nombre, contrasenia:contrasenia};
    $.ajax({
        type: "POST",
        url: "rest/log/in",
        data: data,
        async: true
    }).done(
            function (data)
            {
                // alert("valor: "+data.int_ext);
                if(data.int_ext==false){
                    
                    var Usuario = data;
                    
                    var usuario =Usuario.usuario;
          
       
                    var tipo="Externo";
                    localStorage.setItem("nombre",usuario);
                    localStorage.setItem("tipo",tipo);
                    localStorage.setItem("id",Usuario.idusuario);
                    
                     window.location.href = "News.html";
                    
                 //   alert("ES EXTERNO  ");
                    
    
                }
                else if(data.int_ext==true){
                    
                   var Usuario = data;
                    
                    var usuario =Usuario.usuario;
                  
       
                    var tipo="Interno";
                    
                    
                    localStorage.setItem("nombre",usuario);
                    localStorage.setItem("tipo",tipo);
                    localStorage.setItem("id",Usuario.idusuario);
                    localStorage.setItem("idPersonal",Usuario.idPersonal);
                    window.location.href = "News.html";
               

                }
                else{
                    
                    Swal.fire ({
                        
                        icon: "error",
                        title: "",
                        text: "Usuario y/o contraseña incorrecto(s)."
                    }
                   );
              
                }
            }
    );

}

function sesioncerrar(){
                     localStorage.setItem("nombre","");
                    localStorage.setItem("tipo","");
                    localStorage.setItem("id","");
                    localStorage.setItem("idPersonal","");
    
}

function validarUsuario(){
    var publica = "";
    var tipo = localStorage.getItem("tipo");

    if(tipo == "Interno" ){
          

  
     publica+= "<div class='promo'>";
                    publica+="<p>";
                    publica+="¿QUE HAY DE NUEVO?";
                    publica+="</p>";
                    publica+="<textarea name='comentarios' rows='5' cols='130' id='txtPublicacion'></textarea>";
                    publica+="<br>";
                    publica+="<div>";
                    publica+="<br>";
                    publica+="<button class='btn'  onclick='insertPublicacion();'>PUBLICAR </button>";
                    publica+="</div>";
                    publica+= "</div'>";
                    $("#interno").html(publica);
                    
                          conusltarPublicaciones();

    }
    
    else if (tipo == "Externo" ){
           conusltarPublicaciones();
     
    }
    
   else{   
       alert("INICIA SESIÓN");
      
        window.location.href = "index.html";

   }
}


   
function conusltarPublicaciones()
{
    var contenido = "";

    $.ajax({
        type: "GET",
        url: "rest/notas/getAll",
        async: true
    }).done(
            function (data)
            {
                if (data.exception != null)
                {
                    //En caso de que el servicio nos devuelva una exception esta se manda a imprimir en una alerta
                    Swal.fire("La consulta no se pudo procesar",
                            data.exception,
                            "error");
  

                } else if (data.length < 1)
                {
                       Swal.fire("La consulta no se pudo procesar",
                            data.exception,
                            "error");
            
                } else
                {
                    //Si se obtuvo información de la BD, esta se vacia en la 
                    ///variable global mercancias
                    notas = data;
                    
               
                    //Recorremos todo el JSON para ir generando la tabla
                    for (var i = 0; i < notas.length; i++)
                    {
                        contenido +="<section class='services'>";
                        contenido +="<div class='service service-1'>";
                        contenido +="<div class='content'>";
                        contenido +="<h2>Nota:</h2>";
                        contenido +="<p class='autor'>Por: "+notas[i].Usuario.usuario+"</p>";
                        contenido +="<h5>Dice:</h5>";
                        contenido +="<br>";
                        contenido +="<P>"+notas[i].nota+"</P>";
                        contenido +="<br>";
                        contenido +="<br>";
                        contenido +="Comentarios";
                        for(var j=0; j<notas[i].comentarios.length;j++){
                            contenido+="<div class='service service-1'>";
                            contenido+="<div class='content'>";
                            contenido+="<h4>"+notas[i].comentarios[j].usuario.usuario+"</h4>";
                            contenido+=notas[i].comentarios[j].comentario;
                            //delimitadores de cierre
                            contenido +="</div>";
                            contenido +="<p class='Publicado'>"+notas[i].comentarios[j].fechaHora+"</p>";
                            contenido +="</div>";
                            //delimitadores de cierre
                        }
                        contenido +="<div>";
                        contenido +="<textarea name='comentarios' rows='5' cols='170' id='txtComentarios"+notas[i].idnota+"'></textarea>";
                        contenido +="<br>";
                        contenido +="<br>";
                        contenido +="<button  class='btn btn-primary' type='button' onclick='insertComentario(" + i + ")' > COMENTAR</button>";// este flavo para lo de comentar
                        contenido +="</div>";
                        //delimitadores de cierre
                        contenido +="</div>";
                        contenido +="</div>";
                        contenido +="</section>";
                        //delimitadores de cierre
                    }
                    //se agregan los renglones generados a la tabla de mercancia
                    $("#news").html(contenido);
                }
            }
    );

}


function insertComentario(i)
{

    
    var comentario = document.getElementById("txtComentarios"+notas[i].idnota).value;
    var idUsuario = localStorage.getItem("id");
    var idNota = notas[i].idnota;
    var idComentario = 1;
    


    var data = {
        comentario: comentario,
        idUsuario: idUsuario,
        idNota: idNota,
        idComentario:idComentario
    };

    conusltarPublicaciones();
    $.ajax({
        type: "POST",
        url: "rest/comentarios/save",
        async: true,
        data: data
    }).done(function (data)
    {
 
        if (data.exception != null)
        {
            Swal.fire("La consulta no se pudo procesar",
                    data.exception,
                    "error");
        } else
        {
            Swal.fire("Accion realizada existosamente",
                    "Inserción",
                    "success");
        }
    }
    );

}

function insertPublicacion(i)
{
    var nota = document.getElementById("txtPublicacion").value;
    var idpersonal = localStorage.getItem("idPersonal");
    var idNota = 1;

    var data = {
        nota: nota,
        idpersonal: idpersonal,
        idNota: idNota
    };

    conusltarPublicaciones();
    
    $.ajax({
        type: "POST",
        url: "rest/notas/save",
        async: true,
        data: data
    }).done(function (data){
  
        
        if (data.exception != null)
        {
            alert("!null");
            Swal.fire("La consulta no se pudo procesar",
                    data.exception,
                    "error");
        } else
        {
             alert("null");
            Swal.fire("Accion realizada existosamente",
                    "Inserción",
                    "success");
        }
    }
    );
    alert("Nueva publicacion");
    conusltarPublicaciones();
}
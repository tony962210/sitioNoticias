/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Notas(){
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
                   alert("valor: "+data.int_ext);
                if(data.int_ext==false){
                    
                    var Usuario = data;
                    
                    var usuario =Usuario.usuario;
          
       
                    var tipo="Externo";
                    
                    
                    localStorage.setItem("nombre",usuario);
                    localStorage.setItem("tipo",tipo);
                    localStorage.setItem("id",Usuario.idusuario);
                    
                    //window.location.href = "inicioCliente.html";
                    
                    alert("ES EXTERNO  ");
                    
    
                }
                else if(data.int_ext==true){
                    
                   var Usuario = data;
                    
                    var usuario =Usuario.usuario;
                  
       
                    var tipo="Externo";
                    
                    
                    localStorage.setItem("nombre",usuario);
                    localStorage.setItem("tipo",tipo);
                    localStorage.setItem("id",Usuario.idusuario);
                    
                    //window.location.href = "inicioCliente.html";
                    
                    alert("ES INTERNO  ");

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


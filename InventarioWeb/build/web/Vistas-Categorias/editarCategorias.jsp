<%@page contentType="text/html" pageEncoding="UTF-8"%>
          <!--para importar los datos de la clase categoria-->
          <jsp:useBean id="categoria" scope="session" class="Model.Categoria"/>

          <!DOCTYPE html>
          <%
   
    String id_cat = request.getParameter("id");
    String nombre_cat = request.getParameter("nombre");
    String estado_cat = request.getParameter("estado");
    
    /*out.print("El ID de la categoria es: " + id_cat);
    out.print("El nombre de la categoria es: " + nombre_cat);
    out.print("El estado de la categoria es: " + estado_cat);*/
 %>
 <html>
          <head>
              <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8">
              <title>Modificacion de Categoria</title>
              <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf"%>
              <script type="text/javascript">
                  function regresar (url){ //funcion para el boton regresar
                    location.href=url;
                  }
              </script>
          </head>
          <body>

            <%@ include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>

            <h3>Mantenimiento Categorias</h3>
           <form action="actualizarCategoria" method="post">
        <div class="mb-3 row">
            <label for="staticEmail" class="col-sm-2 col-form-label">ID Categoria:</label>
            <div class="col-sm-10">
              <input type="text" value='<%= id_cat %>' name="id1" id="id1" readonly class="form-control-plaintext" id="staticEmail" placeholder="ID Categoria">
              <input type="hidden" value='<%= id_cat %>' name="id" id="id" readonly class="form-control-plaintext" id="staticEmail" >
            </div>
        </div>
            
        <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-2 col-form-label">Nombre Categoria:</label>
          <div class="col-sm-10">
              <input type="text" value='<%= nombre_cat %>' name="nombre" id="nombre" class="form-control" placeholder="Nombre Categoria" required="true">
          </div>
        </div>
          
          <div class="mb-3 row">
          <label for="inputPassword" class="col-sm-2 col-form-label">Estado Categoria:</label>
          <div class="col-sm-10">
              <input type="text" value='<%= estado_cat %>' name="estado" id="estado" class="form-control" placeholder="Estado Categoria" required="true">
          </div>
        </div>
          
          <div class="mb-3 row">
          <button type="submit" name="send" class="btn btn-success">Actualizar Categoria</button>
          </div>
        </form>
          
          <%
            String dato = request.getParameter("alerta");
            if(dato!=null){
                //out.print("Registro Actualizado Correctamente");
                //System.out.println("End");
           %>
                   <div class="alert alert-success" role="alert">
                   Registro Actualizado Correctamente!!
                 </div>
           <%   
               }
           %>
            
            <%@include file= "../WEB-INF/Vistas-Parciales/pie.jspf"%>

         </body>
    </html>
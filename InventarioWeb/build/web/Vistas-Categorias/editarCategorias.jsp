<%@page contentType="text/html" pageEncoding="UTF-8"%>
          <!--para importar los datos de la clase categoria-->
          <jsp:useBean id="categoria" scope="session" class="Model.Categoria"/>

          <!DOCTYPE html>
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
            <form class="form-horrizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath() %>/Categorias" method="post">
                <input type="hidden" name="id_categoria" value="<%=categoria.getId_categoria() %>">
                <div class="form-group">
                    <label for="txtNomCategoria" class="col-sm-2 control-label">Nombre:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtNomCategoria" value="<%= categoria.getNom_categoria() %>">
                 </div>
                </div>
                <div class="form-grup">
                    <label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtEstadoCategoria" value="<%= categoria.getEstado_categoria() %>">
                    </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                      <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar"/>
                      <input type="button" class="btn btn-danger btn-sm" onclick="regresar('<%=request.getContextPath()%>/Categorias?opcion=listar')" 
                             name="btnRegresar" value="Regresar"/>
                    </div>
                </div>
            </form>
            
            <%@include file= "../WEB-INF/Vistas-Parciales/pie.jspf"%>

         </body>
    </html>
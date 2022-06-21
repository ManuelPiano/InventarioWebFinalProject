<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import = "Model.Categoria" %> <!-- Importar el modelo -->
<!--El id debe ser el mismo que se le coloco de nombre à la sesión en el controlador -->
 <jsp:useBean id="lista" scope ="session" class = "java.util.List" />
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %> 
        <title>Control de inventario</title>
        
    </head>
    <body>
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        <h3>¡Bienvenid@!</h3>
        <div style="width: 600px;">

<a href="<%= request.getContextPath() %>/Categorias?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button">Nueva Categoria</a>
 <h3>Listado de Categorias Registradas</h3>

<table class="table table-striped">

<tr>

<th>
    ID
</th>
<th>
    NOMBRE
</th>
<th>
    ESTADO
</th>
<th>
    ACCION
</th>

</tr>

<%
for (int i=0; i < lista.size(); i++) {

Categoria categoria =new Categoria();
 categoria = (Categoria)lista.get(i); //(Categoria) es para el casting
%>
<tr>

<td><%= categoria.getId_categoria() %></td>

<td><%= categoria.getNom_categoria() %></td>

<td><%= categoria.getEstado_categoria () %></td>

<td>

<a href="<%= request.getContextPath() %>/Categorias?opcion=editar&&id=<%= categoria.getId_categoria() %>&&nombre=<%= categoria.getNom_categoria() %>&&estado=<%= categoria.getEstado_categoria() %>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button"> Editar</a>
 <a href="Categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %>&&nombre=<%= categoria.getNom_categoria() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>

</td> </tr>
<%
}
%>

</table>

</div>

        <%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

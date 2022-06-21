package Controller;
import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class actualizoCategoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet actualizoCategoria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet actualizoCategoria at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
         
         
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         //String estado = request.getParameter("opcion");
         String id_cat = request.getParameter("id");
         String nombre_cat = request.getParameter("nombre");
         String estado_cat = request.getParameter("estado");
         /*
         System.out.println("INFORMACIÓN RECIBIDA: ");
         System.out.println("ID Categoria: " + id_cat);
         System.out.println("Nombre Categoria: " + nombre_cat);
         System.out.println("Estado Categoria: " + estado_cat);
         */
         
         CategoriaDAO categoria = new CategoriaDAOImplementar();
         Categoria cat = new Categoria();
         cat.setId_categoria(Integer.parseInt(id_cat));
         cat.setNom_categoria(nombre_cat);
         cat.setEstado_categoria(Integer.parseInt(estado_cat));
         if(categoria.guardarCat(cat)){
             //System.out.println("Registro Actualizado.");
              RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/editarCategorias.jsp?aviso=ok");
              dispatcher.forward(request, response);
         }else{
             System.out.println("Error. El registro no se pudo actualizar.");
         }
         
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

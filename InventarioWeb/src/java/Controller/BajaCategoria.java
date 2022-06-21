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
import javax.servlet.http.HttpSession;

public class BajaCategoria extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        /*
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BajaCategoria</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BajaCategoria at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
         String respuesta = request.getParameter("respuesta");
         String id = request.getParameter("id");
         
         /*if(respuesta.equals("yes")){
              System.out.println("Respuesta: " + respuesta);
         }*/
         
         CategoriaDAO categoria = new CategoriaDAOImplementar();
         //Categoria cat = new Categoria();
         if(categoria.borrarCat(Integer.parseInt(id))){
             System.out.println("Registro eliminado correctamente.");
             this.listaCategorias(request, response);
         }else{
             System.out.println("Error. No se pudo eliminar el registro.");
         }
        
    }
    
    
    protected void listaCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         CategoriaDAO categoria = new CategoriaDAOImplementar();
         HttpSession sesion = request.getSession(true);
         sesion.setAttribute("lista", categoria.Listar());
         RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Categorias/listarCategorias.jsp");
         dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

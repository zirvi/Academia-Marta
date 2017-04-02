
package Servlets;

import dao.academia.profesor.DaoProfesor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MostrarServletProfesor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
         ResultSet rs=DaoProfesor.verProfesor();
         
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletProfesor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Mostrar lista profesores " + request.getContextPath() + "</h1>");
            
            while(rs.next()){
           out.println("<p> Id Profesor: "+rs.getString("idprofesor")+"</p>");
           out.println("<p> Nombre del Profesor: "+rs.getString("nombre_profesor")+"</p>");
           out.println("<p> Apellido del Profesor: "+rs.getString("apellido_profesor")+"</p>");
           out.println("<p> Dni del Profesor: "+rs.getString("dni_profesor")+"</p>");
            out.println("<p>--------------------</p>");

        }
        out.println("<a href=RegistroProfesor.html>Formulario Profesor</>");
        out.println("</body>");
        out.println("</html>");
        }
    }
        
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarServletProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarServletProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarServletProfesor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarServletProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

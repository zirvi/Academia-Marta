
package Servlets;

import dao.academia.alumno.DaoAlumno;
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

public class MostrarServletAlumno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        ResultSet rs=DaoAlumno.verAlumno();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAlumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Mostrar lista alumnos " + request.getContextPath() + "</h1>");
            
            while(rs.next()){
           out.println("<p> IdAlumno: "+rs.getString("idalumno")+"</p>");
           out.println("<p> Nombre del Alumno: "+rs.getString("nombre_alumno")+"</p>");
           out.println("<p> Apellido del Alumno: "+rs.getString("apellido_alumno")+"</p>");
           out.println("<p> Dni del Alumno: "+rs.getString("dni_alumno")+"</p>");
            out.println("<p>--------------------</p>");

        }
        out.println("<a href=RegistroAlumno.html>Formulario Alumno</>");
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
            Logger.getLogger(MostrarServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MostrarServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MostrarServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

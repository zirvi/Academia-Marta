
package Servlets;

import bo.academia.alumno.BoAlumno;
import bo.academia.profesor.BoProfesor;
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
import javax.servlet.http.HttpSession;

public class InsertarServletAlumno extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        
            
                //recupera el action del formulario (updateProfesor.html)
                String action=request.getParameter("action");
                
                if(action.contains("update")){
                    
                BoAlumno.procesarUpdateAlumno(request, response);
                }else{
                    BoAlumno.procesarInsertarPeticionAlumno(request, response);
                }
                
            
              
           
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertarServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertarServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertarServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertarServletAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}


package bo.academia.profesor;

import dao.academia.profesor.DaoProfesor;
import entidades.profesor;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilidades.ConectarAcademia;


public class BoProfesor {
    
    public static void procesarInsertarPeticionProfesor(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException{
   
    profesor teacher=new profesor();
    teacher.setIdprofesor(request.getParameter("idprofesor"));
    teacher.setNombre_profesor(request.getParameter("nombre_profesor"));
    teacher.setApellido_profesor(request.getParameter ("apellido_profesor"));
    teacher.setDni_profesor(request.getParameter("dni_profesor"));
    DaoProfesor.insertarProfesor(teacher.getIdprofesor(),teacher.getNombre_profesor(), teacher.getApellido_profesor(),teacher.getDni_profesor());
    response.sendRedirect("/Academia/MostrarServletProfesor");
}
    
    public static void procesarUpdatePeticionProfesor(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
    
        profesor teacher=new profesor();
       
        teacher.setNombre_profesor(request.getParameter("nombre_profesor"));
        teacher.setApellido_profesor(request.getParameter ("apellido_profesor"));
         teacher.setApellido_profesor(request.getParameter ("dni_profesor"));
          teacher.setIdprofesor(request.getParameter("idprofesor"));
        DaoProfesor.actualizarProfesor(teacher.getNombre_profesor(),teacher.getApellido_profesor(),teacher.getDni_profesor(),teacher.getIdprofesor());
        response.sendRedirect("/Academia/MostrarServletProfesor");
    }
    
    public static void procesarBajaPeticionProfesor(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
        profesor teacher=new profesor();
         teacher.setIdprofesor(request.getParameter("idprofesor"));
         DaoProfesor.borrarProfesor(teacher.getIdprofesor());
        
        response.sendRedirect("/Academia/MostrarServletProfesor");   
    }
}

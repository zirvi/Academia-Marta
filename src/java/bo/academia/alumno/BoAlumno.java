
package bo.academia.alumno;

import bo.academia.profesor.*;
import dao.academia.alumno.DaoAlumno;
import dao.academia.profesor.DaoProfesor;
import entidades.alumno;
import entidades.profesor;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilidades.ConectarAcademia;


public class BoAlumno {
    
    public static void procesarInsertarPeticionAlumno(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException{
   
    alumno alum=new alumno();
    alum.setIdalumno(request.getParameter("idalumno"));
    alum.setNombre_alumno(request.getParameter("nombre_alumno"));
    alum.setApellido_alumno(request.getParameter ("apellido_alumno"));
    alum.setDni_alumno(request.getParameter("dni_alumno"));
    DaoAlumno.insertarAlumno(alum.getIdalumno(),alum.getNombre_alumno(), alum.getApellido_alumno(),alum.getDni_alumno());
    response.sendRedirect("/Academia/mostrarServletAlumno");
}
    
    public static void procesarUpdateAlumno(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
    
        alumno alum=new alumno();
        alum.setIdalumno(request.getParameter("idalumno"));
        alum.setNombre_alumno(request.getParameter("nombre_alumno"));
        alum.setApellido_alumno(request.getParameter ("apellido_alumno"));
        alum.setDni_alumno(request.getParameter("dni_alumno"));
        DaoAlumno.actualizarAlumno(alum.getIdalumno(),alum.getNombre_alumno(), alum.getApellido_alumno(),alum.getDni_alumno() );
        response.sendRedirect("/Academia/mostrarServletAlumno");
    }
    
    public static void procesarBajaAlumno(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
        alumno alum=new alumno();
        alum.setIdalumno(request.getParameter("idalumno"));
        alum.setNombre_alumno(request.getParameter("nombre_alumno"));
        alum.setApellido_alumno(request.getParameter("apellido_alumno"));
        alum.setDni_alumno(request.getParameter("dni_alumno"));
        DaoAlumno.BorrarAlumno(alum.getIdalumno(), alum.getNombre_alumno(), alum.getApellido_alumno(), alum.getDni_alumno());
        response.sendRedirect("mostrarServletAlumno");
}
}

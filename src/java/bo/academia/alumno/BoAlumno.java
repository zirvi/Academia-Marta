
package bo.academia.alumno;


import dao.academia.alumno.DaoAlumno;

import entidades.alumno;

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
    response.sendRedirect("/Academia/MostrarServletAlumno");
}
    
    public static void procesarUpdatePeticionAlumno(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException{
   
    alumno alum=new alumno();
    
    alum.setNombre_alumno(request.getParameter("nombre_alumno"));
    alum.setApellido_alumno(request.getParameter ("apellido_alumno"));
    alum.setDni_alumno(request.getParameter("dni_alumno"));
    alum.setIdalumno(request.getParameter("idalumno"));
    DaoAlumno.actualizarAlumno(alum.getNombre_alumno(), alum.getApellido_alumno(),alum.getDni_alumno(),alum.getIdalumno());
    response.sendRedirect("/Academia/MostrarServletAlumno");
}
    
    public static void procesarBajaPeticionAlumno(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException{
        
        alumno alum=new alumno();
        alum.setIdalumno(request.getParameter("idalumno"));
        
        DaoAlumno.borrarAlumno(alum.getIdalumno());
        
        
        
        response.sendRedirect("/Academia/MostrarServletAlumno");
}
}

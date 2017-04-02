
package dao.academia.alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.ConectarAcademia;


public class DaoAlumno {
    
    public static void insertarAlumno(String idalumno,String nombre_alumno,String apellido_alumno, String dni_alumno) throws SQLException, ClassNotFoundException{
            
        Connection conexion=ConectarAcademia.ConectarAcademia();
        Statement sentencia=conexion.createStatement();
        String consultaSQL = "insert into alumno (idalumno,nombre_alumno,apellido_alumno, dni_alumno) values ";
        consultaSQL += "('" + idalumno + "','" + nombre_alumno + "','" + apellido_alumno + "', '" + dni_alumno + "')";
        int filas=sentencia.executeUpdate(consultaSQL);
        System.out.println("Numero de filas insertadas:"+filas);
        sentencia.close();
        ConectarAcademia.cerrarConexion();
    
    
}
    
    public static void actualizarAlumno(String nombre_alumno, String apellido_alumno, String dni_alumno,String idalumno) throws ClassNotFoundException, SQLException{
        
        Connection conexion=ConectarAcademia.ConectarAcademia();
        String consultaSQL="update alumno set nombre_alumno=?,apellido_alumno=?,dni_alumno=? where idalumno=?";
        PreparedStatement actualizar=conexion.prepareStatement(consultaSQL);
       
        actualizar.setString(1,nombre_alumno);
        actualizar.setString(2,apellido_alumno);
        actualizar.setString(3,dni_alumno);
         actualizar.setString(4,idalumno);
        int filas=actualizar.executeUpdate();
        //System.out.println("Numero de filas insertadas:"+filas);
       
        actualizar.close();
        //conexion.close();
       ConectarAcademia.cerrarConexion();
}
    
    public static ResultSet verAlumno() throws ClassNotFoundException, SQLException{
    
      Connection conexion=ConectarAcademia.ConectarAcademia();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "select idalumno,nombre_alumno,apellido_alumno,dni_alumno from alumno";
      ResultSet lista_alumno=sentencia.executeQuery(consultaSQL);
      return lista_alumno;
    
    
}
    
     public static void borrarAlumno(String idalumno) throws SQLException, ClassNotFoundException{
            
       Connection conexion=ConectarAcademia.ConectarAcademia();
   
    
    String consultaSQL= "delete from alumno where idalumno=?";
    PreparedStatement borrar =conexion.prepareStatement(consultaSQL);
    
    
    borrar.setString(1,idalumno);
    
    int filasAfectadas=borrar.executeUpdate();//executeUpdate devuelve el numero de filas afectadas
     System.out.println("\n");
     System.out.println("Filas afectadas: "+filasAfectadas);
     borrar.close();
       
     ConectarAcademia.cerrarConexion();
     }
}
     
 
    


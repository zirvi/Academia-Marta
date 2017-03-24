
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
    
    public static void actualizarAlumno(String nombre_alumno, String apellido_alumno, String idalumno) throws ClassNotFoundException, SQLException{
        
        Connection conexion=ConectarAcademia.ConectarAcademia();
        String sql="update alumno set nombre_alumno=? and apellido_alumno=? where idalumno=?";
        PreparedStatement sentencia=conexion.prepareStatement(sql);
        sentencia.setString(1, nombre_alumno);
        sentencia.setString(2, apellido_alumno);
        sentencia.setString(3, idalumno);
        int filas=sentencia.executeUpdate(sql);
        System.out.println("Numero de filas insertadas:"+filas);
        sentencia.close();
        conexion.close();
    
}
    
    public static ResultSet verAlumno() throws ClassNotFoundException, SQLException{
    
      Connection conexion=ConectarAcademia.ConectarAcademia();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "select idalumno,nombre_alumno,apellido_alumno, dni_alumno from alumno";
      ResultSet lista_alumno=sentencia.executeQuery(consultaSQL);
      return lista_alumno;
    
    
}
    
    public static void BorrarAlumno(String nombre_alumno, String apellido_alumno, String idalumno) throws ClassNotFoundException, SQLException{
      Connection conexion=ConectarAcademia.ConectarAcademia();
      Statement sentencia = conexion.createStatement();
      String consultaSQL="delete from alumno where idalumno=? ";
      PreparedStatement borrar=conexion.prepareStatement(consultaSQL);
      borrar.setString(1, nombre_alumno);
      borrar.setString(2, apellido_alumno);
      borrar.setString(3, idalumno);
      int filas=sentencia.executeUpdate(consultaSQL);
      System.out.println("Numero de filas insertadas:"+filas);
      sentencia.close();
    }
    
}

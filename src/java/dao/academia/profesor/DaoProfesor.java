
package dao.academia.profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import utilidades.ConectarAcademia;



public class DaoProfesor {
    
    public static void insertarProfesor(String idprofesor,String nombre_profesor,String apellido_profesor, String dni_profesor) throws SQLException, ClassNotFoundException{
            
        Connection conexion=ConectarAcademia.ConectarAcademia();
        Statement sentencia=conexion.createStatement();
        String consultaSQL = "insert into profesor (idprofesor,nombre_profesor,apellido_profesor, dni_profesor) values ";
        consultaSQL += "('" + idprofesor + "','" + nombre_profesor + "','" + apellido_profesor + "', '" + dni_profesor + "')";
        int filas=sentencia.executeUpdate(consultaSQL);
        System.out.println("Numero de filas insertadas:"+filas);
        sentencia.close();
        ConectarAcademia.cerrarConexion();
    
    
}
    
    public static void actualizarProfesor(String nombre_profesor, String apellido_profesor, String idprofesor) throws ClassNotFoundException, SQLException{
        
        Connection conexion=ConectarAcademia.ConectarAcademia();
        String sql="update profesor set nombre_profesor=? , apellido_profesor=? where idprofesor=?";
        PreparedStatement sentencia=conexion.prepareStatement(sql);
        sentencia.setString(1, nombre_profesor);
        sentencia.setString(2, apellido_profesor);
        sentencia.setString(3, idprofesor);
        int filas=sentencia.executeUpdate(sql);
        System.out.println("Numero de filas insertadas:"+filas);
        sentencia.close();
        conexion.close();
    
}
    
    public static ResultSet verProfesor() throws ClassNotFoundException, SQLException{
    
      Connection conexion=ConectarAcademia.ConectarAcademia();
      Statement sentencia = conexion.createStatement();
      String consultaSQL = "select idprofesor,nombre_profesor,apellido_profesor,dni_profesor from profesor";
      ResultSet lista_profesor=sentencia.executeQuery(consultaSQL);
      return lista_profesor;
    
    
}
    
    public static void BorrarProfesor(String idprofesor) throws ClassNotFoundException, SQLException{
      Connection conexion=ConectarAcademia.ConectarAcademia();
      //Statement sentencia = conexion.createStatement();
      String consultaSQL="delete from profesor where idprofesor=? ";
      PreparedStatement borrar=conexion.prepareStatement(consultaSQL);
      borrar.setString(1, idprofesor);
      int filas=borrar.executeUpdate(consultaSQL);
      System.out.println("Numero de filas insertadas:"+filas);
      conexion.close();
    }
}

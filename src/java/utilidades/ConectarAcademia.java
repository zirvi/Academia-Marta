
package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarAcademia {
    
    private static Connection conexion;


public static Connection ConectarAcademia() throws ClassNotFoundException, SQLException{
    
    String ruta="com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/restaurante";
                String user = "root";
                String password = "root";
    
    Class.forName(ruta);
    conexion=DriverManager.getConnection(url,user,password);
    
    if(conexion !=null){
        
        System.out.println("Conexion realizada");
    } else{
        
        System.out.println("No hay conexion");
    }
    return conexion;
}

 public static void cerrarConexion() throws ClassNotFoundException, SQLException{
     if(conexion!=null){
     conexion.close();
     System.out.println("Bye Bye");
     }
else{
    System.out.println("Se ha producido un error");
}
} 
} 
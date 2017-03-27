
package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class VerificarLogin {
    
    //esto es un metodo que devuelve un login que necesita dos parametros y esto viene de un formulario
    public static boolean comprobarLogin(String usuario, String password) throws ClassNotFoundException, SQLException{
    
        boolean nRegistro=false; 
        String sql="select * from logeados where usuario='"+usuario+"' AND password='"+password+"'";
        Connection conexion=ConectarAcademia.ConectarAcademia();
        
        //PreparedStatement - esto es para preparar la sentencia sql que hemos preparado arriba. Aqui cargamos la sentencia 
        PreparedStatement comprobarLogin=conexion.prepareStatement(sql);
        ResultSet rs=comprobarLogin.executeQuery(sql);// ejecutamos la sentencia con executeQuery que devuleve un conjunto de filas afectadas
        if(rs.next()){
            //si devuelve resultados el login es correcto
            nRegistro=true;
        }
        
     return nRegistro; 
        

        
        
        
        
        
    }
    
}

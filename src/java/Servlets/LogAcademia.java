
package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilidades.VerificarLogin;


public class LogAcademia extends HttpServlet {
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ClassNotFoundException, SQLException {
   
    //solicito los parametros de login.html
    //pido la clave (usuario) y me devuelve el valor (userLogin)
    String userLogin= request.getParameter("usuario");
    String passLogin= request.getParameter("password");
    
    boolean verificarUsuario=VerificarLogin.comprobarLogin(userLogin, passLogin);
    
    
        if(verificarUsuario==true){//== es para comparar
    //comprobar los valores de los parametros que recibo del formulario
    //si el usuario esta logeado en otros servelts
        boolean log=true; 
        HttpSession sesionLogin=request.getSession();
        //guardo en la sesion 
        sesionLogin.setAttribute("usuario", userLogin);
        sesionLogin.setAttribute("password", passLogin);
        sesionLogin.setAttribute("ok", log);
        
        response.sendRedirect("/Academia/altas.htm");
        } else{
        response.sendRedirect("/Academia/Principal.html"); 
    }
    
    
    
    /*        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogRestaurante</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogRestaurante at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(LogAcademia.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(LogAcademia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(LogAcademia.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(LogAcademia.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

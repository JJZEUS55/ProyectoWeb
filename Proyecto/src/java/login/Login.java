/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.Map;  
import BD.BaseDatos;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.dispatcher.SessionMap;  


/**
 *
 * @author ZOLUN
 */
public class Login extends ActionSupport implements SessionAware{
    private String username;
    private String password;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    private String lista;
    private SessionMap<String,Object> sessionMap;  

    @Override  
    public void setSession(Map<String, Object> map) {  
    sessionMap=(SessionMap)map;  
} 
    
    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public Login() {
    }
    
    public String Logout()
    {
        System.out.println("Cerrarrr");
        if (sessionMap.containsKey("username")) {
            sessionMap.remove("username");
        }
        mensaje="Sesion Finalizada";
        return "1";
    }
    
    public String Login() 
    {
        
        BaseDatos var = new BaseDatos();
        if(var.iniciarSesion(username, password))
        {
            sessionMap.put("username", username);
            switch(var.getTipoUsuario(username))
            {
                case 1: return "1"; // alumno
                case 2: return "2"; // profesor
                case 3: return "3"; // administrador
                default: return "4";
            }
        }
        mensaje="Error usario o password incorrectos";
        return "4"; //error
    }
    

}

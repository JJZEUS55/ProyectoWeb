/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import BD.BaseDatos;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author ZOLUN
 */
public class Login extends ActionSupport {
    private String username;
    private String password;

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
    
    public String execute() 
    {
        
        BaseDatos var = new BaseDatos();
        if(var.iniciarSesion(username, password))
        {
            switch(var.getTipoUsuario(username))
            {
                case 1: return "1"; // alumno
                case 2: return "2"; // profesor
                case 3: return "3"; // administrador
                default: return "4";
            }
        }
        return "4"; //error
    }
    
}

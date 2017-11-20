/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;
import BD.BaseDatos;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;

/**
 *
 * @author ZOLUN
 */
public class AdminAddUser extends ActionSupport {
    private String usernameN;
    private String passwordN;
    private String tipoN;
    private String nombreN;
    private String apellidoPN;
    private String apellidoMN;
    private String mensaje;
    private List lista;

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    

    public String getUsernameN() {
        return usernameN;
    }

    public void setUsernameN(String usernameN) {
        this.usernameN = usernameN;
    }

    public String getPasswordN() {
        return passwordN;
    }

    public void setPasswordN(String passwordN) {
        this.passwordN = passwordN;
    }

    public String getTipoN() {
        return tipoN;
    }

    public void setTipoN(String tipoN) {
        this.tipoN = tipoN;
    }

    public String getNombreN() {
        return nombreN;
    }

    public void setNombreN(String nombreN) {
        this.nombreN = nombreN;
    }

    public String getApellidoPN() {
        return apellidoPN;
    }

    public void setApellidoPN(String apellidoPN) {
        this.apellidoPN = apellidoPN;
    }

    public String getApellidoMN() {
        return apellidoMN;
    }

    public void setApellidoMN(String apellidoMN) {
        this.apellidoMN = apellidoMN;
    }
          
    
    public AdminAddUser() {
    }
    
    public String agregarUsuarios() 
    {
        BaseDatos BD = new BaseDatos();
        int tem = 1;
        if(tipoN.equals("Alumno"))
            tem = 1;
        if(tipoN.equals("Profesor"))
            tem = 2;
        if(tipoN.equals("Administrador"))
            tem = 3;
//        switch(tipoN)
//        {
//            case "Alumno": tem = 1;
//            case "Profesor": tem = 2;
//            case "Administrador": tem = 3;
//            default: tem = 1;
//        }

        if(usernameN.isEmpty() || passwordN.isEmpty() || tipoN.isEmpty() || nombreN.isEmpty() || apellidoPN.isEmpty() || apellidoMN.isEmpty())
        {
            mensaje = "Ningun campo debe estar vacio";
            lista = BD.TodosTablaX("Usuarios");
            return "1";
        }
        if(BD.agregarUsuario(usernameN, passwordN, tem, nombreN, apellidoPN, apellidoMN)){
            mensaje = "Nuevo agregado";
        }
        else{
            mensaje = "Error";
        }
        lista = BD.TodosTablaX("Usuarios");
        return "1";
    }
    
}

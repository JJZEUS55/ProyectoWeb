/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;
import BD.BaseDatos;
import com.opensymphony.xwork2.ActionSupport;
import entity.Grupo;
import java.util.List;
import java.util.Set;

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
    private String grupoN;

    public String getGrupoN() {
        return grupoN;
    }

    public void setGrupoN(String grupoN) {
        this.grupoN = grupoN;
    }

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
        List Grupos = BD.TodosTablaX("Grupo");
        Grupo temporal = new Grupo();
        if(tipoN.equals("Alumno"))
            tem = 1;
        if(tipoN.equals("Profesor"))
            tem = 2;
        if(tipoN.equals("Administrador"))
            tem = 3;

        if(usernameN.isEmpty() || passwordN.isEmpty() || tipoN.isEmpty() || nombreN.isEmpty() || apellidoPN.isEmpty() || apellidoMN.isEmpty())
        {
            mensaje = "Ningun campo debe estar vacio";
            lista = BD.TodosTablaX("Usuarios");
            return "1";
        }
        else if(tem == 3)
        {
            if(!BD.agregarUsuario(usernameN, passwordN, tem, nombreN, apellidoPN, apellidoMN, "grupo")){
                mensaje = "Error";}
        }
        else if(BD.SolicitarGrupo(grupoN) == null)
        {
            mensaje = "El grupo ingresado no existe -- se agrego a grupo";
            if(!BD.agregarUsuario(usernameN, passwordN, tem, nombreN, apellidoPN, apellidoMN, "grupo"))
            {
                mensaje = "Error";
            }
            lista = BD.TodosTablaX("Usuarios");
            return "1";
        }
        else if(tem == 2 && BD.checkGrupo(grupoN) == true)
        {
           
            mensaje = "El grupo ya tiene profesor-- se agrego a grupo";
            if(!BD.agregarUsuario(usernameN, passwordN, tem, nombreN, apellidoPN, apellidoMN, "grupo"))
            {
                mensaje = "Error";
            }
            lista = BD.TodosTablaX("Usuarios");
            return "1";
        }
        else if(BD.agregarUsuario(usernameN, passwordN, tem, nombreN, apellidoPN, apellidoMN, grupoN)){
            mensaje = "Nuevo nuevo usuario agregado";
        }
        else{
            mensaje = "Error";
        }
        lista = BD.TodosTablaX("Usuarios");
        return "1";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno.action;

import BD.BaseDatos;
import com.opensymphony.xwork2.ActionSupport;
import entity.Usuarios;

/**
 *
 * @author usuario
 */
public class Modificar extends ActionSupport {

    String usuario;
    String password;
    int idAlumno;
    Usuarios alumno;

    public Modificar() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String obtenerAlumno(){
        BaseDatos bd = new BaseDatos();
        alumno = bd.getAlumno(idAlumno);
        
        return SUCCESS;
    }

}

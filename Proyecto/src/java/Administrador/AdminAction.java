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
public class AdminAction extends ActionSupport {
    private List lista;
    private String mensaje;
    private String NombreGrupo;

    public String getNombreGrupo() {
        return NombreGrupo;
    }

    public void setNombreGrupo(String NombreGrupo) {
        this.NombreGrupo = NombreGrupo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
    public AdminAction() {
    }
    
    public String cargarGrupos() 
    {
        System.out.println("Cargando Grupos");
        BaseDatos BD = new BaseDatos();
        lista = BD.TodosGrupos();
        return "1";
    }
    
    public String modificarGrupo()
    {
        return "0";
    }
    
    public String eliminarGrupo()
    {
        return "0";
    }
    
    public String cargarUsuarios() 
    {
        System.out.println("Cargando Usuarios");
        BaseDatos BD = new BaseDatos();
        lista = BD.TodosTablaX("Usuarios");
        return "1";
    }
    
    public String agregarGrupo()
    {
        System.out.println("Agregar Grupo");
        BaseDatos BD = new BaseDatos();
        if(NombreGrupo.isEmpty())
        {
            mensaje="campo vacio";
            lista = BD.TodosTablaX("Grupo");
            return "1";
        }
        if(BD.agregarGrupo(NombreGrupo))
            mensaje="Agregado Correcto";
        else
            mensaje="Grupo ya existente";
        lista = BD.TodosTablaX("Grupo");
        System.out.println(mensaje);
        return "1";
    }
}

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
}

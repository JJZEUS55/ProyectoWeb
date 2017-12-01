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
public class AdminModUser extends ActionSupport {
    private int iduserMod;
    private String usuarioMod;
    private int tipoUsuarioMod;
    private String grupoMod;
    private String nombreMod;
    private String apPaternoMod;
    private String apMaternoMod;
    private String abc;
    private String mensaje;
    private List lista;
    
    public String getGrupoMod() {
        return grupoMod;
    }

    public void setGrupoMod(String grupoMod) {
        this.grupoMod = grupoMod;
    }
    
    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }


    public int getIduserMod() {
        return iduserMod;
    }

    public void setIduserMod(int iduserMod) {
        this.iduserMod = iduserMod;
    }

    public String getUsuarioMod() {
        return usuarioMod;
    }

    public void setUsuarioMod(String usuarioMod) {
        this.usuarioMod = usuarioMod;
    }

    public int getTipoUsuarioMod() {
        return tipoUsuarioMod;
    }

    public void setTipoUsuarioMod(int tipoUsuarioMod) {
        this.tipoUsuarioMod = tipoUsuarioMod;
    }

    public String getNombreMod() {
        return nombreMod;
    }

    public void setNombreMod(String nombreMod) {
        this.nombreMod = nombreMod;
    }

    public String getApPaternoMod() {
        return apPaternoMod;
    }

    public void setApPaternoMod(String apPaternoMod) {
        this.apPaternoMod = apPaternoMod;
    }

    public String getApMaternoMod() {
        return apMaternoMod;
    }

    public void setApMaternoMod(String apMaternoMod) {
        this.apMaternoMod = apMaternoMod;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public AdminModUser() {
    }    

    public String modificarUsuario()
    {
        System.out.println(abc);
        BaseDatos BD = new BaseDatos();
        lista = BD.TodosTablaX("Usuarios");
        mensaje="prueba usuario"+iduserMod+":"+ usuarioMod+ " "+ tipoUsuarioMod +" "+ nombreMod +" "+apPaternoMod +" "+ apMaternoMod+" "+grupoMod ;
        return "1";
    }
    
}

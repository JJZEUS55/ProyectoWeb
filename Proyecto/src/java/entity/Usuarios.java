package entity;
// Generated Nov 18, 2017 3:49:41 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuarios generated by hbm2java
 */
public class Usuarios  implements java.io.Serializable {


     private int idUsuario;
     private Grupo grupo;
     private String usuario;
     private String contrasena;
     private Integer tipoUsuario;
     private String nombre;
     private String apPaterno;
     private String apMaterno;
     private Set tareases = new HashSet(0);
     private Set calificacioneses = new HashSet(0);

    public Usuarios() {
    }

	
    public Usuarios(int idUsuario, Grupo grupo) {
        this.idUsuario = idUsuario;
        this.grupo = grupo;
    }
    public Usuarios(Grupo grupo, String usuario, String contrasena, Integer tipoUsuario, String nombre, String apPaterno, String apMaterno, Set tareases, Set calificacioneses) {
       this.grupo = grupo;
       this.usuario = usuario;
       this.contrasena = contrasena;
       this.tipoUsuario = tipoUsuario;
       this.nombre = nombre;
       this.apPaterno = apPaterno;
       this.apMaterno = apMaterno;
       this.tareases = tareases;
       this.calificacioneses = calificacioneses;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Integer getTipoUsuario() {
        return this.tipoUsuario;
    }
    
    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApPaterno() {
        return this.apPaterno;
    }
    
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }
    public String getApMaterno() {
        return this.apMaterno;
    }
    
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }
    public Set getTareases() {
        return this.tareases;
    }
    
    public void setTareases(Set tareases) {
        this.tareases = tareases;
    }
    public Set getCalificacioneses() {
        return this.calificacioneses;
    }
    
    public void setCalificacioneses(Set calificacioneses) {
        this.calificacioneses = calificacioneses;
    }




}



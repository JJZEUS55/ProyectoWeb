package entity;
// Generated Nov 18, 2017 3:49:41 PM by Hibernate Tools 4.3.1



/**
 * Tareas generated by hbm2java
 */
public class Tareas  implements java.io.Serializable {


     private Integer idTareas;
     private Usuarios usuarios;
     private String archivo;

    public Tareas() {
    }

	
    public Tareas(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public Tareas(Usuarios usuarios, String archivo) {
       this.usuarios = usuarios;
       this.archivo = archivo;
    }
   
    public Integer getIdTareas() {
        return this.idTareas;
    }
    
    public void setIdTareas(Integer idTareas) {
        this.idTareas = idTareas;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    public String getArchivo() {
        return this.archivo;
    }
    
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }




}



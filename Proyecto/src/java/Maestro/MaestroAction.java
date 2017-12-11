/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maestro;

import BD.BaseDatos;
import BD.BaseDatosMaestro;
import com.opensymphony.xwork2.ActionSupport;
import entity.Calificaciones;
import entity.Grupo;
import entity.Tareas;
import entity.Usuarios;
import java.util.List;

/**
 *
 * @author usuario
 */
public class MaestroAction extends ActionSupport {
    
    private Grupo grupo;
    private Usuarios alumno;
    private Tareas tarea;
    private List alumnos;
    private Calificaciones calificacion;
    String userName;
    int idGrupo;
    int idAlumno;
    int idCalificacion;
    String nuevaCalificacion;
    private String mensaje;
    
    public MaestroAction() {
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public List getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List alumnos) {
        this.alumnos = alumnos;
    }
    
        public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Calificaciones getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificaciones calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Usuarios getAlumno() {
        return alumno;
    }

    public void setAlumno(Usuarios alumno) {
        this.alumno = alumno;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public String getNuevaCalificacion() {
        return nuevaCalificacion;
    }

    public void setNuevaCalificacion(String nuevaCalificacion) {
        this.nuevaCalificacion = nuevaCalificacion;
    }

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }
    
    
    
    
    
    
    
    
//    EMPIEZAN LOS METODOS FUERA DE GET AND SET
    
   public String cargarGrupo(){
       
       System.out.println("Cargando Grupos");
        BaseDatosMaestro BD = new BaseDatosMaestro();
        grupo = BD.getGrupo(userName);
        return "1";
   }
   
   public String cargarAlumnos(){
       System.out.println("Cargando Alumnos");
        BaseDatosMaestro BD = new BaseDatosMaestro();
        alumnos = BD.getAlumnos(idGrupo);
        return "1";
   }
   
   public String cargarAlumno(){
       System.out.println("Cargando Alumno");
        BaseDatosMaestro BD = new BaseDatosMaestro();
        alumno = BD.getAlumno(idAlumno);
       return "1";
   }
   
   public String calificarAlumno(){
        System.out.println("Cargando Alumno");
        BaseDatosMaestro BD = new BaseDatosMaestro();
        alumno = BD.getAlumno(idAlumno);
        calificacion = BD.getAlumnoCalificacion(idAlumno);       
       
       return "1";
   }
   
   public String modificarCalificacion(){
       System.out.println("Cambiando calificacion");
       //nuevaCalificacion = "7";
       System.out.println("calificacion = " + nuevaCalificacion);
       BaseDatosMaestro bd = new BaseDatosMaestro();       
       bd.cambiarCalificacion(idCalificacion,nuevaCalificacion);
       calificarAlumno();
       return "1";
   }
   public String InicioProfesor()
   {
       return "1";
   }
   
   public String ejercicio(){
       
       
       
       return "1";
   }
  
   
   
   


}

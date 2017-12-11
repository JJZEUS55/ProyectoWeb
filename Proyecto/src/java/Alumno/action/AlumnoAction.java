package Alumno.action;

import BD.BaseDatos;
import BD.BaseDatosAlumno;
import com.opensymphony.xwork2.ActionSupport;
import entity.Tareas;
import entity.Usuarios;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AlumnoAction extends ActionSupport {

    Usuarios alumno;
    int idAlumno;
    List listaCalificaciones;
    List interfacesIzDer;
    List listaNoCalificados;
    Tareas tarea;
    String usuario;

    public AlumnoAction() {
    }

    public Usuarios getAlumno() {
        return alumno;
    }

    public void setAlumno(Usuarios alumno) {
        this.alumno = alumno;
    }

    public List getListaCalificaciones() {
        return listaCalificaciones;
    }

    public void setListaCalificaciones(List listaCalificaciones) {
        this.listaCalificaciones = listaCalificaciones;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public List getInterfacesIzDer() {
        return interfacesIzDer;
    }

    public void setInterfacesIzDer(List interfacesIzDer) {
        this.interfacesIzDer = interfacesIzDer;
    }

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public List getListaNoCalificados() {
        return listaNoCalificados;
    }

    public void setListaNoCalificados(List listaNoCalificados) {
        this.listaNoCalificados = listaNoCalificados;
    }
    
    
    

    public String cargarCalificaciones() {
        BaseDatosAlumno bd = new BaseDatosAlumno();
         idAlumno = bd.getId(usuario);
        listaCalificaciones = bd.getCalificaciones(idAlumno);
        listaNoCalificados = bd.getNoCalificados(idAlumno);
       
        System.out.println("id alumno " + idAlumno);
        System.out.println("id alumno " + usuario);
        System.out.println("Calificaciones " + listaCalificaciones.toString());
        return "1";
    }

    public String InicioAlumno() {
        return "1";
    }

    public String modificarAlumno() {

        return SUCCESS;
    }   
    
    public String obtenerTarea(){
         System.out.println("Cargando Tarea");
         BaseDatosAlumno bd = new BaseDatosAlumno();
         idAlumno = bd.getId(usuario);
         tarea = bd.getTarea(idAlumno);
         
        return "1";
    }

}

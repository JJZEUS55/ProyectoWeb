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
    
    

    public String cargarCalificaciones() {
        BaseDatos bd = new BaseDatos();
        listaCalificaciones = bd.getCalificacion(idAlumno);
        return SUCCESS;
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

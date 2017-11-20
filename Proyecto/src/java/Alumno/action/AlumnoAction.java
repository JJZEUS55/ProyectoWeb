package Alumno.action;

import BD.BaseDatos;
import com.opensymphony.xwork2.ActionSupport;
import entity.Usuarios;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AlumnoAction extends ActionSupport {

    Usuarios alumno;
    List listaCalificaciones;

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

    public String cargarCalificaciones(){
        BaseDatos bd = new BaseDatos();
        listaCalificaciones = bd.getCalificacion(alumno);
        return SUCCESS;
    }
    
    public String modificarAlumno(){
        
        return SUCCESS;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import entity.Calificaciones;
import entity.Grupo;
import entity.HibernateUtil;
import entity.Usuarios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class BaseDatosMaestro {

    Session hibernateSession;
    Usuarios u;
    Grupo g;
    Calificaciones calificacion;

    public BaseDatosMaestro() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();

    }

    public Grupo getGrupo(String userName) //Retorna el tipo de usuario(1:Estudiante, 2:alumno, 3:Administrador)
    {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario='" + userName + "'").uniqueResult();
        g = (Grupo) hibernateSession.createQuery("from Grupo where idGrupo='" + u.getGrupo().getIdGrupo() + "'").uniqueResult();
        return g;
    }

    public List getAlumnos(int idGrupo) {

        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query consulta = hibernateSession.createQuery("from Usuarios where idGrupo=" + idGrupo + " AND tipoUsuario="+1);
        return consulta.list();
    }

    public Usuarios getAlumno(int idAlumno) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where idUsuario=" + idAlumno).uniqueResult();
        return u;
    }

    public Calificaciones getAlumnoCalificacion(int idAlumno) {
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where idUsuario=" + idAlumno).uniqueResult();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        calificacion = (Calificaciones) hibernateSession.createQuery("from Calificaciones where idUsuario="+idAlumno).uniqueResult();
        return calificacion;
    }
    
    public void cambiarCalificacion(int idCalificacion, String calificacion){
        
        int auxCalificacion = Integer.parseInt(calificacion);
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        Calificaciones nuevaCalificacion = (Calificaciones) hibernateSession.load(Calificaciones.class, 2);
        nuevaCalificacion.setCalificacion(auxCalificacion);
        hibernateSession.update(nuevaCalificacion);
        t1.commit();
        
    }

}

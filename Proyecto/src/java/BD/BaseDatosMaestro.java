/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import entity.Calificaciones;
import entity.Grupo;
import entity.HibernateUtil;
import entity.Tareas;
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
        Query consulta = hibernateSession.createQuery("from Usuarios where idGrupo=" + idGrupo + " AND tipoUsuario=" + 1);
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
        calificacion = (Calificaciones) hibernateSession.createQuery("from Calificaciones where idUsuario=" + idAlumno).uniqueResult();
        return calificacion;
    }

    public void cambiarCalificacion(int idCalificacion, String calificacion) {

        int auxCalificacion = Integer.parseInt(calificacion);
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        Calificaciones nuevaCalificacion = (Calificaciones) hibernateSession.load(Calificaciones.class, 2);
        nuevaCalificacion.setCalificacion(auxCalificacion);
        hibernateSession.update(nuevaCalificacion);
        t1.commit();
    }

    public void ponerTarea(String idAlumno, String calificacion,
            String int1solveiz1, String int1solveiz2, String int1solveiz3, String int1solveder1, String int1solveder2, String int1solveder3,
            String int2solveiz1, String int2solveiz2, String int2solveiz3, String int2solveder1, String int2solveder2, String int2solveder3,
            String int3solveiz1, String int3solveiz2, String int3solveiz3, String int3solveder1, String int3solveder2, String int3solveder3,
            String int4solveiz1, String int4solveiz2, String int4solveiz3, String int4solveder1, String int4solveder2, String int4solveder3
    ) {
        int aux = Integer.parseInt(idAlumno);
        Tareas nuevaTarea = new Tareas();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where idUsuario="+ 6).uniqueResult();
        
        
        nuevaTarea.setUsuarios(u);
        nuevaTarea.setCalificacion(Integer.parseInt(calificacion));
        
        //INTERFAZ 1
        nuevaTarea.setInt1solveiz1(Integer.parseInt(int1solveiz1));
        nuevaTarea.setInt1solveiz2(Integer.parseInt(int1solveiz2));
        nuevaTarea.setInt1solveiz3(Integer.parseInt(int1solveiz3));
        nuevaTarea.setInt1solveder1(Integer.parseInt(int1solveder1));
        nuevaTarea.setInt1solveder2(Integer.parseInt(int1solveder2));
        nuevaTarea.setInt1solveder3(Integer.parseInt(int1solveder3));
        
        //INTERFAZ 2
        nuevaTarea.setInt2solveiz1(Integer.parseInt(int2solveiz1));
        nuevaTarea.setInt2solveiz2(Integer.parseInt(int2solveiz2));
        nuevaTarea.setInt2solveiz3(Integer.parseInt(int2solveiz3));
        nuevaTarea.setInt2solveder1(Integer.parseInt(int2solveder1));
        nuevaTarea.setInt2solveder2(Integer.parseInt(int2solveder2));
        nuevaTarea.setInt2solveder3(Integer.parseInt(int2solveder3));
        
        //INTERFAZ 3
        nuevaTarea.setInt3solveiz1(Integer.parseInt(int3solveiz1));
        nuevaTarea.setInt3solveiz2(Integer.parseInt(int3solveiz2));
        nuevaTarea.setInt3solveiz3(Integer.parseInt(int3solveiz3));
        nuevaTarea.setInt3solveder1(Integer.parseInt(int3solveder1));
        nuevaTarea.setInt3solveder2(Integer.parseInt(int3solveder2));
        nuevaTarea.setInt3solveder3(Integer.parseInt(int3solveder3));
        
        
        hibernateSession.save(nuevaTarea);
        t1.commit();
        

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static com.opensymphony.xwork2.Action.SUCCESS;
import entity.Grupo;
import entity.HibernateUtil;
import entity.Resultados;
import entity.Tareas;
import entity.Usuarios;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Set;

/**
 *
 * @author usuario
 */
public class BaseDatosAlumno {

    Session hibernateSession;
    Usuarios u;
    Grupo g;
    Tareas tarea;

    public Tareas getTarea(int idTarea) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        tarea = (Tareas) hibernateSession.createQuery("from Tareas where idTareas=" + idTarea).uniqueResult();

        return tarea;
    }

    public List getTareas(int idAlumno) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        Query consulta = hibernateSession.createQuery("from Tareas where idUsuario=" + idAlumno);

        return consulta.list();
    }

    public Tareas getTareabyId(int idTarea) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        tarea = (Tareas) hibernateSession.createQuery("from Tareas where idTareas=" + idTarea).uniqueResult();

        return tarea;
    }

    public int getId(String usuario) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario='" + usuario + "'").uniqueResult();

        return u.getIdUsuario();
    }

    public void setResultados(int idTarea, int idAlumno, String res1, String res2, String res3, String res4) {

        Resultados nuevoResultado = new Resultados();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where idUsuario=" + idAlumno).uniqueResult();
        tarea = (Tareas) hibernateSession.createQuery("from Tareas where idTareas=" + idTarea).uniqueResult();

        nuevoResultado.setUsuarios(u);
        nuevoResultado.setTareas(tarea);
        nuevoResultado.setResultado1(res1);
        nuevoResultado.setResultado2(res2);
        nuevoResultado.setResultado3(res3);
        nuevoResultado.setResultado4(res4);

        hibernateSession.save(nuevoResultado);
        t1.commit();
    }

    public List getCalificaciones(int idAlumno) {

        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        Query consulta = hibernateSession.createQuery("from Tareas where idUsuario=" + idAlumno + " AND calificacion!=" + 0);

        return consulta.list();

    }

    public List getNoCalificados(int idAlumno) {

        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        Query consulta = hibernateSession.createQuery("from Tareas where idUsuario=" + idAlumno + " AND calificacion=" + 0);

        return consulta.list();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import static com.opensymphony.xwork2.Action.SUCCESS;
import entity.Grupo;
import entity.HibernateUtil;
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

    public Tareas getTarea(int idAlumno) {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();        
        tarea = (Tareas) hibernateSession.createQuery("from Tareas where idUsuario="+idAlumno).uniqueResult();
        
        return tarea;
    }
    
    public int getId(String usuario){
         hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();  
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario='"+ usuario +"'").uniqueResult();
        
        return u.getIdUsuario();
    }

}

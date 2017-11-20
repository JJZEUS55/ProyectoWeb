/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author ZOLUN
 */
import static com.opensymphony.xwork2.Action.SUCCESS;
import entity.Grupo;
import entity.HibernateUtil;
import entity.Usuarios;
import java.sql.ResultSet;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseDatos {

    Session hibernateSession;
    Usuarios u;
    Grupo g;

    public BaseDatos() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        g = (Grupo) hibernateSession.createQuery("from Grupo where idGrupo = 1").uniqueResult();
    }

    public boolean iniciarSesion(String userName, String password)//Returna true si el usuario es valido en la base de datos
    {

        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario='" + userName + "'AND contrasena='" + password + "'").uniqueResult();
        if (userName == null || password == null) {
            return false;
        }
        if (u != null) {
            return true;
        }
        return false;
    }

    public int getTipoUsuario(String userName) //Retorna el tipo de usuario(1:Estudiante, 2:alumno, 3:Administrador)
    {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario='" + userName + "'").uniqueResult();
        return u.getTipoUsuario();
    }
    public boolean agregarUsuario(String usernameN, String passwordN, int tipoN, String nombreN, String app, String apm)
    {
        Usuarios nuevo = new Usuarios();
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        nuevo = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario ='" + usernameN + "'").uniqueResult();
        if(nuevo == null) // si nuevo es null se puede agregar
        {
            Usuarios N = new Usuarios();
            N.setUsuario(usernameN);
            N.setContrasena(passwordN);
            N.setTipoUsuario(tipoN);
            N.setNombre(nombreN);
            N.setApPaterno(app);
            N.setApMaterno(apm);
            N.setGrupo(g);
            hibernateSession.save(N);
            t1.commit();
            return true;
        }
        else
        {
 
            return false;
        }
    }
    public List TodosGrupos() // Regresa una lista con todos los grupos de la base
    {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query consulta = hibernateSession.createQuery("from Grupo");
        return consulta.list();
    }

    public boolean agregarGrupo(String Nombre) {
        Grupo x;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        x = (Grupo) hibernateSession.createQuery("from Grupo where nombre ='" + Nombre + "'").uniqueResult();

        if (x == null) // si x es null se puede agregar
        {
            Grupo nuevo = new Grupo();
            nuevo.setNombre(Nombre);
            hibernateSession.save(nuevo);
            t1.commit();
            return true;
        } else {
            return false;
        }
    }

    public List TodosTablaX(String Tabla) {

        hibernateSession = HibernateUtil.getSessionFactory().openSession();

        Query consulta = hibernateSession.createQuery("from " + Tabla);
        return consulta.list();
    }
    
    
    /**    Empiezan Metodos del ALUMNO
     * 
     *  Obtener calificaciones 
     * 
    */
    public List getCalificacion(Usuarios alumno){
        
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query consulta = hibernateSession.createQuery("from Calificaciones where usuarios=" + alumno);
        
        return consulta.list();        
    }
    
    

}

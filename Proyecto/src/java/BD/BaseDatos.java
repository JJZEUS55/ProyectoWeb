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
    
    public BaseDatos(){}
    public boolean iniciarSesion(String userName, String password)
    {
        
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario='" + userName + "'AND contrasena='" + password + "'").uniqueResult();
        if(userName == null || password == null)
            return false;
        if(u != null)
        {
            return true;
        }
        return false;
    }
    public int getTipoUsuario(String userName)
    {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario='" + userName +"'").uniqueResult();
        return u.getTipoUsuario();
    }
    
    
}
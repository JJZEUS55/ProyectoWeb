/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import com.opensymphony.xwork2.ActionSupport;
import BD.BaseDatos;
import entity.HibernateUtil;
import entity.Usuarios;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ZOLUN
 */
public class AdminDeleteUser extends ActionSupport {
    private int id;
    private List lista;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
    public AdminDeleteUser() {
    }
    
    public String eliminarUsuario()
    {
        BaseDatos BD = new BaseDatos();
        Session hibernateSession;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        Usuarios UserEliminado = (Usuarios) hibernateSession.load(Usuarios.class, id);
        hibernateSession.delete(UserEliminado);
        t.commit();
        lista = BD.TodosTablaX("Usuarios");
        return "1";
    }
    
}

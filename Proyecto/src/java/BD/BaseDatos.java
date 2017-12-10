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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Set;

public class BaseDatos {

    Session hibernateSession;
    Usuarios u;
    Grupo g;

    public BaseDatos() {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        
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
    public boolean agregarUsuario(String usernameN, String passwordN, int tipoN, String nombreN, String app, String apm, String grupoN)
    {
        g = (Grupo) hibernateSession.createQuery("from Grupo where nombre = '"+grupoN+"'").uniqueResult();
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
    
    public boolean Modusuario(int id, String usernameN, int tipoN, String nombreN, String app, String apm, String nombreGrupo)
    {
        if(tipoN == 2 && checkGrupo(nombreGrupo) == true)
        {
            return false;
        }
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        Usuarios userMod = (Usuarios) hibernateSession.load(Usuarios.class, id);
        userMod.setUsuario(usernameN);
        userMod.setTipoUsuario(tipoN);
        userMod.setNombre(nombreN);
        userMod.setApPaterno(app);
        userMod.setApMaterno(apm);
        hibernateSession.update(userMod);
        t1.commit();
        return true;
    }
    
    public List TodosGrupos() // Regresa una lista con todos los grupos de la base
    {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Query consulta = hibernateSession.createQuery("from Grupo");
        return consulta.list();
    }
    
//    Funciones grupos
    
    public boolean agregarGrupo(String Nombre) 
    {
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
    public void eliminarGrupo(int id)
    {
        System.out.println("o¿id...."+id);
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        Grupo GrupoEliminado = (Grupo) hibernateSession.load(Grupo.class, id);
        hibernateSession.delete(GrupoEliminado);
        t.commit();
        
    }
    

    public List TodosTablaX(String Tabla) {

        hibernateSession = HibernateUtil.getSessionFactory().openSession();

        Query consulta = hibernateSession.createQuery("from " + Tabla);
        return consulta.list();
    }
    
    public Grupo SolicitarGrupo(int id)
    {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        Grupo GrupoSolicitado = (Grupo) hibernateSession.load(Grupo.class, id);
        return GrupoSolicitado;
    }
    
    public Grupo SolicitarGrupo(String nombre)
    {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        Grupo GrupoSolicitado = (Grupo) hibernateSession.createQuery("from Grupo where nombre ='"+nombre+"' ").uniqueResult();
        return GrupoSolicitado;
    }
    
    public List AlumnosSinGrupo()
    {
       hibernateSession = HibernateUtil.getSessionFactory().openSession();
       Query consulta = hibernateSession.createQuery("from Usuarios where tipoUsuario = 1 and idGrupo = 1 ");
       return consulta.list();
    }
    
    public List ProfesoresSinGrupo()
    {
       hibernateSession = HibernateUtil.getSessionFactory().openSession();
       Query consulta = hibernateSession.createQuery("from Usuarios where tipoUsuario = 2 and idGrupo = 1 ");
       return consulta.list();
    }
    
    public String ProfesorDelGrupo(int idGrupo)
    {
        Usuarios Profesor;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Profesor = (Usuarios)hibernateSession.createQuery("from Usuarios where tipoUsuario = 2 and idGrupo ="+idGrupo).uniqueResult();
        if(Profesor == null)
            return "Sin asignar";
        else
            return Profesor.getNombre()+" "+Profesor.getApPaterno()+" "+Profesor.getApMaterno();
    }
    
    public Usuarios ProfesorDelGrupo_Us(int idGrupo)
    {
        Usuarios Profesor;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Profesor = (Usuarios)hibernateSession.createQuery("from Usuarios where tipoUsuario = 2 and idGrupo ="+idGrupo).uniqueResult();
        if(Profesor == null)
            return null;
        else
            return Profesor;
    }
    
    public boolean checkGrupo(String nombreGrupo) // checa si tiene profesor el grupo true->si tiene
    {
        Grupo grupoCheck;
        Set usersSet;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        grupoCheck = (Grupo)hibernateSession.createQuery("from Grupo where nombre ='"+nombreGrupo+"' ").uniqueResult();
        usersSet = grupoCheck.getUsuarioses();
        List users = new ArrayList(usersSet);
        for (int i = 0; i <users.size(); i++) {
            if(((Usuarios)users.get(i)).getTipoUsuario() == 2 )
                return true;
        }
        return false;
        
    }
    
    public Usuarios getUsuario(int idUser)
    {
        
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        Usuarios usuario = (Usuarios) hibernateSession.load(Usuarios.class, idUser);
        return usuario;
    }
    
    public int idProfesorDelGrupo(int idGrupo)
    {
        Usuarios Profesor;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Profesor = (Usuarios)hibernateSession.createQuery("from Usuarios where tipoUsuario = 2 and idGrupo ="+idGrupo).uniqueResult();
        if(Profesor == null)
            return 0;
        else
            return Profesor.getIdUsuario();
    }
    
    public List ResultadoBusqueda(String campo)
    {
        System.out.println("Busqueda: "+campo);
        List resultados;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        resultados = hibernateSession.createQuery("from Usuarios where (idUsuario like '%"+campo+"%') or (usuario like '%"+campo+"%') or (tipoUsuario like '%"+campo+"%') or (nombre like '%"+campo+"%') or (apPaterno like '%"+campo+"%') or (apMaterno like '%"+campo+"%') or (idGrupo like '%"+campo+"%') ").list();
        
        return resultados;
    }
    
    
    
    
    public void CambiarUsuariodeGrupo(int idUsuario, int idGrupo) // cambia un usuario a otro grupo idgrupo corresponde al nuevo grupo
    {
        System.out.println("Cambiando id user:"+ idUsuario+" to idgrup "+idGrupo);
        Usuarios user;
        Grupo grupoN;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = hibernateSession.beginTransaction();
        user = (Usuarios)hibernateSession.createQuery("from Usuarios where idUsuario = "+idUsuario).uniqueResult();
        grupoN = (Grupo) hibernateSession.createQuery("from Grupo where idGrupo ="+ idGrupo).uniqueResult();
        user.setGrupo(grupoN);
        hibernateSession.update(user);
        t.commit();
        
    }
    
    
    /**    Empiezan Metodos del ALUMNO
     * 
     *  Obtener calificaciones 
     * 
    */
    public List getCalificacion(int idUsuario){
        Usuarios alumno;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        alumno = (Usuarios)hibernateSession.get(Usuarios.class, idUsuario);
        Query consulta = hibernateSession.createQuery("from Calificaciones where idUsuario="+alumno.getIdUsuario());
        
        return consulta.list();        
    }
    
    public Usuarios getAlumno(int idUsuario) {

        Usuarios alumno;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        alumno = (Usuarios) hibernateSession.load(Usuarios.class, idUsuario);
        return alumno;
    }

    public boolean modificarAlumno(Usuarios alumno, String usuario, String password) {
        boolean modificacion = false;
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = hibernateSession.beginTransaction();
//            alumno.setUsuario();
//            alumno.setContrasena();

        } catch (Exception e) {
        }

        return modificacion;
    }
    
    public Grupo getGrupo(String userName) //Retorna el tipo de usuario(1:Estudiante, 2:alumno, 3:Administrador)
    {
        hibernateSession = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = hibernateSession.beginTransaction();
        u = (Usuarios) hibernateSession.createQuery("from Usuarios where usuario='" + userName + "'").uniqueResult();
        g = (Grupo) hibernateSession.createQuery("from Grupo where idGrupo='" + u.getGrupo().getIdGrupo()+"'").uniqueResult();
        return g;
    }
    
    

}

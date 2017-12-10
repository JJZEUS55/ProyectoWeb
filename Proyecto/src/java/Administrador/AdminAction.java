/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import BD.BaseDatos;
import com.opensymphony.xwork2.ActionSupport;
import entity.Grupo;
import entity.Usuarios;
import static java.lang.reflect.Array.set;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ZOLUN
 */
public class AdminAction extends ActionSupport {
    private List lista;
    private ArrayList Grupos = new ArrayList();
    private String mensaje;
    private String NombreGrupo;
    private int idGrupo;
    private Set Usuarios;
    private List UsuariosSinGrupo;
    private List ProfesoresSinGrupo;
    private String NombreGrupoMod;
    private String ProfesorGrupoMod;
    private String profesorM;
    private String Buscar;

    public String getBuscar() {
        return Buscar;
    }

    public void setBuscar(String Buscar) {
        this.Buscar = Buscar;
    }

    public String getProfesorM() {
        return profesorM;
    }

    public void setProfesorM(String profesorM) {
        this.profesorM = profesorM;
    }
    private int user; 
    private int grupoC;

    public int getGrupoC() {
        return grupoC;
    }

    public void setGrupoC(int grupoC) {
        this.grupoC = grupoC;
    }
    

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public List getUsuariosSinGrupo() {
        return UsuariosSinGrupo;
    }

    public void setUsuariosSinGrupo(List UsuariosSinGrupo) {
        this.UsuariosSinGrupo = UsuariosSinGrupo;
    }

    public String getProfesorGrupoMod() {
        return ProfesorGrupoMod;
    }

    public void setProfesorGrupoMod(String ProfesorGrupoMod) {
        this.ProfesorGrupoMod = ProfesorGrupoMod;
    }
    

    public String getNombreGrupoMod() {
        return NombreGrupoMod;
    }

    public void setNombreGrupoMod(String NombreGrupoMod) {
        this.NombreGrupoMod = NombreGrupoMod;
    }
    
    

    public List getProfesoresSinGrupo() {
        return ProfesoresSinGrupo;
    }

    public void setProfesoresSinGrupo(List ProfesoresSinGrupo) {
        this.ProfesoresSinGrupo = ProfesoresSinGrupo;
    }
    
    

    public Set getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(Set Usuarios) {
        this.Usuarios = Usuarios;
    }
    

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public ArrayList getGrupos() {
        return Grupos;
    }

    public void setGrupos(ArrayList Grupos) {
        this.Grupos = Grupos;
    }

    public String getNombreGrupo() {
        return NombreGrupo;
    }

    public void setNombreGrupo(String NombreGrupo) {
        this.NombreGrupo = NombreGrupo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
    public String getDefaultTipo(){
        return "Alumno";
    }
    
    public AdminAction() {
    }
    
    public String cargarGrupos() 
    {
        System.out.println("Cargando Grupos");
        BaseDatos BD = new BaseDatos();
        lista = BD.TodosGrupos();
        return "1";
    }
    
    public String modificarGrupo()
    {
        initModGrupo();
        
        return "1";
    }
    
    public String Busqueda()
    {
        BaseDatos BD = new BaseDatos();
        lista = BD.ResultadoBusqueda(Buscar);
        return "1";
    }
    
    public String cargarUsuarios() 
    {   
        List Tem;
        Usuarios Usuarioprueba;
        System.out.println("Cargando Usuarios");
        BaseDatos BD = new BaseDatos();
        lista = BD.TodosTablaX("Usuarios");
        Tem = BD.TodosGrupos();
        
        for (int i = 0; i < Tem.size(); i++) {
            Grupos.add( ((Grupo) Tem.get(i)).getNombre() );
        }
       
        for (int i = 0; i < lista.size(); i++) {
            Usuarioprueba = (Usuarios) lista.get(i);
            System.out.println("Grupo"+Usuarioprueba.getGrupo().getNombre());
        }
        
        return "1";
    }
    
    public String agregarGrupo()
    {
        System.out.println("Agregar Grupo");
        BaseDatos BD = new BaseDatos();
        if(NombreGrupo.isEmpty())
        {
            mensaje="campo vacio";
            lista = BD.TodosTablaX("Grupo");
            return "1";
        }
        if(BD.agregarGrupo(NombreGrupo))
            mensaje="Agregado Correcto";
        else
            mensaje="Grupo ya existente";
        lista = BD.TodosTablaX("Grupo");
        System.out.println(mensaje);
        return "1";
        
    }
    
    public String eliminarGrupo()
    {
        
        System.out.println("Eliminar Grupo");
        BaseDatos BD = new BaseDatos();
        BD.eliminarGrupo(idGrupo);
        lista = BD.TodosTablaX("Grupo");
        return "1";
    }
    
    public String CambiarUsuariodeGrupo()
    {
        System.out.println("cambiando usuario de grupo");
        BaseDatos BD = new BaseDatos();
        BD.CambiarUsuariodeGrupo(user, grupoC);
        initModGrupo();
        return "1";
    }
    
    public String CambiarProfesorGrupo()
    { 
        BaseDatos BD = new BaseDatos();
        String cad[] = profesorM.split(":");
        Usuarios profesorActual = BD.ProfesorDelGrupo_Us(idGrupo);
        Usuarios profesorNuevo = BD.getUsuario(Integer.parseInt(cad[0]));
        if(profesorActual == null){
            System.out.println("Sin asiganr paso no requerido");
            BD.CambiarUsuariodeGrupo(profesorNuevo.getIdUsuario(), idGrupo); // si el grupo esta sin asignar solo se agrega el nuevo profesor
        }
        else
        {
            System.out.println("Profesor Actual: "+profesorActual.getNombre() +" Profesor Nuevo: "+profesorNuevo.getNombre());
            BD.CambiarUsuariodeGrupo(profesorActual.getIdUsuario(), 1); // cambia el profesor actual al grupo general
            BD.CambiarUsuariodeGrupo(profesorNuevo.getIdUsuario(), idGrupo);  // se asigna el nuevo profesor
        }
        mensaje = "Cambio Realizado";
        
        
        initModGrupo();
        return "1";
    }
    
    public void initModGrupo()
    {
        BaseDatos BD = new BaseDatos();
        Grupo GrupoSolicitado = BD.SolicitarGrupo(idGrupo);
        Usuarios Profesor;
        //List SinGrupo = BD.AlumnosSinGrupo();
        lista = BD.TodosGrupos();
        Usuarios = GrupoSolicitado.getUsuarioses();
        UsuariosSinGrupo = BD.AlumnosSinGrupo();
        NombreGrupoMod = GrupoSolicitado.getNombre();
        if(idGrupo == 1 )
            ProfesorGrupoMod = "----";
        else
            ProfesorGrupoMod = BD.ProfesorDelGrupo(idGrupo);
        
        ProfesoresSinGrupo = BD.ProfesoresSinGrupo();
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumno.action;

import BD.BaseDatosAlumno;
import com.opensymphony.xwork2.ActionSupport;
import entity.Tareas;
import java.util.List;

/**
 *
 * @author usuario
 */
public class AlumnoTarea extends ActionSupport {

    int idAlumno;
    int idTarea;
    String usuario;
    Tareas tarea;
    List listaTareas;

    int calificacion;
//    PRIMER INTERFAZ
    int int1solveiz1;
    int int1solveiz2;
    int int1solveiz3;
    int int1solveder1;
    int int1solveder2;
    int int1solveder3;

//    SEGUNDA INTERFAZ
    int int2solveiz1;
    int int2solveiz2;
    int int2solveiz3;
    int int2solveder1;
    int int21solveder2;
    int int2solveder3;

//    TERCER INTERFAZ
    int int3solveiz1;
    int int3solveiz2;
    int int3solveiz3;
    int int3solveder1;
    int int3solveder2;
    int int3solveder3;

//    CUARTA INTERFAZ
    int int4solveiz1;
    int int4solveiz2;
    int int4solveiz3;
    int int4solveder1;
    int int4solveder2;
    int int4solveder3;

    //RESULTADOS
    String res1;
    String res2;
    String res3;
    String res4;

    public AlumnoTarea() {
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Tareas getTarea() {
        return tarea;
    }

    public void setTarea(Tareas tarea) {
        this.tarea = tarea;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getInt1solveiz1() {
        return int1solveiz1;
    }

    public void setInt1solveiz1(int int1solveiz1) {
        this.int1solveiz1 = int1solveiz1;
    }

    public int getInt1solveiz2() {
        return int1solveiz2;
    }

    public void setInt1solveiz2(int int1solveiz2) {
        this.int1solveiz2 = int1solveiz2;
    }

    public int getInt1solveiz3() {
        return int1solveiz3;
    }

    public void setInt1solveiz3(int int1solveiz3) {
        this.int1solveiz3 = int1solveiz3;
    }

    public int getInt1solveder1() {
        return int1solveder1;
    }

    public void setInt1solveder1(int int1solveder1) {
        this.int1solveder1 = int1solveder1;
    }

    public int getInt1solveder2() {
        return int1solveder2;
    }

    public void setInt1solveder2(int int1solveder2) {
        this.int1solveder2 = int1solveder2;
    }

    public int getInt1solveder3() {
        return int1solveder3;
    }

    public void setInt1solveder3(int int1solveder3) {
        this.int1solveder3 = int1solveder3;
    }

    public int getInt2solveiz1() {
        return int2solveiz1;
    }

    public void setInt2solveiz1(int int2solveiz1) {
        this.int2solveiz1 = int2solveiz1;
    }

    public int getInt2solveiz2() {
        return int2solveiz2;
    }

    public void setInt2solveiz2(int int2solveiz2) {
        this.int2solveiz2 = int2solveiz2;
    }

    public int getInt2solveiz3() {
        return int2solveiz3;
    }

    public void setInt2solveiz3(int int2solveiz3) {
        this.int2solveiz3 = int2solveiz3;
    }

    public int getInt2solveder1() {
        return int2solveder1;
    }

    public void setInt2solveder1(int int2solveder1) {
        this.int2solveder1 = int2solveder1;
    }

    public int getInt21solveder2() {
        return int21solveder2;
    }

    public void setInt21solveder2(int int21solveder2) {
        this.int21solveder2 = int21solveder2;
    }

    public int getInt2solveder3() {
        return int2solveder3;
    }

    public void setInt2solveder3(int int2solveder3) {
        this.int2solveder3 = int2solveder3;
    }

    public int getInt3solveiz1() {
        return int3solveiz1;
    }

    public void setInt3solveiz1(int int3solveiz1) {
        this.int3solveiz1 = int3solveiz1;
    }

    public int getInt3solveiz2() {
        return int3solveiz2;
    }

    public void setInt3solveiz2(int int3solveiz2) {
        this.int3solveiz2 = int3solveiz2;
    }

    public int getInt3solveiz3() {
        return int3solveiz3;
    }

    public void setInt3solveiz3(int int3solveiz3) {
        this.int3solveiz3 = int3solveiz3;
    }

    public int getInt3solveder1() {
        return int3solveder1;
    }

    public void setInt3solveder1(int int3solveder1) {
        this.int3solveder1 = int3solveder1;
    }

    public int getInt3solveder2() {
        return int3solveder2;
    }

    public void setInt3solveder2(int int3solveder2) {
        this.int3solveder2 = int3solveder2;
    }

    public int getInt3solveder3() {
        return int3solveder3;
    }

    public void setInt3solveder3(int int3solveder3) {
        this.int3solveder3 = int3solveder3;
    }

    public int getInt4solveiz1() {
        return int4solveiz1;
    }

    public void setInt4solveiz1(int int4solveiz1) {
        this.int4solveiz1 = int4solveiz1;
    }

    public int getInt4solveiz2() {
        return int4solveiz2;
    }

    public void setInt4solveiz2(int int4solveiz2) {
        this.int4solveiz2 = int4solveiz2;
    }

    public int getInt4solveiz3() {
        return int4solveiz3;
    }

    public void setInt4solveiz3(int int4solveiz3) {
        this.int4solveiz3 = int4solveiz3;
    }

    public int getInt4solveder1() {
        return int4solveder1;
    }

    public void setInt4solveder1(int int4solveder1) {
        this.int4solveder1 = int4solveder1;
    }

    public int getInt4solveder2() {
        return int4solveder2;
    }

    public void setInt4solveder2(int int4solveder2) {
        this.int4solveder2 = int4solveder2;
    }

    public int getInt4solveder3() {
        return int4solveder3;
    }

    public void setInt4solveder3(int int4solveder3) {
        this.int4solveder3 = int4solveder3;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    public String getRes4() {
        return res4;
    }

    public void setRes4(String res4) {
        this.res4 = res4;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public List getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List listaTareas) {
        this.listaTareas = listaTareas;
    }
    
    
    
    public String obtenerTareas(){
        System.out.println("Cargando Tareas");
        System.out.println("El alumno es " + usuario);
        BaseDatosAlumno bd = new BaseDatosAlumno();
        idAlumno=bd.getId(usuario);
        System.out.println("su id es " + idAlumno);
        listaTareas = bd.getTareas(idAlumno);
        System.out.println("tareas " + listaTareas.toString());
        
        return "1";
    }
    
    

    public String obtenerTarea() {
        System.out.println("Cargando Tarea");
        System.out.println("El usuario es " + usuario
        + "id alumno es " + idAlumno);
        BaseDatosAlumno bd = new BaseDatosAlumno();
        idAlumno = bd.getId(usuario);
        tarea = bd.getTarea(idTarea);
        

        return "1";
    }

    public String obtenerResultados() {
        System.out.println("Obteniendo Resultados del ejercicio");
        BaseDatosAlumno bd = new BaseDatosAlumno();
        idAlumno = bd.getId(usuario);
        System.out.println("res1: " + res1
                + "res2: " + res2
                + "res3: " + res3
                + "res4: " + res4
                + "idTarea "+ idTarea
                + "idAlumno " + idAlumno);
        bd.setResultados(idTarea, idAlumno, res1, res2, res3, res4);

        return "1";
    }

}

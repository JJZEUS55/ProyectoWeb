/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Maestro;

import BD.BaseDatosMaestro;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author usuario
 */
public class MaestroTarea extends ActionSupport {

    String idAlumno;
    String idUsuario;
    String calificacion;
//    PRIMER INTERFAZ
    String int1solveiz1;
    String int1solveiz2;
    String int1solveiz3;
    String int1solveder1;
    String int1solveder2;
    String int1solveder3;

//    SEGUNDA INTERFAZ
    String int2solveiz1;
    String int2solveiz2;
    String int2solveiz3;
    String int2solveder1;
    String int21solveder2;
    String int2solveder3;

//    TERCER INTERFAZ
    String int3solveiz1;
    String int3solveiz2;
    String int3solveiz3;
    String int3solveder1;
    String int3solveder2;
    String int3solveder3;

//    CUARTA INTERFAZ
    String int4solveiz1;
    String int4solveiz2;
    String int4solveiz3;
    String int4solveder1;
    String int4solveder2;
    String int4solveder3;

    public MaestroTarea() {
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getInt1solveiz1() {
        return int1solveiz1;
    }

    public void setInt1solveiz1(String int1solveiz1) {
        this.int1solveiz1 = int1solveiz1;
    }

    public String getInt1solveiz2() {
        return int1solveiz2;
    }

    public void setInt1solveiz2(String int1solveiz2) {
        this.int1solveiz2 = int1solveiz2;
    }

    public String getInt1solveiz3() {
        return int1solveiz3;
    }

    public void setInt1solveiz3(String int1solveiz3) {
        this.int1solveiz3 = int1solveiz3;
    }

    public String getInt1solveder1() {
        return int1solveder1;
    }

    public void setInt1solveder1(String int1solveder1) {
        this.int1solveder1 = int1solveder1;
    }

    public String getInt1solveder2() {
        return int1solveder2;
    }

    public void setInt1solveder2(String int1solveder2) {
        this.int1solveder2 = int1solveder2;
    }

    public String getInt1solveder3() {
        return int1solveder3;
    }

    public void setInt1solveder3(String int1solveder3) {
        this.int1solveder3 = int1solveder3;
    }

    public String getInt2solveiz1() {
        return int2solveiz1;
    }

    public void setInt2solveiz1(String int2solveiz1) {
        this.int2solveiz1 = int2solveiz1;
    }

    public String getInt2solveiz2() {
        return int2solveiz2;
    }

    public void setInt2solveiz2(String int2solveiz2) {
        this.int2solveiz2 = int2solveiz2;
    }

    public String getInt2solveiz3() {
        return int2solveiz3;
    }

    public void setInt2solveiz3(String int2solveiz3) {
        this.int2solveiz3 = int2solveiz3;
    }

    public String getInt2solveder1() {
        return int2solveder1;
    }

    public void setInt2solveder1(String int2solveder1) {
        this.int2solveder1 = int2solveder1;
    }

    public String getInt21solveder2() {
        return int21solveder2;
    }

    public void setInt21solveder2(String int21solveder2) {
        this.int21solveder2 = int21solveder2;
    }

    public String getInt2solveder3() {
        return int2solveder3;
    }

    public void setInt2solveder3(String int2solveder3) {
        this.int2solveder3 = int2solveder3;
    }

    public String getInt3solveiz1() {
        return int3solveiz1;
    }

    public void setInt3solveiz1(String int3solveiz1) {
        this.int3solveiz1 = int3solveiz1;
    }

    public String getInt3solveiz2() {
        return int3solveiz2;
    }

    public void setInt3solveiz2(String int3solveiz2) {
        this.int3solveiz2 = int3solveiz2;
    }

    public String getInt3solveiz3() {
        return int3solveiz3;
    }

    public void setInt3solveiz3(String int3solveiz3) {
        this.int3solveiz3 = int3solveiz3;
    }

    public String getInt3solveder1() {
        return int3solveder1;
    }

    public void setInt3solveder1(String int3solveder1) {
        this.int3solveder1 = int3solveder1;
    }

    public String getInt3solveder2() {
        return int3solveder2;
    }

    public void setInt3solveder2(String int3solveder2) {
        this.int3solveder2 = int3solveder2;
    }

    public String getInt3solveder3() {
        return int3solveder3;
    }

    public void setInt3solveder3(String int3solveder3) {
        this.int3solveder3 = int3solveder3;
    }

    public String getInt4solveiz1() {
        return int4solveiz1;
    }

    public void setInt4solveiz1(String int4solveiz1) {
        this.int4solveiz1 = int4solveiz1;
    }

    public String getInt4solveiz2() {
        return int4solveiz2;
    }

    public void setInt4solveiz2(String int4solveiz2) {
        this.int4solveiz2 = int4solveiz2;
    }

    public String getInt4solveiz3() {
        return int4solveiz3;
    }

    public void setInt4solveiz3(String int4solveiz3) {
        this.int4solveiz3 = int4solveiz3;
    }

    public String getInt4solveder1() {
        return int4solveder1;
    }

    public void setInt4solveder1(String int4solveder1) {
        this.int4solveder1 = int4solveder1;
    }

    public String getInt4solveder2() {
        return int4solveder2;
    }

    public void setInt4solveder2(String int4solveder2) {
        this.int4solveder2 = int4solveder2;
    }

    public String getInt4solveder3() {
        return int4solveder3;
    }

    public void setInt4solveder3(String int4solveder3) {
        this.int4solveder3 = int4solveder3;
    }
    
    
    
    public String ponerEjercicio(){
        System.out.println("id" + idAlumno + "int1 " + int1solveder1 + " int2 " + int1solveder2);
        
        BaseDatosMaestro bd = new BaseDatosMaestro();
        bd.ponerTarea(idAlumno, calificacion, int1solveiz1, int1solveiz2, int1solveiz3, int1solveder1, int1solveder2, int1solveder3, int2solveiz1, int2solveiz2, int2solveiz3, int2solveder1, int1solveder2, int2solveder3, int3solveiz1, int3solveiz2, int3solveiz3, int3solveder1, int3solveder2, int3solveder3, int4solveiz1, int4solveiz2, int4solveiz3, int4solveder1, int4solveder2, int4solveder3);
        return "1";
    }

}

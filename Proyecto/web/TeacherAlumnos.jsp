<%-- 
    Document   : TeacherGrupo
    Created on : Nov 18, 2017, 8:59:49 PM
    Author     : ZOLUN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<s:url value="/css/main.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="header">
            <h1>Bienvenido Maestro ${sessionScope.username}</h1>
            <h1><a href="Cerrar.action">Logout</a></h1>

            <nav id="nav"> 
                <ul>
                    <li><a href="#">Inicio</a></li>
                        <s:url action="cargarGrupo" var="prueba" >
                            <s:param name="userName" value="userName"/>
                        </s:url>

                    <s:url action="ejercicio" var="prueba2" >
                        <s:param name="userName" value="userName"/>
                    </s:url>
                    <li class="current"><s:a href="%{prueba}">Grupos</s:a></li>
                    <li><s:a href="%{prueba2}">Ejercicios</s:a></li>
                    </ul>
                </nav>  
            </div>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Id Alumno</th>
                        <th scope="col">Nombre del Alumno</th>
                        <th scope="col">Apellido Paterno</th>
                        <th scope="col">Apellido Materno</th>
                        <th scope="col">Ver Alumnos</th>
                    </tr>
                </thead>
                <tbody>
                <s:iterator value="alumnos">
                    <s:url action="calificaAlumno" var="temporalA" >
                        <s:param name="idAlumno" value="%{idUsuario}" />
                        <s:param name="userName" value="userName"/>
                    </s:url>
                    <tr>
                        <td><s:property value="idUsuario"/></td>
                        <td><s:property value="nombre"/></td>
                        <td><s:property value="apPaterno"/></td>
                        <td><s:property value="apMaterno"/></td>
                        <td>
                            <s:a href="%{temporalA}" cssClass="btn btn-danger">Calificar</s:a>
                            </td>
                        </tr>  
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>

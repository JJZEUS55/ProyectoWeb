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
                    <s:url action="InicioProfesor" var="pruebaInicio"></s:url>
                    <li><s:a href="%{pruebaInicio}">Inicio</s:a></li>
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


        <s:form action="cambiarCalificacion">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Id Tarea</th>
                        <th scope="col">Id Alumno</th>
                        <th scope="col">Nombre del Alumno</th>
                        <th scope="col">Apellido Paterno</th>
                        <th scope="col">Apellido Materno</th>
                        <th scope="col">Calificacion</th>
                        <th scope="col">Calificar</th>
                    </tr>
                </thead>
                <tbody>



                    <s:iterator value="listaEjercicios">
                        <tr>
                            <s:form action="/All/cambiarCalificacion">
                                <s:url action="cambiarCalificacion" var="temporalA" >
                                    <s:param name="idTareas" value="%{idTareas}" />
                                </s:url>
                                <td><s:property value="idTareas"/></td>
                                <td><s:property value="usuarios.idUsuario"/></td>
                                <td><s:property value="usuarios.nombre"/></td>
                                <td><s:property value="usuarios.apPaterno"/></td>
                                <td><s:property value="usuarios.apMaterno"/></td>
                                <td><s:textfield value="%{calificacion}" id="txtCalificacion" name="nuevaCalificacion"/></td>
                                
                                <s:hidden value="%{idTareas}" name="idTarea"/>
                                <s:hidden value="%{usuarios.idUsuario}" name="idAlumno"/>
                                <td><s:submit cssClass="btn btn-success" value="Calificar"/></td>
                            </s:form>
                        </tr>   
                    </s:iterator>

                </tbody>
            </table>
        </s:form>

    </body>
</html>


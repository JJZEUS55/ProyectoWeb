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
            <h1>Maestro ${sessionScope.username}</h1>
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
                        <th scope="col">Id Grupo</th>
                        <th scope="col">Nombre del grupo</th>
                        <th scope="col">Ver Alumnos</th>
                    </tr>
                </thead>
                <tbody>
                <s:iterator>
                    <s:url action="getAlumnos" var="temporalA" >
                        <s:param name="idGrupo" value="grupo.idGrupo" />
                        <s:param name="userName" value="userName"/>
                    </s:url>
                    <tr>
                        <td><s:property value="grupo.idGrupo"/></td>
                        <td><s:property value="grupo.nombre"/></td>
                        <td>
                            <s:a href="%{temporalA}" cssClass="btn btn-success">Ver Alumnos</s:a>

                            </td>
                        </tr>  
                </s:iterator>
            </tbody>
        </table>

    </body>
</html>

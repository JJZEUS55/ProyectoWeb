<%-- 
    Document   : AdministradorAlumnos
    Created on : Nov 18, 2017, 11:08:49 PM
    Author     : ZOLUN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <h1>Hello Admin ${sessionScope.username}</h1>
        <h1><a href="Cerrar.action">Logout</a></h1>
        
        <hr>
        <s:url action="cargarGrupos" var="prueba" />
        <s:url action="cargarUsuarios" var="prueba2" />
        <h1><s:a href="%{prueba}">Modificar grupos</s:a></h1>
        <h1><s:a href="%{prueba2}">Modificar usuarios</s:a></h1>
        <hr>
        
        <s:form action="/All/agregarUsuarios">
            <s:textfield name="usernameN" label="Usuario"/>
            <s:textfield name="passwordN" label="Password" />
            <s:select name="tipoN" label="Tipo de usuario" list="{'Alumno','Profesor','Administrador'}" />
            <s:textfield name="nombreN" label="Nombre" />
            <s:textfield name="apellidoPN" label="Apellido Paterno" />
            <s:textfield name="apellidoMN" label="Apellido Materno" />
            <s:submit value="Agregar"/>
        </s:form>
        <h3><s:property value="mensaje" /></h3>
        <br />
        <table border="1">
            <tr>
                <td>IdUsuario</td>
                <td>Usuario</td>
                <td>Tipo</td>
                <td>Nombre</td>
                <td>Apellido Paterno</td>
                <td>Apellido Materno</td>
                <td>Grupo</td>
                <td>Accion</td>
            </tr>
        
            <s:iterator value="lista">
                <s:url action="eliminarUsuario" var="temporalA" >
                    <s:param name="id" value="%{idUsuario}" />
                </s:url>
                <tr>
                    <td>
                        <s:property value="%{idUsuario}" />
                    </td>
                    <td>
                        <s:property value="%{usuario}" />
                    </td>
                    <td>
                        <s:property value="%{tipoUsuario}" />
                    </td>
                    <td>
                        <s:property value="%{nombre}" />
                    </td>
                    <td>
                        <s:property value="%{apPaterno}" />
                    </td>
                    <td>
                        <s:property value="%{apMaterno}" />
                    </td>
                    <td>
                        <s:property value="%{idGrupo}" />
                    </td>
                    <td>Modificar || <s:a href="%{temporalA}">Eliminar</s:a></td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>

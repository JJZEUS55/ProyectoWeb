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
        <h1>Modificar Usuarios</h1>
        <table>
            <tr>
                <td>IdUsuario</td>
                <td>Usuario</td>
                <td>Tipo</td>
                <td>Nombre</td>
                <td>Apellido Paterno</td>
                <td>Apellido Materno</td>
                <td>Grupo</td>
            </tr>
        
            <s:iterator value="lista">
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
                </tr>
            </s:iterator>
        </table>
    </body>
</html>

<%-- 
    Document   : AdministradorGrupos
    Created on : Nov 18, 2017, 8:59:49 PM
    Author     : ZOLUN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Grupos</h1>
        <h1>Hello Admin ${sessionScope.username}</h1>
        <h1><a href="Cerrar.action">Logout</a></h1>
        
        <hr>
        <s:url action="cargarGrupos" var="prueba" />
        <s:url action="cargarUsuarios" var="prueba2" />
        <h1><s:a href="%{prueba}">Modificar grupos</s:a></h1>
        <h1><s:a href="%{prueba2}">Modificar usuarios</s:a></h1>
        <hr>
        <h1>Nuevo Grupo</h1>
        <s:form action="/All/agregarGrupo">
            <s:textfield name="NombreGrupo" label="Nombre del grupo" />
            <s:submit value="Agregar" />
        </s:form>
        <h3><s:property value="mensaje"/></h3>
        <hr/>
        <table>
            <tr>
                <td>Identificador Grupo</td>
                <td>Nombre del grupo</td>
                <td>Accion</td>
            </tr>
            
            <s:iterator value="lista">
                <s:url action="modificarGrupo" var="temporalA" >
                    <s:param name="id" value="%{idGrupo}" />
                </s:url>
                <s:url action="eliminarGrupo" var="temporalB" >
                    <s:param name="id" value="%{idGrupo}" />
                </s:url>
                <tr>
                    <td><s:property value="idGrupo"/></td>
                    <td><s:property value="nombre"/></td>
                    <td>
                        <s:a href="%{temporalA}">modificar</s:a> ||
                        <s:a href="%{temporalB}">eliminar</s:a>
                    </td>
                </tr>  
            </s:iterator>
        </table>
    </body>
</html>

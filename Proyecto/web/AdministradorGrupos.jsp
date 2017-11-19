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

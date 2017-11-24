<%-- 
    Document   : AdministradorAlumnos
    Created on : Nov 18, 2017, 11:08:49 PM
    Author     : ZOLUN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="/struts-dojo-tags" prefix="sx"%>
<html>
    <sx:head/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Usuarios</title>
        
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
        
        <s:form action="/All/agregarUsuarios" >
            <s:textfield name="usernameN" label="Usuario"/>
            <s:textfield name="passwordN" label="Password" />
            <s:select name="tipoN" label="Tipo de usuario" list="{'Alumno','Profesor','Administrador'}" />
            <s:textfield name="nombreN" label="Nombre" />
            <s:textfield name="apellidoPN" label="Apellido Paterno" />
            <s:textfield name="apellidoMN" label="Apellido Materno" />
            <sx:autocompleter size="1" name="grupoN" list = "Grupos" showDownArrow="false" label="Grupo"/>
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
                        <s:property value="%{Grupo.Nombre}" />
                    </td>
                    <td> <s:a href="%{temporalA}">Eliminar</s:a></td>
                </tr>               
                <tr>
                    <s:form theme="simple">
                        <td>
                            <s:hidden name="iduserMod" value="%{idUsuario}" />
                        </td>
                        <td>
                            <s:textfield name="usuarioMod" value="%{usuario}" />
                        </td>
                        <td>
                            <s:textfield name="tipoUsuarioMod" value="%{tipoUsuario}" />
                        </td>
                        <td>
                            <s:textfield name="nombreMod" value="%{nombre}" />
                        </td>
                        <td>
                            <s:textfield name="apPaternoMod" value="%{apPaterno}" />
                        </td>
                        <td>
                            <s:textfield name="apMaternoMod" value="%{apMaterno}" />
                        </td>
                        <td>
                            <sx:autocompleter  value="%{Grupo.Nombre}" size="1" name="idGrupoMod" list = "Grupos" showDownArrow="false"></sx:autocompleter>
                        </td>
                        <td>
                            <s:submit value="modificar" />
                        </td>
                    </s:form>
                </tr>
                
            </s:iterator>
        </table>
    </body>
</html>

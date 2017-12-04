<%-- 
    Document   : AdministradorGruposMod
    Created on : Nov 30, 2017, 10:47:02 PM
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
        
        <s:label value="Grupo   :%{NombreGrupoMod}" />
        <br>
        <s:label value="Profesor:%{ProfesorGrupoMod}" />
        <br>
        <s:form theme="simple" action="/All/CambiarProfesorGrupo">
            <s:hidden name="idGrupo" value="%{idGrupo}" />
      
            <s:select label="Profesores Disponbles" name="profesorM" list="ProfesoresSinGrupo.{idUsuario+': '+nombre+' '+apPaterno+' '+apMaterno}" value="%{idUsuario}" />
            <s:submit value="Cambiar profesor" />
        </s:form>
        <s:property value="mensaje" />
        <br>
        <br>
        <br>
        <!--
        <s:combobox label="Alumnos" headerKey="-1" headerValue="----" list="Usuarios.{usuario}" name="alumnos" />
        <s:checkboxlist label="Alumnos Inscritos" list="Usuarios.{usuario +' '+ nombre}" name="check" />
        <s:radio label="Alumnos" name="radio" list="Usuarios.{usuario}" />
        -->
        <br>
        <br><br><br><br>
        <p>Alumnos Inscritos</p>
        <table border="1">
            <tr>
                <td>Nombre</td>
                <td>Usuario</td>
                <td>Eliminar</td>
            </tr>
            <s:iterator value="Usuarios">
  
                    <tr>
                        <td>
                            <s:property value="%{nombre+' '+apPaterno+' '+apMaterno}" />
                        </td>
                        <td>
                            <s:property value="%{usuario}" />
                        </td>
                        <td>
                            <s:form theme="simple" action="/All/CambiarUsuariodeGrupo">
                                <s:hidden value="%{idUsuario}" name="user" />
                                <s:hidden value="%{idGrupo}" name="idGrupo" />
                                <s:hidden value="1" name="grupoC" />
                                <s:submit value="Eliminar" />
                            </s:form>
                        </td>
                    </tr>

            </s:iterator>        
        </table>
        <br><br><br><br>
        <p>Agregar Alumnos</p>
        <table border="1">
            <tr>
                <td>Nombre</td>
                <td>Usuario</td>
                <td>Agregar</td>
            </tr>
            <s:iterator value="UsuariosSinGrupo">
  
                    <tr>
                        <td>
                            <s:property value="%{nombre+' '+apPaterno+' '+apMaterno}" />
                        </td>
                        <td>
                            <s:property value="%{usuario}" />
                        </td>
                        <td>
                            <s:form theme="simple" action="/All/CambiarUsuariodeGrupo" >
                                <s:hidden value="%{idUsuario}" name="user" />
                                <s:hidden value="%{idGrupo}" name="grupoC" />
                                <s:hidden value="%{idGrupo}" name="idGrupo" />
                                <s:submit value="Agregar" />
                            </s:form>
                        </td>
                    </tr>

            </s:iterator>        
        </table>
        
    </body>
</html>

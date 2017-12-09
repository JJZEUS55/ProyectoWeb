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
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<s:url value="/css/main.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="header">
            <h1>Bienvenido Admin ${sessionScope.username}</h1>
            <h1><a href="Cerrar.action">Logout</a></h1>

            <nav id="nav"> 
                <ul>
                    <li><a href="#">Inicio</a></li>
                    <li><s:url action="cargarGrupos" var="prueba" >Cargar Grupos</s:url></li>
                    <li><s:url action="cargarUsuarios" var="prueba2" >Cargar Usuarios</s:url></li>
                    <li class="current"><s:a href="%{prueba}">Modificar grupos</s:a></li>
                    <li><s:a href="%{prueba2}">Modificar usuarios</s:a></li>
                </ul>
            </nav>
        </div>
                
  
        
        
        <div class="container">
            
            <s:label value="Grupo seleccionado: %{NombreGrupoMod}" />
            <br>
            <s:label value="Profesor del grupo: %{ProfesorGrupoMod}" />
            <br>
            <s:form theme="simple" action="/All/CambiarProfesorGrupo">
                <s:hidden name="idGrupo" value="%{idGrupo}" />

                <s:select label="Profesores Disponbles" name="profesorM" list="ProfesoresSinGrupo.{idUsuario+': '+nombre+' '+apPaterno+' '+apMaterno}" value="%{idUsuario}" />
                <s:submit value="Cambiar profesor" />
            </s:form>
            <s:property value="mensaje" />
            <hr>
            <br><br>
            <div class="row">
                <div class="col-sm-6">
                    <p>Alumnos Inscritos</p>
                    <table border="1" class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Usuario</th>
                                <th scope="col">Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
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
                                        <s:submit value="Eliminar" cssClass="btn btn-danger"/>
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-6">
                    <p>Agregar Alumnos</p>
                    <table border="1" class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Usuario</th>
                                <th scope="col">Agregar</th>
                            </tr>
                        </thead>
                        <tbody>
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
                                            <s:submit value="Agregar" cssClass="btn btn-success" />
                                        </s:form>
                                    </td>
                                </tr>  
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>

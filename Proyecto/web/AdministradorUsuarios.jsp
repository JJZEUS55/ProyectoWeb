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
        <link href="<s:url value="/css/main.css"/>" rel="stylesheet">
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Usuarios</title>

    </head>
    <body>
        <div id="header">
            <h1>Bienvenido Admin ${sessionScope.username}</h1>
            <h2><a href="Cerrar.action">Cerrar Sesion</a></h2>

            <nav id="nav"> 
                <ul>
                    <s:url action="cargarUsuarios" var="prueba2" ></s:url>
                    <s:url action="cargarGrupos" var="prueba" ></s:url>
                    <s:url action="InicioAdmin" var="prueba3" ></s:url>
                    <li><s:a href="%{prueba3}">Inicio</s:a></li>
                    <li><s:a href="%{prueba}">Modificar grupos</s:a></li>
                    <li class="current"><s:a href="%{prueba2}">Modificar usuarios</s:a></li>
                    </ul>
                </nav>
            </div>
            
            
            <div class="container">
                <h2>Nuevo usuario</h2>
            <s:form action="/All/agregarUsuarios" theme="simple" >
                <div class="form-group">
                    <div class="form-row">
                        <div class="col">
                            <s:textfield name="usernameN" placeholder="Usuario" cssClass="form-control"/>
                        </div>
                        <div class="col">
                            <s:textfield name="passwordN" placeholder="Password" cssClass="form-control" />
                        </div>
                    </div>
                </div>
                <div class="form-group" >
                    <div class="form-row">
                        <div class="col">
                            <s:textfield name="nombreN" placeholder="Nombre" cssClass="form-control"/>
                        </div>
                        <div class="col">
                            <s:textfield name="apellidoPN" placeholder="Apellido Paterno" cssClass="form-control"/>
                        </div>
                        <div class="col">
                            <s:textfield name="apellidoMN" placeholder="Apellido Materno"  cssClass="form-control"/>
                        </div>
                    </div>
                </div>
                <div class="form-row">

                    <div class="col">
                        <sx:autocompleter size="1" name="grupoN" list = "Grupos" showDownArrow="false" cssClass="form-control" />
                    </div>


                </div>
                <div class="form-group">
                    <!--<s:select name="tipoN" list="{'Alumno','Profesor','Administrador'}" theme="simple" cssClass="custom-select d-block my-3"/>-->
                    <s:radio name="tipoN" list="{'Alumno','Profesor','Administrador'}" value="DefaultTipo" cssClass="radio" />
                </div>
                <div class="form-row">
                    <div class="col">
                        <s:submit value="Agregar" cssClass="btn btn-danger"/>
                    </div>
                </div>
            </s:form>
        </div>
            
        <br>
        
        <br>
        <div class="container">
            <div class="alert alert-info">
                <s:property value="mensaje"/>
            </div>
        </div>
        
        <br>
        <br />
        <div class="container">
            <s:form theme="simple" action="/All/Busqueda">
                <div class="form-group">
                    <div class="form-row">
                        <div class="col">
                            <s:textfield name="Buscar" placeholder="...." cssClass="form-control"/>
                        </div>
                        <div class="col">
                            <s:submit value="Buscar" cssClass="btn btn-primary"/>
                        </div>
                    </div>
                </div>
            </s:form>
        </div>
        <br>
        <table border="1" class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">IdUsuario</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Tipo</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido Paterno</th>
                    <th scope="col">Apellido Materno</th>
                    <th scope="col">Grupo</th>
                    <th scope="col">Accion</th>
                </tr>
            </thead>
            <tbody>
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
                        <td rowspan="2">
                            <s:property value="%{Grupo.Nombre}" />
                        </td>
                        <td> <s:a href="%{temporalA}" cssClass="btn btn-primary">Eliminar</s:a></td>
                        </tr>               
                        <tr>
                        <s:form theme="simple" action="/All/modificarUsuario">
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
                                <s:hidden name="grupoMod" value="%{Grupo.Nombre}" />
                                <s:submit value="Modificar" cssClass="btn btn-default"/>
                            </td>
                        </s:form>
                    </tr>

                </s:iterator>
            </tbody>
        </table>
    </body>
</html>

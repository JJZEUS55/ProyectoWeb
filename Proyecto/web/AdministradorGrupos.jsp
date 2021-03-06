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
        <link href="<s:url value="/css/main.css"/>" rel="stylesheet">
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grupos</title>
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
                    <li class="current"><s:a href="%{prueba}">Modificar grupos</s:a></li>
                    <li><s:a href="%{prueba2}">Modificar usuarios</s:a></li>
                </ul>
            </nav>
        </div>

        <div class="container">
            <h2>Nuevo Grupo</h2>
            <s:form action="/All/agregarGrupo" theme="simple">
                <div class="form-group">
                    <div class="form-row">
                        <div class="col">
                            <s:textfield name="NombreGrupo" placeholder="Nombre del grupo" cssClass="form-control"/>
                    
                        </div>
                        <div class="col">
                            <s:submit value="Agregar" cssClass="btn"/>
                        </div>
                    </div>
                    
                </div>
            </s:form>

        </div>
        <br>
        <div class="container">
            <div class="alert alert-info">
                <s:property value="mensaje"/>
            </div>
        </div>
        <br>
        <s:iterator value="Usuarios">
                <s:property value="usuario"></s:property>
        </s:iterator>
        <hr/>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">Id Grupo</th>
                    <th scope="col">Nombre del grupo</th>
                    <th scope="col">Accion</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="lista">
                    <s:url action="modificarGrupo" var="temporalA" >
                        <s:param name="idGrupo" value="%{idGrupo}" />
                    </s:url>
                    <s:url action="eliminarGrupo" var="temporalB" >
                        <s:param name="idGrupo" value="%{idGrupo}" />
                    </s:url>
                    <tr>
                        <td><s:property value="idGrupo"/></td>
                        <td><s:property value="nombre"/></td>
                        <td>
                            <s:a href="%{temporalA}" cssClass="btn btn-success">modificar</s:a>
                            <s:a href="%{temporalB}" cssClass="btn btn-danger">eliminar</s:a>
                        </td>
                    </tr>  
                </s:iterator>
            </tbody>
        </table>
    </body>
</html>

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
        <h1>Grupos</h1>
        <div class="container">
            <h2>Nuevo Grupo</h2>
            <s:form action="/All/agregarGrupo" theme="simple">
                <div class="form-group">
                    <s:textfield name="NombreGrupo" placeholder="Nombre del grupo" cssClass="form-control"/>
                    <s:submit value="Agregar" cssClass="btn"/>
                </div>
            </s:form>

        </div>
        <br>
        <h3><s:property value="mensaje"/></h3>
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

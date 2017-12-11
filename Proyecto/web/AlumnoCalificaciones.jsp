<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>  
    <head>
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<s:url value="/css/main.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
    </head>
    <body>
        <div id="header">
            <h1>Bienvenido Estudiante ${sessionScope.username}</h1>
            <h2><a href="Cerrar.action">Cerrar Sesion</a></h2>

            <nav id="nav"> 
                <ul>
                    <s:url action="InicioAlumno" var="prueba3"></s:url>
                    <li><s:a href="%{prueba3}">Inicio</s:a></li>
                        <s:url action="obtenerTarea" var="prueba" >
                            <s:param name="usuario" value="username"/>
                        </s:url>

                    <s:url action="obtenerTarea" var="prueba2" >
                        <s:param name="usuario" value="username"/>
                        <s:param name="idAlumno" value="idUsuario"/>
                    </s:url>
                    <li><s:a href="%{prueba}">Calificaciones</s:a></li>
                    <li  class="current"><s:a href="%{prueba2}">Ejercicio</s:a></li>
                    </ul>
                </nav>                
            </div>
            <table>
                <tr>
                    <td>
                        Nombre
                    </td>
                    <td>
                        Apellido Paterno
                    </td>
                    <td>
                        Apellido Materno
                    </td>
                    <td>
                        Calificacion
                    </td>
                </tr>
            <s:iterator value="listaCalificaciones">
                <tr>
                    <td>
                        <s:property value="%{Usuarios.nombre}"/>
                    </td>
                    <td>
                        <s:property value="%{idCalificacion}"/>
                    </td>
                    <td>
                        <s:property value="%{calificacion}"/>
                    </td>                    
                </tr>
            </s:iterator>
        </table>
    </body>
</html>

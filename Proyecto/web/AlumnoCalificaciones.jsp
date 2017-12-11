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
                    <s:url action="InicioAlumno" var="prueba3">
                        <s:param name="usuario" value="usuario"/>                        
                    </s:url>
                    <li><s:a href="%{prueba3}">Inicio</s:a></li>
                        <s:url action="cargarCalificaciones" var="prueba" >
                            <s:param name="usuario" value="usuario"/>
                        </s:url>

                    <s:url action="obtenerTareas" var="prueba2" >
                        <s:param name="usuario" value="usuario"/>
                        <s:param name="idAlumno" value="idUsuario"/>
                    </s:url>
                    <li  class="current"><s:a href="%{prueba}">Calificaciones</s:a></li>
                    <li><s:a href="%{prueba2}">Ejercicio</s:a></li>
                    </ul>
                </nav>                
            </div>
            <h1>Ejercicios Calificados</h1>
            <table>
                <tr>
                    <td>
                        Id Ejercicio
                    </td>
                    <td>
                        Calificacion
                    </td>                   
                </tr>
            <s:iterator value="listaCalificaciones">
                <tr>
                    <td>
                        <s:property value="idTareas"/>
                    </td>
                    <td>
                        <s:property value="calificacion"/>
                    </td>                              
                </tr>
            </s:iterator>
        </table>


        <h1>Ejercicios No Calificados</h1>
        <table>
            <tr>
                <td>
                    Id Ejercicio
                </td>
                <td>
                    Calificacion
                </td>                   
            </tr>
            <s:iterator value="listaNoCalificados">
                <tr>
                    <td>
                        <s:property value="idTareas"/>
                    </td>
                    <td>
                        <s:property value="calificacion"/>
                    </td>                              
                </tr>
            </s:iterator>
        </table>
    </body>
</html>

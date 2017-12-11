<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>  
    <head>
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<s:url value="/css/main.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
        <style>
            canvas {
                border:1px solid black;
            }
        </style>
        <script type="text/javascript" src="${pageContext.request.contextPath}/fabric.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Juego.js"></script>

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
                    <li><s:a href="%{prueba}">Calificaciones</s:a></li>
                    <li  class="current"><s:a href="%{prueba2}">Ejercicio</s:a></li>
                    </ul>
                </nav>                
            </div>


            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Id Tarea</th>
                        <th scope="col">Nombre del Alumno</th>
                        <th scope="col">Apellido Paterno</th>
                        <th scope="col">Apellido Materno</th>
                        <th scope="col">Ver Ejercicio</th>
                    </tr>
                </thead>
                <tbody>
                <s:iterator value="listaTareas">
                    <s:url action="obtenerTarea" var="temporalA" >
                        <s:param name="idAlumno" value="%{idUsuario}" />
                        <s:param name="userName" value="userName"/>
                        <s:param name="idTarea" value="%{idTareas}"/>
                        <s:param name="usuario" value="%{usuarios.usuario}"/>
                    </s:url>
                    <tr>
                        <td><s:property value="idTareas"/></td>
                        <td><s:property value="usuarios.nombre"/></td>
                        <td><s:property value="usuarios.apPaterno"/></td>
                        <td><s:property value="usuarios.apMaterno"/></td>
                        <td>
                            <s:a href="%{temporalA}" cssClass="btn btn-danger">Ver ejercicio</s:a>
                            </td>
                        </tr>  
                </s:iterator>
            </tbody>
        </table>



    </body>
</html>

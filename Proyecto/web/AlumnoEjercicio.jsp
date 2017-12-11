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
                    <li class="current"><s:a href="%{prueba3}">Inicio</s:a></li>
                        <s:url action="cargarGrupo" var="prueba" >
                            <s:param name="usuario" value="usuario"/>
                        </s:url>

                    <s:url action="ejercicio" var="prueba2" >
                        <s:param name="usuario" value="usuario"/>
                        <s:param name="idAlumno" value="idUsuario"/>
                    </s:url>
                    <li><s:a href="%{prueba}">Ejercicios</s:a></li>
                    <li><s:a href="%{prueba2}">Calificaciones</s:a></li>
                    </ul>
                </nav>                
            </div>


            <div>
                idTareas<s:property value="tarea.idTareas"/><br/>
            idUsuario<s:property value="tarea.usuarios.idUsuario"/><br/>
            Calificacion<s:property value="tarea.calificacion"/><br/>
            in1solveiz1<s:property value="tarea.int1solveiz1"/><br/>



        </div>




    </body>
</html>
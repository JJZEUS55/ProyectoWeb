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
            <h1><a href="Cerrar.action">Logout</a></h1>

            <nav id="nav"> 
                <ul>
                    <s:url action="Iniciar" var="pruebaInicio">
                        <s:param name="userName" value="username"/> 
                    </s:url>
                    <li class="current"><s:a href="%{pruebaInicio}">Inicio</s:a></li>
                        <s:url action="cargarGrupo" var="prueba" >
                            <s:param name="userName" value="username"/>
                        </s:url>

                    <s:url action="ejercicio" var="prueba2" >
                        <s:param name="userName" value="username"/>
                    </s:url>
                    <li><s:a href="%{prueba}">Ejercicios</s:a></li>
                    <li><s:a href="%{prueba2}">Calificaciones</s:a></li>
                    </ul>
                </nav>                
            </div>
    </body>
</html>

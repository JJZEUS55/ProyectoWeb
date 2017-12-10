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
            <h1>Maestro ${sessionScope.username}</h1>
            <h1><a href="Cerrar.action">Logout</a></h1>

            <nav id="nav"> 
                <ul>
                    <li><a href="#">Inicio</a></li>
                    <s:url action="cargarGrupo" var="prueba" >
                        <s:param name="userName" value="userName"/>
                    </s:url>
                    <s:url action="ejercicio" var="prueba2" >
                            <s:param name="userName" value="userName"/>
                        </s:url>
                    <li><s:a href="%{prueba}">Grupos</s:a></li>
                    <li class="current"><s:a href="%{prueba2}">Ejercicios</s:a></li>
                </ul>
            </nav>  
        </div>
                <h1>INSETAR LA MAGIC COCINERO PLOX :'V</h1>
    </body>
</html>

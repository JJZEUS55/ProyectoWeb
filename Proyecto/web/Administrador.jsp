<%-- 
    Document   : Administrador
    Created on : Nov 18, 2017, 4:32:59 PM
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
        <title>Bienvenido</title>
    </head>
    <body>
        <div id="header">
            <h1>Bienvenido Admin ${sessionScope.username}</h1>
            <h1><a href="Cerrar.action">Logout</a></h1>

            <nav id="nav"> 
                <ul>
                    <s:url action="cargarUsuarios" var="prueba2" ></s:url>
                    <s:url action="cargarGrupos" var="prueba" ></s:url>
                    <li class="current"><a href="#">Inicio</a></li>
                    <li><s:a href="%{prueba}">Modificar grupos</s:a></li>
                    <li><s:a href="%{prueba2}">Modificar usuarios</s:a></li>
                </ul>
            </nav>
        </div>


        <hr>


    </body>
</html>

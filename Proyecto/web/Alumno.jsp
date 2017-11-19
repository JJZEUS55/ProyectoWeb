<%-- 
    Document   : Alumno
    Created on : Nov 18, 2017, 4:32:35 PM
    Author     : ZOLUN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Student ${sessionScope.username}</h1>
        <h1><a href="Cerrar.action">Logout</a></h1>
    </body>
</html>

<%-- 
    Document   : AdministradorAlumnos
    Created on : Nov 18, 2017, 11:08:49 PM
    Author     : ZOLUN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <s:iterator value="lista">
            <s:property value="%{usuario}" />
            <br />
        </s:iterator>
    </body>
</html>

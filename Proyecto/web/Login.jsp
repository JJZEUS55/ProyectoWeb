<%-- 
    Document   : Login
    Created on : Nov 18, 2017, 3:52:46 PM
    Author     : ZOLUN
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form action="/InicioSesion/Iniciar">
            <s:textfield name="username" />
            <s:password name="password" />
            <s:submit />
        </s:form>
    </body>
</html>

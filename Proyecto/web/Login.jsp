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
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Inicio sesion</title>
    </head>
    <body>
        <s:form action="/All/Iniciar" cssClass="well form-search">
            <s:textfield name="username" placeholder="username"/>
            <s:password name="password" placeholder="password"/>
            <s:submit value="Iniciar"/>
        </s:form>
        <h1><s:property value="mensaje"/></h1>
    </body>
</html>

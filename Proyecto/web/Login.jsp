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
        <link href="<s:url value="/css/fontA/css/font-awesome.min.css"/>" rel="stylesheet">        
        
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        
        <link href="<s:url value="/css/main.css"/>" rel="stylesheet">       

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Inicio sesion</title>
    </head>
    <body>
        
        <div class="cajaInicio">
            <h2>Inicio de Sesion</h1>

                <s:form action="/All/Iniciar" cssClass="well form-search">
                    <div class="txt1">
                        <span class="fa fa-user" aria-hidden="true">                      
                            <s:textfield id="txtUsuario"  name="username" placeholder="Usuario"/>  
                        </span>
                    </div>
                    <div class="txt2">
                        <i class="fa fa-key">
                            <s:password id="txtPass" name="password" placeholder="Contraseña"/>
                        </i>
                    </div>
                    <s:submit id="btnEntrar" value="Iniciar"/>
                </s:form>
                <div class="alert alert-info">
                    <s:property value="mensaje"/>
                </div>
        </div>
        
        
    </body>
</html>

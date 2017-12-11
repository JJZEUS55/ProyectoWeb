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

        <link href="<s:url value="/css/Inicio.css"/>" rel="stylesheet">       

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Inicio sesion</title>
    </head>
    <body>
        <div class="todoInicio">

            <div class="cajaInicio">
                <h2>Inicio de Sesion</h2>

                <s:form action="/All/Iniciar" >
                    <div class="">
                        <!--                    <span class="fa fa-user" aria-hidden="true"></span>  -->
                        <s:textfield type="text" cssClass="txtUsuario" id="txtUsuario"  name="username" placeholder="Usuario"/>

                    </div>
                    <div class="">
                        <!--                    <span class="fa fa-key"></span>-->
                        <s:password id="txtPass" name="password" placeholder="Contraseña"/>
                    </div>
                    <s:submit id="btnEntrar" value="Iniciar"/>
                </s:form>
                <div class="alert alert-info">
                    <s:property value="mensaje"/>
                </div>
            </div>

        </div>

    </body>
</html>

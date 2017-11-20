<%@taglib  uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificarse Alumno ${sessionScope.username}</h1>
        <s:form action="modificarAlumno">
            <s:textfield name="usuario" value="%{}"/>
            <s:textfield name="password" value="%{}"/>
            <s:submit value="Guardar"/>
        </s:form>
    </body>
</html>

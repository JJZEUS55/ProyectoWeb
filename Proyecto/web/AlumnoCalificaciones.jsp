<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Calificaciones Alumno ${sessionScope.username}</h1>
        <table>
            <tr>
                <td>
                    Maestro
                </td>
                <td>
                    Ejercicio
                </td>
                <td>
                    Calificacion
                </td>
            </tr>
            <s:iterator value="listaCalificaciones">
                <tr>
                    <td>
                        <s:property value="%{Usuarios.nombre}"/>
                    </td>
                    <td>
                        <s:property value="%{idCalificacion}"/>
                    </td>
                    <td>
                        <s:property value="%{calificacion}"/>
                    </td>                    
                </tr>
            </s:iterator>
        </table>
    </body>
</html>

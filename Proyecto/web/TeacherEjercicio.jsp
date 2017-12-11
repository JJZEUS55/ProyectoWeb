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
                    <s:url action="InicioProfesor" var="pruebaInicio"></s:url>
                    <li><s:a href="%{pruebaInicio}">Inicio</s:a></li>
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

            <div>
                <h1>INSETAR LA MAGIC COCINERO PLOX :'V</h1><br/>
            <s:form action="/All/addEjercicio" theme="simple" >

                <h3>Id Alumno</h3><s:textfield name="idAlumno" cssClass="form-control"/><br/>
                <h3>Calificacion</h3><s:textfield name="calificacion" cssClass="form-control"/><br/>

                <h1>INTERFAZ 1</h1><br/>
                <h3>int1solveiz1</h3><s:textfield name="int1solveiz1" cssClass="form-control"/><br/>
                <h3>int1solveiz2</h3><s:textfield name="int1solveiz2" cssClass="form-control"/><br/>
                <h3>int1solveiz3</h3><s:textfield name="int1solveiz3" cssClass="form-control"/><br/>
                <h3>int1solveder1</h3><s:textfield name="int1solveder1" cssClass="form-control"/><br/>
                <h3>int1solveder2</h3><s:textfield name="int1solveder2" cssClass="form-control"/><br/>
                <h3>int1solveder3</h3><s:textfield name="int1solveder3" cssClass="form-control"/><br/>

                <h1>INTERFAZ 2</h1><br/>
                <h3>int2solveiz1</h3><s:textfield name="int2solveiz1" cssClass="form-control"/><br/>
                <h3>int2solveiz2</h3><s:textfield name="int2solveiz2" cssClass="form-control"/><br/>
                <h3>int2solveiz3</h3><s:textfield name="int2solveiz3" cssClass="form-control"/><br/>
                <h3>int2solveder1</h3><s:textfield name="int2solveder1" cssClass="form-control"/><br/>
                <h3>int2solveder2</h3><s:textfield name="int2solveder2" cssClass="form-control"/><br/>
                <h3>int2solveder3</h3><s:textfield name="int2solveder3" cssClass="form-control"/><br/>


                <h1>INTERFAZ 3</h1><br/>
                <h3>int3solveiz1</h3><s:textfield name="int3solveiz1" cssClass="form-control"/><br/>
                <h3>int3solveiz2</h3><s:textfield name="int3solveiz2" cssClass="form-control"/><br/>
                <h3>int3solveiz3</h3><s:textfield name="int3solveiz3" cssClass="form-control"/><br/>
                <h3>int3solveder1</h3><s:textfield name="int3solveder1" cssClass="form-control"/><br/>
                <h3>int3solveder2</h3><s:textfield name="int3solveder2" cssClass="form-control"/><br/>
                <h3>int3solveder3</h3><s:textfield name="int3solveder3" cssClass="form-control"/><br/>


                <h1>INTERFAZ 4</h1><br/>
                <h3>int4solveiz1</h3><s:textfield name="int4solveiz1" cssClass="form-control"/><br/>
                <h3>int4solveiz2</h3><s:textfield name="int4solveiz2" cssClass="form-control"/><br/>
                <h3>int4solveiz3</h3><s:textfield name="int4solveiz3" cssClass="form-control"/><br/>
                <h3>int4solveder1</h3><s:textfield name="int4solveder1" cssClass="form-control"/><br/>
                <h3>int4solveder2</h3><s:textfield name="int4solveder2" cssClass="form-control"/><br/>
                <h3>int4solveder3</h3><s:textfield name="int4solveder3" cssClass="form-control"/><br/>


                <s:submit value="Agregar" cssClass="btn btn-danger"/>
            </s:form>



        </div>

    </body>
</html>

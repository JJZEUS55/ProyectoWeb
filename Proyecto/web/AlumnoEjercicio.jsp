<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>  
    <head>
        <link href="<s:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
        <link href="<s:url value="/css/main.css"/>" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido</title>
        <style>
            canvas {
                border:1px solid black;
            }
        </style>
        <script type="text/javascript" src="${pageContext.request.contextPath}/fabric.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/Juego.js"></script>

    </head>
    <body>
        <div id="header">
            <h1>Bienvenido Estudiante ${sessionScope.username}</h1>
            <h2><a href="Cerrar.action">Cerrar Sesion</a></h2>

            <nav id="nav"> 
                <ul>
                    <s:url action="InicioAlumno" var="prueba3"></s:url>
                    <li class="current"><s:a href="%{prueba3}">Inicio</s:a></li>
                        <s:url action="obtenerTarea" var="prueba" >
                            <s:param name="usuario" value="username"/>
                        </s:url>

                    <s:url action="obtenerTarea" var="prueba2" >
                        <s:param name="usuario" value="username"/>
                        <s:param name="idAlumno" value="idUsuario"/>
                    </s:url>
                    <li><s:a href="%{prueba}">Calificaciones</s:a></li>
                    <li><s:a href="%{prueba2}">Ejercicio</s:a></li>
                    </ul>
                </nav>                
            </div>

            <div>
                <h2>Obteniedo los datos</h2>

                <input type="text" value="0" id="Cont">
                <input type="text" value="0" id="Cont2">
                <input type="text" value="0" id="Cont3">

                <canvas id="c" width="600" height="400" >

                </canvas>
            <s:textarea id="log" value=""></s:textarea>

            <s:form action="/All/obtenerResultado" theme="simple">
                <h2>Resultado 1</h2><s:textfield id="res1" name="res1" readonly="true"></s:textfield>
                <h2>Resultado 2</h2><s:textfield id="res2" name="res2" readonly="true"></s:textfield>
                <h2>Resultado 3</h2><s:textfield id="res3" name="res3" readonly="true"></s:textfield>
                <h2>Resultado 4</h2><s:textfield id="res4" name="res4" readonly="true"></s:textfield>
                <s:hidden name="usuario" value="%{tarea.usuarios.usuario}"></s:hidden>
                <s:hidden name="idTarea" value="%{tarea.idTareas}"></s:hidden>
                <s:submit value="Enviar Resultados"/>
            </s:form>
            <!--INTERFAZ 1-->
            <s:hidden id="SolveIz1" value="%{tarea.int1solveiz1}"></s:hidden>
            <s:hidden id="SolveIz2" value="%{tarea.int1solveiz2}"></s:hidden>
            <s:hidden id="SolveIz3" value="%{tarea.int1solveiz3}"></s:hidden>
            <s:hidden id="SolveDe1" value="%{tarea.int1solveder1}"></s:hidden>
            <s:hidden id="SolveDe2" value="%{tarea.int1solveder2}"></s:hidden>
            <s:hidden id="SolveDe3" value="%{tarea.int1solveder3}"></s:hidden>

                <!--INTERFAZ 2-->
            <s:hidden id="SubsDe1" value="%{tarea.int2solveiz1}"></s:hidden>
            <s:hidden id="SubsAb1" value="%{tarea.int2solveiz2}"></s:hidden>
            <s:hidden id="SubsAb2" value="%{tarea.int2solveiz3}"></s:hidden>
            <s:hidden id="SubsAb3" value="%{tarea.int2solveder1}"></s:hidden>
            
            
            
            <s:hidden id="ExpI0" value="%{tarea.int2solveder2}"></s:hidden>
            <s:hidden id="ExpI1" value="%{tarea.int2solveder3}"></s:hidden>
            <s:hidden id="ExpS0" value="%{tarea.int3solveiz1}"></s:hidden>
            <s:hidden id="ExpS1" value="%{tarea.int3solveiz2}"></s:hidden>
            
            
            <s:hidden id="FacI0" value="%{tarea.int3solveiz3}"></s:hidden>
            <s:hidden id="FacI1" value="%{tarea.int3solveder1}"></s:hidden>
            <s:hidden id="FacS0" value="%{tarea.int3solveder2}"></s:hidden>
            <s:hidden id="FacS1" value="%{tarea.int3solveder3}"></s:hidden>

                <!--INTERFAZ 4-->
            <s:hidden id="int4solveiz1" value="%{tarea.int4solveiz1}"></s:hidden>
            <s:hidden id="int4solveiz2" value="%{tarea.int4solveiz2}"></s:hidden>
            <s:hidden id="int4solveiz3" value="%{tarea.int4solveiz3}"></s:hidden>
            <s:hidden id="int4solveder1" value="%{tarea.int4solveder1}"></s:hidden>
            <s:hidden id="int4solveder2" value="%{tarea.int4solveder2}"></s:hidden>
            <s:hidden id="int4solveder3" value="%{tarea.int4solveder3}"></s:hidden>
            
            
            <!--RECURSOSALUMNO-->
            


            </div>


            <div>
                idTareas<s:property value="tarea.idTareas"/><br/>
            idUsuario<s:property value="tarea.usuarios.idUsuario"/><br/>
            Calificacion<s:property value="tarea.calificacion"/><br/>
            in1solveiz1<s:property value="tarea.int1solveiz1"/><br/>



        </div>


        <script>
            var canvas = this.__canvas = new fabric.Canvas('c');
            fabric.Object.prototype.transparentCorners = false;
            inicio(canvas);

        </script>

    </body>
</html>

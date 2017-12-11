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
                <h1>Nuevo ejercicio</h1><br/>
                
                <div class="container">
                    <s:form action="/All/addEjercicio" theme="simple" >
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-1">
                                    <label>ID:</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="idAlumno" cssClass="form-control"/>
                                </div>
                            </div>
                        </div>
                        <s:hidden name="calificacion" value="0" cssClass="form-control"/><br/>
                        
                        <div class="form-group">
                            <h1>Solve</h1>
                            <div class="form-row">
                                <div class="col-1">
                                    <label>X^2 +</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int1solveiz3" cssClass="form-control"/> 
                                </div>
                            </div>                               
                            <div class="form-row">
                                <div class="col-1">
                                    <label>X +</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int1solveiz2" cssClass="form-control"/>
                                </div>
                            </div>                            
                            <div class="form-row">
                                <div class="col-1">
                                    <label>=</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int1solveiz1" cssClass="form-control"/> 
                            
                                </div>
                            </div>                               
                            <div class="form-row">
                                <div class="col-1">
                                    <label>X^2 +</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int1solveder1" cssClass="form-control"/>
                                </div>
                            </div>                           
                             <div class="form-row">
                                <div class="col-1">
                                    <label>X +</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int1solveder2" cssClass="form-control"/>
                                </div>
                            </div>                           
                            <div class="form-row">
                                <div class="col-1">
                                    <label>cosa</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int1solveder3" cssClass="form-control"/>
                                </div>
                            </div>                              
                        </div>
                                
                        <hr>
                        
                        <div class="form-group">
                            <h1>Substituir</h1>
                            <div class="form-row">
                                <div class="col-1">
                                    <label>X=</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int2solveiz1" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-1">
                                    <label>Expresion</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int2solveiz2" cssClass="form-control"/>
                                </div>
                            </div>                            
                            <div class="form-row">
                                <div class="col-1">
                                    <label>X^2 +</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int2solveiz3" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-1">
                                    <label>X +</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int2solveder1" cssClass="form-control"/>
                                </div>
                            </div>                                        
                        </div>
                        
                        <hr>        
                                
                        <div class="form-group">
                            <h1>Expand</h1>
                            <div class="form-row">
                                <div class="col-1">
                                    <label>(</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int2solveder2" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-1">
                                    <label> X +</label>
                                </div>
                                <div class="col-3">
                                     <s:textfield name="int2solveder3" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-1">
                                    <label>)(</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int3solveiz1" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-1">
                                    <label>x +</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int3solveiz2" cssClass="form-control"/>
                                </div>
                            </div>                            
                        </div>
                        
                        <hr>        
                                
                        <div class="form-group">
                            <h1>Factor</h1>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int3solveiz3</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int3solveiz3" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int3solveder1</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int3solveder1" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int3solveder2</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int3solveder2" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int3solveder3</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int3solveder3" cssClass="form-control"/>
                                </div>
                            </div>                                   
                        </div>
                                
                        <hr>
                                
                        <div class="form-group">
                            <h1>INTERFAZ 4</h1>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int4solveiz1</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int4solveiz1" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int4solveiz2</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int4solveiz2" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int4solveiz3</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int4solveiz3" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int4solveder1</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int4solveder1" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int4solveder2</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int4solveder2" cssClass="form-control"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-2">
                                    <label>int4solveder3</label>
                                </div>
                                <div class="col-3">
                                    <s:textfield name="int4solveder3" cssClass="form-control"/>
                                </div>
                            </div>                            
                            
                            
                            
                            
                            
                            
                            
                        </div>

                        <s:submit value="Agregar" cssClass="btn btn-danger"/>
                    </s:form>

                </div>                
        </div>

    </body>
</html>

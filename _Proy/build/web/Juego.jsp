
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
      
        <style>
        canvas {
            border:1px solid black;
        }
        </style>
        <script src="fabric.js"></script>
        <script src="Juego.js"></script>
    </head>
    <body>
        <input type="text" value="0" id="Cont">
        <input type="text" value="0" id="Cont2">
        <input type="text" value="0" id="Cont3">
        
        <canvas id="c" width="600" height="400" >
            
        </canvas>
        <s:textarea id="log" value=""></s:textarea>
        
        This shit es de la base y la determina el profe
       
        los value de lo seleccionado son el dato 1
        <s:hidden id="SolveIz1" value="1"></s:hidden> unidades
        <s:hidden id="SolveIz2" value="2"></s:hidden> x
        <s:hidden id="SolveIz3" value="3"></s:hidden> x^2
        <s:hidden id="SolveDer1" value="1"></s:hidden>misma mierda
        <s:hidden id="SolveDer2" value="2"></s:hidden>
        <s:hidden id="SolveDer3" value="3"></s:hidden>
        Aqui terminan las que se necesitan para solve 
        Faltan aun por las otras interfaces
     
        <button onclick="inicio.serializa()"></button>
        
        <script>
            var canvas = this.__canvas = new fabric.Canvas('c');
          fabric.Object.prototype.transparentCorners = false;
            inicio(canvas);

        </script>
    </body>
</html>

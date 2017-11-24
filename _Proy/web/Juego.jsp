
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
        <h1>Holo </h1>
        <input type="text" value="0" id="Cont">
        <input type="text" value="0" id="Cont2">
        <input type="text" value="0" id="Cont3">
        
        <canvas id="c" width="650" height="400" >
            
        </canvas>
        <s:textarea id="log" value=""></s:textarea>
        
     
        
        
        <script>
            var canvas = this.__canvas = new fabric.Canvas('c');
          fabric.Object.prototype.transparentCorners = false;
            inicio(Document,canvas);

        </script>
    </body>
</html>

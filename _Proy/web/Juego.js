
function inicio(Document,canvas) {   
    //Variables Globales
    unidades=[];
    Xs=[];
    X2s=[];
    
    
    function BotonTitulo(Nombre,x,y,R,G,B)
    {
        this.Forma = new fabric.Rect({
            width: 100, height: 30, left: x, top: y, angle: 0,
            fill: 'rgba('+R+','+G+','+B+',1.0)'
            
          });
        this.Forma.lockMovementX = true;//BloquearMovimiento
        this.Forma.lockMovementY = true;
        this.Forma.hasControls=false;
        this.Forma.set('selectable', false);
        this.text = new fabric.Text(Nombre, { 
            left: x+5, top: y+5, 
            fontSize: 15
        });
        this.text.lockMovementX = true;//BloquearMovimiento
        this.text.lockMovementY = true;
        this.text.set('selectable', false);
        canvas.add(this.Forma);
        canvas.add(this.text);
        this.IsSelect=function(Obj){
            return (this.Forma===Obj | this.text===Obj);
        };
        
        this.Deselect=function (){
            this.Forma.selection=true;
        };
        
    }
   
    function Fondo(width,height,X,Y,R,G,B){
        this.Forma = new fabric.Rect({
            width: width, height: height, left: X, top: Y, angle: 0,
            fill: 'rgba('+R+','+G+','+B+',0.5)'
            
          });
        this.Forma.lockMovementX = true;//BloquearMovimiento
        this.Forma.lockMovementY = true;
        this.Forma.set('selectable', false);
        
        this.Borrar=function (){
          this.Forma.remove(); 
          this.Forma.remove();  
        };
        this.Dibujar=function()
        {
            canvas.add(this.Forma);
        };
        canvas.add(this.Forma);
    }
    
    function BotonAddForma(width,height,x,y,RGB,Nombre)
    {
        this.width=width;
        //alert(RGB);
        this.height=height;
        this.Boton = new fabric.Rect({
            width: width, height: height, left: x, top: y, angle: 0,
            fill: 'rgba('+RGB+',0.5)'            
        });
        
        this.Boton.lockMovementX = true;//BloquearMovimiento
        this.Boton.lockMovementY = true;   
        
        this.text = new fabric.Text(Nombre, { 
            left: x+(width/3), top: y+(height/3), 
            fontSize: 15
        });
        this.text.lockMovementX = true;//BloquearMovimiento
        this.text.lockMovementY = true;
        this.text.set('selectable', false);
        
        this.Boton.on('selected',function (){              
            var NuevaFigura = new fabric.Rect({
            width: this.width, height: this.height, left: x, top: y, angle: 0,
            fill: 'rgba('+RGB+',0.5)'               
            });
            NuevaFigura.lockScalingY=true; //Bloqueando Reescalado
            NuevaFigura.lockScalingX=true;
            NuevaFigura.lockRotation=true;
            NuevaFigura.hasControls=false;
            NuevaFigura.animate('left', NuevaFigura.left === 100 ? 400 : 100, {
                duration: 700,
                onChange: canvas.renderAll.bind(canvas),
                onComplete: function() {

                },
                easing: fabric.util.ease["easeOutSine"]
            });
            canvas.add(NuevaFigura);
            canvas.setActiveObject(NuevaFigura);
            
            NuevaFigura.selection=true;
            switch (Nombre){
                case "1":
                    unidades.push(NuevaFigura);
                    break;
                case "X":
                    Xs.push(NuevaFigura)
                    break;
                case "X^2":
                    X2s.push(NuevaFigura);
                    break;
                
            }
            
            ActualizaDatos();            

        });
        
        this.Intercepta=function (Obj){
            if(this.Boton===Obj | this.text===Obj)
                return false;
            if(this.Boton.intersectsWithObject(Obj) |this.text.intersectsWithObject(Obj))
              {
                  //alert("Interseccion!!!");
                  //imprimir("interseccion\n");
                  return true;
              }
        };
        
        this.IsSelect=function(Obj){
            return (this.Boton===Obj | this.text===Obj);
        };
        
        canvas.add(this.Boton,this.text);   
          
          
    }
    
    function interfazSolve()
    {
        LadoIzquierdo = new Fondo(200,200,50,180,100,60,0);
        LadoDerecho = new Fondo(200,200,260,180,0,60,100);
        Visible=true;
        this.MosBorr=function ()
        {
            if(Visible){
                LadoIzquierdo.Borrar();
                LadoDerecho.Borrar();
            }
            else
            {
                LadoIzquierdo.Dibujar();
                LadoDerecho.Dibujar();
            }
            Visible=!Visible;
        };
        
    }
    
    function interfazSubstitute()
    {
        LadoIzquierdo = new Fondo(200,200,50,180,100,60,0);
        LadoDerecho = new Fondo(200,200,260,180,0,60,100);
        Visible=true;
        this.MosBorr=function ()
        {
            if(Visible){
                LadoIzquierdo.Borrar();
                LadoDerecho.Borrar();
            }
            else
            {
                LadoIzquierdo.Dibujar();
                LadoDerecho.Dibujar();
            }
            Visible=!Visible;
        };
        
    }
    
    
    function limpiarFiguras()
    {
        for(var i=0;i< unidades.length;i++)
        {
            //i.remove();
            unidades[i].remove();
        }
        for(var i=0;i< Xs.length;i++)
        {
            Xs[i].remove();
        }
        for(var i=0;i< X2s.length;i++)
        {
            X2s[i].remove();
        }
        unidades=[];
        Xs=[];
        X2s=[];
        ActualizaDatos();
    }
    
       

    
        
    
    
    
    
          
          
          cuenta = 0;
          
          
          //Creacion de Botones
          var Solve= new BotonTitulo("Solve",50,0,200,0,0);
          var Substitute= new BotonTitulo("Substitute",160,0,0,200,0);
          var Expand= new BotonTitulo("Expand",270,0,0,0,200);
          var Factor= new BotonTitulo("Factor",380,0,200,200,0);
          var Limpiar= new BotonTitulo("Limpiar",380,100,200,200,0);
          var Validar= new BotonTitulo("Validar",260,100,200,200,0);
          
          var Solve=new interfazSolve();
          
          //Generando Fondos.
          var FondoDerecho= new Fondo(150,400,550,0,100,20,100);
          var FondoSuperior= new Fondo(550,10,0,30,0,0,0);
          var FondoInferior= new Fondo(550,10,0,120,0,0,0);
          
          
          
          //Botones AgregaFiguras
          var unidad= new BotonAddForma(30,30,570,220,'200,0,0',"1");
          var X= new BotonAddForma(60,30,570,270,'0,100,200',"X");
          var X2= new BotonAddForma(60,60,570,320,'50,500,200',"X^2");
          
          
          function FuncionSolve()
            {
                Interfaz.MosBorr();

                
            }
          function FuncionSubstitue()
          {
              
          }
          

          document.onkeyup=function (evObject){
            tecla=evObject.which;
            //alert("Tecla:"+tecla);
            if(tecla===46||tecla===8)
              //
              EliminarSeleccion();
          };
          
          function EliminarSeleccion(){
              //Recuperamos objeto
              ob=canvas.getActiveObject();
              i=0;
              if(unidades.includes(ob))
              {
                 i=unidades.indexOf(ob);
                 unidades.splice(i,1);
                 ob.remove();
                 //alert("Quedan"+unidades.length);
              }
              else if(Xs.includes(ob))
              {
                 i=Xs.indexOf(ob);
                 Xs.splice(i,1);
                 ob.remove();
              }
              else if(X2s.includes(ob))
              {
                 i=X2s.indexOf(ob);
                 X2s.splice(i,1);
                 ob.remove();
              }
              
              ActualizaDatos();
          }
          
          
          
          
          
        
          canvas.on({           
            'object:moving': onChange,
            'object:scaling': onChange,
            'object:rotating': onChange,
            'mouse:up':Actualizacion
          });
          
          function imprimir(Str)
          {
              co=document.getElementById("log");              
              co.appendChild(document.createTextNode(Str));

          }
          
          function ActualizaDatos()
          {
              co=document.getElementById("Cont");
              co.setAttribute("value",unidades.length);
              co=document.getElementById("Cont2");
              co.setAttribute("value",Xs.length);
              co=document.getElementById("Cont3");
              co.setAttribute("value",X2s.length);
          }
          
          
          function  Actualizacion(options){              
         
              if(Solve.IsSelect(options.target))
                  FuncionSolve();
              else if(Limpiar.IsSelect(options.target))
                  limpiarFiguras();
              else if(Substitute.IsSelect(options.target))
                  FuncionSubstitue();
              try{
              options.target.setCoords();
              
              if(unidad.IsSelect(options.target) | X.IsSelect(options.target)
                      |X2.IsSelect(options.target)
                     | FondoDerecho.Forma=== options.target){
                  
                  return;
              }
              if(FondoDerecho.Forma.intersectsWithObject(options.target))
              {
                  //alert("Interseccion!!!");
                  imprimir("Borrado");
                  EliminarSeleccion();
              }
              }
              catch (err)
              {
                  
              }
                    
          }
          function onChange(options) {
              
            options.target.setCoords();

            canvas.forEachObject(function(obj) {
              if (obj === options.target) return;              
              obj.set('opacity' ,options.target.intersectsWithObject(obj) ? 0.5 : 1);
            });
          }
}



//Actualmente No usado
    function CreaCuadrado(options){
              var NuevaFigura = new fabric.Rect({
                width: 100, height: 100, left: 350, top: 250, angle: 0,
                fill: 'rgba(0,200,0,0.5)'               
                });
              canvas.add(NuevaFigura);
              canvas.setActiveObject(NuevaFigura);
              cuenta++;
              NuevaFigura.selection=true;
              //alert("Llevas cuadrados:"+cuenta);
          }
      



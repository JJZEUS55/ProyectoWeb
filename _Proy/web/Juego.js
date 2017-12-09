
function inicio(Document,canvas) {   
    //Variables Globales
    unidades=[];
    Xs=[];
    X2s=[];
    InterfazActiva=0;
    
   
    
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
            fontSize: 12
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
    
     function Texto(Texto,X,Y)
    {
        this.text = new fabric.Text(Texto, { 
            left: X, top: Y, 
            fontSize: 15
        });
        this.text.lockMovementX = true;//BloquearMovimiento
        this.text.lockMovementY = true;
        this.text.set('selectable', false);
        this.Borrar=function (){
          this.text.remove(); 
          
        };
        this.Dibujar=function()
        {
            canvas.add(this.text);
        };
        canvas.add(this.text);
    }
    
    function interfazSolve()
    {
        this.LadoIzquierdo = new Fondo(200,200,50,180,100,60,0);
        this.LadoDerecho = new Fondo(200,200,260,180,0,60,200);
        //Visible=true;
        this.MosBorr=function (Visible)
        {
            if(!Visible){
                this.LadoIzquierdo.Borrar();
                this.LadoDerecho.Borrar();
            }
            else       
            {
                this.LadoIzquierdo.Dibujar();
                this.LadoDerecho.Dibujar();
            }
            Visible=!Visible;
        };
        //MosBorr(false);
    }
    
    function interfazSubstitute()
    {
        this.LadosuperiorIZ = new Fondo(200,100,50,175,100,60,0);
        this.LadosuperiorDer = new Fondo(200,100,250,175,100,60,0);
        this.LadoDerecho = new Fondo(400,100,50,285,0,60,100);
        this.Text1=new Texto("Valor de x",210,175);
        this.Text2=new Texto("Expresion",210,282);
        this.MosBorr=function (Visible)
        {
            if(!Visible){
                this.LadosuperiorIZ.Borrar();
                this.LadosuperiorDer.Borrar();
                this.LadoDerecho.Borrar();
                this.Text1.Borrar();
                this.Text2.Borrar();
            }
            else
            {
                this.LadosuperiorIZ.Dibujar();
                this.LadosuperiorDer.Dibujar();
                this.LadoDerecho.Dibujar();
                this.Text1.Dibujar();
                this.Text2.Dibujar();
            }
            //Visible=!Visible;
        };
        //this.MosBorr(false);
    }
    
    function interfazExpand()
    {
        this.LadoIzquierdo = new Fondo(200,200,50,180,100,60,0);
        this.LadoDerecho = new Fondo(200,200,260,180,0,60,200);
        //Visible=true;
        this.MosBorr=function (Visible)
        {
            if(!Visible){
                this.LadoIzquierdo.Borrar();
                this.LadoDerecho.Borrar();
            }
            else       
            {
                this.LadoIzquierdo.Dibujar();
                this.LadoDerecho.Dibujar();
            }
            Visible=!Visible;
        };
        //MosBorr(false);
    }
    function interfazFactor()
    {
        this.LadoIzquierdo = new Fondo(200,200,50,180,100,60,0);
        this.LadoDerecho = new Fondo(200,200,260,180,0,60,200);
        //Visible=true;
        this.MosBorr=function (Visible)
        {
            if(!Visible){
                this.LadoIzquierdo.Borrar();
                this.LadoDerecho.Borrar();
            }
            else       
            {
                this.LadoIzquierdo.Dibujar();
                this.LadoDerecho.Dibujar();
            }
            Visible=!Visible;
        };
        //MosBorr(false);
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
    
          
          
    //Creacion de Botones
    var Solve= new BotonTitulo("Solve",50,0,200,0,0);
    var Substitute= new BotonTitulo("Substitute",160,0,0,200,0);
    var Expand= new BotonTitulo("Expand",270,0,0,0,200);
    var Factor= new BotonTitulo("Factor",380,0,200,200,0);
    var Limpiar= new BotonTitulo("Limpiar",380,100,200,200,0);
    var Validar= new BotonTitulo("Validar",260,100,200,200,0);

    //Agregar textos
    text1=new Texto("Construye tu modelo",200,150);

    //Iniciar Interfaces
    var interfaces=[4];
    interfaces[0]=new interfazSolve();
    interfaces[0].MosBorr(false);
    interfaces[1]=new interfazSubstitute();
    interfaces[1].MosBorr(false);
    interfaces[2]=new interfazExpand();
    interfaces[2].MosBorr(false);
    interfaces[3]=new interfazFactor();
    interfaces[3].MosBorr(false);

    
    
    XRel=-45;
    //Generando Fondos.
    var FondoDerecho= new Fondo(150,400,550+XRel,0,100,20,100);
    var FondoSuperior= new Fondo(550+XRel,10,0,30,0,0,0);
    var FondoInferior= new Fondo(550+XRel,10,0,120,0,0,0);



    //Botones AgregaFiguras
    var unidad= new BotonAddForma(20,20,570+XRel,220,'200,0,0',"1");
    var X= new BotonAddForma(40,20,570+XRel,270,'0,100,200',"X");
    var X2= new BotonAddForma(40,40,570+XRel,320,'50,500,200',"X^2");
          
          
         
          

          document.onkeyup=function (evObject){
            tecla=evObject.which;
            //alert("Tecla:"+tecla);
            if(tecla===46||tecla===8)
              //
              EliminarSeleccion();
          };
          
          
          
          function CambiaInterfaz(i)
            {
                InterfazActiva=i;
                for( j=0;j<4;j++)
                {
                    interfaces[j].MosBorr(false);
                    if(i===j+1)
                        interfaces[j].MosBorr(true);
                    
                        
                }
                //interfaces[0].MosBorr  (false);
                //interfaces[1].MosBorr(false);
                
            }
          
          
          
          
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
                  CambiaInterfaz(1);
              else if(Limpiar.IsSelect(options.target))
                  limpiarFiguras();
              else if(Substitute.IsSelect(options.target))
                  CambiaInterfaz(2);
              else if(Expand.IsSelect(options.target))
                  CambiaInterfaz(3);
              else if(Factor.IsSelect(options.target))
                  CambiaInterfaz(4);
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
      



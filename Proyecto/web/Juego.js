
function imprimir(Str)
{
    co=document.getElementById("log");              
    co.appendChild(document.createTextNode(Str+","));

}
function imprimir2(Str,campo)
{
    co=document.getElementById(campo);
    co.setAttribute("value",Str);
    //co.appendChild(document.createTextNode(Str+","));

};


function inicio(canvas) {   
    //Variables Globales
     function serializa()
    {
        imprimir(canvas.toSVG());
    }
    var unidades=[];
    var Xs=[];
    var X2s=[];
    var unidadesN=[];
    var XsN=[];
    var X2sN=[];
    InterfazActiva=0;
    
    
    
    var SolveIz=[3];
    var SolveDe=[3];
   
    var SubsIz=[3];
    var SubsDe=[3];
    var SubsAb=[3];
    
    var ExpIz=[3];
    var ExpDe=[3];
    var ExpSu=[3];
    
    var FacIz=[3];
    var FacDe=[3];
    var FacSu=[3];
    
    
    //Recuperamos valores del jsp
    SolveIz[0]=document.getElementById("SolveIz1").value;
    SolveIz[1]=document.getElementById("SolveIz2").value;
    SolveIz[2]=document.getElementById("SolveIz3").value;
    for (i=1;i<4;i++)
    {
        SolveDe[i-1]=document.getElementById("SolveDe"+i).value;
        
        SubsIz[i-1]=0;
        
        SubsDe[i-1]=0;//document.getElementById("SubsDe"+i).value;
        SubsAb[i-1]=document.getElementById("SubsAb"+i).value;

        ExpIz[i-1]=0;//document.getElementById("SolveDe"+i).value;
        ExpDe[i-1]=0;//document.getElementById("SolveDe"+i).value;
        ExpSu[i-1]=0;//document.getElementById("SolveDe"+i).value;

        FacIz[i-1]=0;//document.getElementById("SolveDe"+i).value;
        FacDe[i-1]=0;//document.getElementById("SolveDe"+i).value;
        FacSu[i-1]=0;//document.getElementById("SolveDe"+i).value;
    }
    
    SubsDe[0]=document.getElementById("SubsDe"+1).value;
    SubsIz[1]=1;
    ExpIz[0]=document.getElementById("ExpI"+0).value;
    ExpIz[1]=document.getElementById("ExpI"+1).value;
    ExpSu[0]=document.getElementById("ExpS"+0).value;
    ExpSu[1]=document.getElementById("ExpS"+1).value;
    ExpDe[0]=ExpIz[0]*ExpSu[0];
    ExpDe[1]=ExpIz[1]*ExpSu[0]+ExpIz[0]*ExpSu[1];
    ExpDe[2]=ExpIz[1]*ExpSu[1];
    FacIz[0]=document.getElementById("FacI"+0).value;
    FacIz[1]=document.getElementById("FacI"+1).value;
    FacSu[0]=document.getElementById("FacS"+0).value;
    FacSu[1]=document.getElementById("FacS"+1).value;
    FacDe[0]=FacIz[0]*FacSu[0];
    FacDe[1]=FacIz[1]*FacSu[0]+FacIz[0]*FacSu[1];
    FacDe[2]=FacIz[1]*FacSu[1];
    imprimir(ExpDe[0]+","+ExpDe[1]+","+ExpDe[2]+",");
    
    //uni=;
    //alert(uni.value);
    imprimir(""+SolveIz[0]+""+SolveIz[1]+""+SolveIz[2]+"");
    
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
        this.Intercepta=function (Obj){
            if(this.Forma===Obj)
                return false;
            if(this.Forma.intersectsWithObject(Obj))
              {
                  //alert("Interseccion!!!");
                  //imprimir("interseccion\n");
                  return true;
              }
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
                    Xs.push(NuevaFigura);
                    break;
                case "X^2":
                    X2s.push(NuevaFigura);
                    break;
                 case "-1":
                    unidadesN.push(NuevaFigura);
                    break;
                case "-X":
                    XsN.push(NuevaFigura);
                    break;
                case "-X^2":
                    X2sN.push(NuevaFigura);
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
        this.Text1=new Texto(SolveIz[0]+" + "+SolveIz[1]+"X +"+SolveIz[2]+"x^2="+SolveDe[0]+" + "+SolveDe[1]+"X +"+SolveDe[2]+"x^2",150,75);
        //Visible=true;
        this.MosBorr=function (Visible)
        {
            if(!Visible){
                this.LadoIzquierdo.Borrar();
                this.LadoDerecho.Borrar();
                this.Text1.Borrar();
            }
            else       
            {
                this.LadoIzquierdo.Dibujar();
                this.LadoDerecho.Dibujar();
                this.Text1.Dibujar();
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
        this.Text=new Texto("X="+SubsDe[0]+"\n"+SubsAb[2]+"X^2 + "+SubsAb[1]+"X + "+SubsAb[0]+"",210,50);
        this.Text1=new Texto("Valor de x",210,175);
        this.Text2=new Texto("Expresion",210,282);
        this.MosBorr=function (Visible)
        {
            if(!Visible){
                this.LadosuperiorIZ.Borrar();
                this.LadosuperiorDer.Borrar();
                this.LadoDerecho.Borrar();
                this.Text.Borrar();
                this.Text1.Borrar();
                this.Text2.Borrar();
            }
            else
            {
                this.LadosuperiorIZ.Dibujar();
                this.LadosuperiorDer.Dibujar();
                this.LadoDerecho.Dibujar();
                this.Text.Dibujar();
                this.Text1.Dibujar();
                this.Text2.Dibujar();
            }
            //Visible=!Visible;
        };
        //this.MosBorr(false);
    }
    
    function interfazExpand()
    {
        this.LadoIzquierdo = new Fondo(25,200,240,180,100,60,0);
        this.LadoSup = new Fondo(200,25,240,180,100,60,0);
        this.LadoDerecho = new Fondo(175,175,265,205,0,60,200);
        this.Text=new Texto("("+ExpIz[1]+"X + "+ExpIz[0]+")("+ExpSu[1]+"X + "+ExpSu[0]+")",210,50);
        //Visible=true;
        this.MosBorr=function (Visible)
        {
            if(!Visible){
                this.LadoIzquierdo.Borrar();
                this.LadoDerecho.Borrar();
                this.LadoSup.Borrar();
                this.Text.Borrar();
            }
            else       
            {
                this.LadoIzquierdo.Dibujar();
                this.LadoDerecho.Dibujar();
                this.LadoSup.Dibujar();
                this.Text.Dibujar();
            }
            Visible=!Visible;
        };
        //MosBorr(false);
    }
    function interfazFactor()
    {
        this.LadoIzquierdo = new Fondo(25,200,240,180,100,60,0);
        this.LadoSup = new Fondo(200,25,240,180,100,60,0);
        this.LadoDerecho = new Fondo(175,175,265,205,200,60,200);
        this.Text=new Texto(""+FacDe[2]+"X^2 + "+FacDe[1]+"X + "+FacDe[0]+"",210,50);
        //Visible=true;
        this.MosBorr=function (Visible)
        {
            if(!Visible){
                this.LadoIzquierdo.Borrar();
                this.LadoDerecho.Borrar();
                this.LadoSup.Borrar();
                this.Text.Borrar();
            }
            else       
            {
                this.LadoIzquierdo.Dibujar();
                this.LadoDerecho.Dibujar();
                this.LadoSup.Dibujar();
                this.Text.Dibujar();
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
        for(var i=0;i< unidadesN.length;i++)
        {
            //i.remove();
            unidadesN[i].remove();
        }
        for(var i=0;i< XsN.length;i++)
        {
            XsN[i].remove();
        }
        for(var i=0;i< X2sN.length;i++)
        {
            X2sN[i].remove();
        }
        unidades=[];
        Xs=[];
        X2s=[];
        unidadesN=[];
        XsN=[];
        X2sN=[];
        ActualizaDatos();
    }
    
          
          
    //Creacion de Botones
    var Solve= new BotonTitulo("Solve",50,0,200,0,0);
    var Substitute= new BotonTitulo("Substitute",160,0,0,200,0);
    var Expand= new BotonTitulo("Expand",270,0,0,0,200);
    var Factor= new BotonTitulo("Factor",380,0,200,200,0);
    var Limpiar= new BotonTitulo("Limpiar",380,100,200,200,0);
    var Validar= new BotonTitulo("Validar",260,100,200,200,0);
     //var Guardar= new BotonTitulo("Validar",260,100,200,200,0);
    
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
    Yrel=-20;
    var unidad= new BotonAddForma(20,20,570+XRel,220+Yrel,'255,250,0',"1");
    var X= new BotonAddForma(40,20,570+XRel,270+Yrel,'0,100,200',"X");
    var X2N= new BotonAddForma(40,40,570+XRel,320+Yrel,'50,500,200',"X^2");
    var unidadN= new BotonAddForma(20,20,595+XRel,240+Yrel,'255,0,0',"-1");
    var XN= new BotonAddForma(40,20,595+XRel,290+Yrel,'255,0,0',"-X");
    var X2N= new BotonAddForma(40,40,595+XRel,360+Yrel,'255,0,0',"-X^2");
          
          
         
          

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
              else if(unidadesN.includes(ob))
              {
                 i=unidadesN.indexOf(ob);
                 unidadesN.splice(i,1);
                 ob.remove();
                 //alert("Quedan"+unidades.length);
              }
              else if(XsN.includes(ob))
              {
                 i=XsN.indexOf(ob);
                 XsN.splice(i,1);
                 ob.remove();
              }
              else if(X2sN.includes(ob))
              {
                 i=X2sN.indexOf(ob);
                 X2sN.splice(i,1);
                 ob.remove();
              }
              ActualizaDatos();
          }
          
          function CuentaIntercepciones(Fondo)
          {
              var res=[3];
              res[0]=0;
              res[1]=0;
              res[2]=0;
              for(i=0;i<unidades.length;i++)
              {
                  if(Fondo.Intercepta(unidades[i]))
                      res[0]++;
              }
              for(i=0;i<Xs.length;i++)
              {
                  if(Fondo.Intercepta(Xs[i]))
                      res[1]++;
              }
              for(i=0;i<X2s.length;i++)
              {
                  if(Fondo.Intercepta(X2s[i]))
                      res[2]++;
              }
              for(i=0;i<unidadesN.length;i++)
              {
                  if(Fondo.Intercepta(unidadesN[i]))
                      res[0]--;
              }
              for(i=0;i<XsN.length;i++)
              {
                  if(Fondo.Intercepta(XsN[i]))
                      res[1]--;
              }
              for(i=0;i<X2sN.length;i++)
              {
                  if(Fondo.Intercepta(X2sN[i]))
                      res[2]--;
              }
              return res;
          }
    function CompArray(Ar1,Ar2)
    {
       for(i=0;i<3;i++)
       {
           //alert(Ar1[i]+","+Ar2[i]);
            if(!(Ar1[i]==Ar2[i]))
               return false;
       }
       return true;
    }
          
          
    function Validacion()
          {
       //serializa();       
        switch (InterfazActiva)
              {
                  case 1:
                      
                      imprimir2("ExpandCorrecto","res3");
                      res1=CuentaIntercepciones(interfaces[0].LadoIzquierdo);
                      imprimir("\nLado Izquierdo:"+res1[0]+","+res1[1]+","+res1[2]);                      
                      res2=CuentaIntercepciones(interfaces[0].LadoDerecho);
                      imprimir("Lado Derecho:"+res2[0]+","+res2[1]+","+res2[2]);
                      //if()                          
                      if(CompArray(res1,SolveIz) && CompArray(res2,SolveDe)){
                          imprimir ("itworks");
                          imprimir2("SolveCorrecto","res1");
                        }
                      else
                          //alert("Tienes un error");
                          imprimir2("SolveIncorrecto","res1");
                      break;
                  case 2:
                      res1=CuentaIntercepciones(interfaces[1].LadosuperiorDer);
                      imprimir("\nLado Derecho:"+res1[0]+","+res1[1]+","+res1[2]);
                      res2=CuentaIntercepciones(interfaces[1].LadosuperiorIZ);
                      imprimir("Lado Izquierdo:"+res2[0]+","+res2[1]+","+res2[2]);
                      res3=CuentaIntercepciones(interfaces[1].LadoDerecho);
                      imprimir("Lado Inferior:"+res3[0]+","+res3[1]+","+res3[2]);
                      
                      if(CompArray(res1,SubsDe) && CompArray(res2,SubsIz) && CompArray(res3,SubsAb) ){                   
                            imprimir("Holo");
                            imprimir2("SubstCorrecto","res2");
 
                        }                           
                      else
                          imprimir2("SubstIncorrecto","res2");
                      
                      break;
                  case 3:
                      res1=CuentaIntercepciones(interfaces[3].LadoIzquierdo);
                      imprimir("\nLado Izquierdo:"+res1[0]+","+res1[1]+","+res1[2]);
                      res2=CuentaIntercepciones(interfaces[3].LadoSup);
                      imprimir("Lado Sup:"+res2[0]+","+res2[1]+","+res2[2]);
                      res3=CuentaIntercepciones(interfaces[3].LadoDerecho);
                      imprimir("Lado Derecho:"+res3[0]+","+res3[1]+","+res3[2]);
                                               
                      if(CompArray(res3,ExpDe) && CompArray(res2,ExpSu) && CompArray(res1,ExpIz)){
                            imprimir("hol");    
                            imprimir2("ExpandCorrecto","res3");
                    }
                    else
                          //alert("Tienes un error");
                          imprimir2("ExpandIncorrecto","res3");
                      break;
                  case 4:
                      res1=CuentaIntercepciones(interfaces[3].LadoIzquierdo);
                      imprimir("\nLado Izquierdo:"+res1[0]+","+res1[1]+","+res1[2]);
                      res2=CuentaIntercepciones(interfaces[3].LadoSup);
                      imprimir("Lado Sup:"+res2[0]+","+res2[1]+","+res2[2]);
                      res3=CuentaIntercepciones(interfaces[3].LadoDerecho);
                      imprimir("Lado Derecho:"+res3[0]+","+res3[1]+","+res3[2]);
                                              
                      if(CompArray(res3,FacDe) && CompArray(res2,FacSu) && CompArray(res1,FacIz)){
                            imprimir("hol");
                            imprimir2("FactorCorrecto","res4");
                        }
                    else
                       
                          imprimir2("FactorIncorrecto","res4");
                      break;
                      
                      
              }
          }
          
          
          
        
          canvas.on({           
            'object:moving': onChange,
            'object:scaling': onChange,
            'object:rotating': onChange,
            'mouse:up':Actualizacion
          });
          
          
          
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
              else if(Validar.IsSelect(options.target))
                  Validacion();
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




      



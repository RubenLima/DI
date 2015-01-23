

//Librerias importo
import java.awt.*;
import java.applet.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;




public class Pelota extends Applet implements Runnable,ActionListener {

	//propiedades
	private Thread hilo_applet=null; //hilo clase Thread
	private Hilo h1=null;
	int contador_applet=0;
	private Button b1,b2; //botones del Applet
	int pos_x=0;
	int ancho,alto;
	boolean derecha=true;
	private Font fuente;  //tipo de letra de la hora
	//private String horaActual="";


//método init
public void init(){
	fuente=new Font("Verdana",Font.BOLD,26);
	
    ancho = Integer.parseInt(this.getParameter("WIDTH"));
     alto = Integer.parseInt(this.getParameter("HEIGHT"));
    
	//añado botón 1 y su listener
	add(b1=new Button("Stop flag hilo contador"));
	b1.addActionListener(this);
	
	//añado botón 2 y su listener
	add(b2=new Button("Stop interrupt hilo contador"));
	b2.addActionListener(this);
}

public void start(){
	if (hilo_applet==null){
		hilo_applet=new Thread(this);	//creo el hilo
		hilo_applet.start(); //lanzo hilo
		}
	
		h1=new Hilo(3);	//creo el hilo
		h1.start(); //lanzo hilo
	
}


public void run(){
	Thread hiloActual=Thread.currentThread();

	while (hilo_applet==hiloActual) //vble hilo apunta a hilo en ejecución
		{ 
			//actualizo contador_applet
			//SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			//Calendar cal=Calendar.getInstance();
			//horaActual=sdf.format(cal.getTime());
			
			repaint(); //actualiza contenido applet
			
			//espero un segundo
			try {
				Thread.sleep(200);
			}catch (InterruptedException e){}
		}
}

public void stop(){
	hilo_applet=null;
}

public void paint(Graphics g){
	if (pos_x>=ancho)//si me paso por la derecha cambio dirección
			derecha=false;
			h1.direccion(derecha);
	if (pos_x<=0)
		derecha=true;//si llego a borde izquierdo cambio dirección
		h1.direccion(derecha);
	pos_x=h1.getpos_x();//obtengo posición x a pintar pelota
	
	setBackground(Color.white); //color de fondo
	g.setFont (fuente); //fuente
	//g.drawString( Integer.toString(contador_applet),30,150); // muestra la hora
	g.setColor(Color.black);
  	g.fillArc(pos_x,100,20,20,0,360); //dibujo pelota	
}



@Override
public void actionPerformed(ActionEvent arg0) {
	if (arg0.getSource()==b1){//paro hilo1
		b1.setLabel("Finalizado hilo1");
		h1.requestStop();//stop con flag
		//h1.interrumpir(); //llamo a interrumpir
		}	
	else if (arg0.getSource()==b2){//paro hilo1
		b1.setLabel("Finalizado hilo2");
		//h1.requestStop();//stop con flag
		h1.interrumpir(); //llamo a interrumpir
		}
}

}
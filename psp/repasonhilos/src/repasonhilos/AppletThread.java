package repasonhilos;

import java.awt.*;
import java.applet.*;

public class AppletThread extends Applet implements Runnable {

	//propiedades
	private Thread hilo=null;
	private Button b1,b3;
	
	//método init
	public void init(){
	
	int ancho = Integer.parseInt(this.getParameter("WIDTH"));
	int alto = Integer.parseInt(this.getParameter("HEIGHT"));

	}

	public void start(){
		if (hilo==null){
				hilo=new Thread(this);	//creo el hilo
				hilo.start(); //lanzo hilo
			}
			setBackground(Color.white);
			add(b1=new Button("Parar contador"));
			b1.addActionListener(this);
			fuente=new Font("Verdana",Font.BOLD,26);
	}


	public void run(){
		Thread hiloActual=Thread.currentThread();
		while (hilo==hiloactual) //vble hilo apunta a hilo en ejecución
			{ 
			//Tarea repetitiva
			}
	}
	
	public void stop(){
		hilo=null;
	}
	
	public void actionPerformed(ActionEvent e) {
					
		if (e.getSource()==b1){//lo paro
			hilo.stop();
					
			else
			{				
			}	
		
	}//actionperformed
	
	public void paint(Graphics g){
	
	g.setFont(fuente);
	g.setColor(Color.black);
	g.fillArc(x,y,3,3,0,360); //dibujo pelota

	}

}

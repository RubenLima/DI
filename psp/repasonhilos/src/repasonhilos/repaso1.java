package repasonhilos;


import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class repaso1 extends Applet implements Runnable, ActionListener {

	//Propiedades
	private Thread h;
	private Thread i;
	private Thread j;
	private Font fuente;
	long CONTADOR=1000;
	long CONTADOR1=1000;
	long CONTADOR2=1000;
	long CONTADOR3=1000;
	long CONTADOR4=1000;
	long CONTADOR5=1000;
	private boolean parar;
	private Button b1,b2,b3,b4,b5,b6; //botones del Applet	
	
	public void start(){}		
	
	//método init
	public void init(){
		setBackground(Color.yellow);//color de fondo
		
		//añado botón 1 y su listener
		add(b1=new Button("Iniciar contador"));
		b1.addActionListener(this);
				
		//añado botón 2 y su listener
		add(b2=new Button("Parar contador"));
		b2.addActionListener(this);
		
		fuente=new Font("Verdana",Font.BOLD,26); //tipo de letra
		
		add(b3=new Button("Iniciar contador1"));
		b3.addActionListener(this);
				
		//añado botón 2 y su listener
		add(b4=new Button("Parar contador1"));
		b4.addActionListener(this);
		
		add(b5=new Button("Iniciar contador2"));
		b5.addActionListener(this);
				
		//añado botón 2 y su listener
		add(b6=new Button("Parar contador2"));
		b6.addActionListener(this);
		
		fuente=new Font("Verdana",Font.BOLD,26); //tipo de letra
	}
	

	public void run() {
		//inicializo parar a falso
		parar=false;
		
		//recojo hiloActual
		Thread hiloActual=Thread.currentThread();
		
		while (h==hiloActual && !parar){
			try{
				Thread.sleep(300);
			}catch (InterruptedException e){e.printStackTrace();}
			repaint();
			CONTADOR=CONTADOR+3;
			CONTADOR1=CONTADOR1-3;
			
			
		}//fin while
		
		while (i==hiloActual && !parar){
			try{
				Thread.sleep(300);
			}catch (InterruptedException e){e.printStackTrace();}
			repaint();
			CONTADOR2=CONTADOR2+2;
			CONTADOR3=CONTADOR3-2;
			
			
		}
		
		while (j==hiloActual && !parar){
			try{
				Thread.sleep(300);
			}catch (InterruptedException e){e.printStackTrace();}
			repaint();
			CONTADOR4=CONTADOR4+1;
			CONTADOR5=CONTADOR5-1;
			
			
		}//fin while
		
		
	}//fin run
	
	
	public void paint(Graphics g){
		g.setFont(fuente);
		g.drawString("hilo 1 :"+Long.toString((long)CONTADOR), 10, 210); //escribe contador		
		g.drawString("hilo 1 :"+Long.toString((long)CONTADOR1), 10, 170); 		
		g.drawString("hilo 2 :"+Long.toString((long)CONTADOR2), 10, 130);		
		g.drawString("hilo 2 :"+Long.toString((long)CONTADOR3), 10, 90);
		g.drawString("hilo 3 :"+Long.toString((long)CONTADOR4), 10, 50);		
		g.drawString("hilo 3 :"+Long.toString((long)CONTADOR5), 10, 20);
		
	}
	
	
	//parar controlar pulsación botones	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==b1){//comienzo
			
			if (h!=null && h.isAlive()){ //si el hilo está corriendo y vivo no hago nada
				
				b1.setLabel("Continuar");
			}
			else
			{
				h=new Thread(this);
				h.start();
			}
		} else if (e.getSource()==b2){ //parada
				parar=true;
		}
		
		if (e.getSource()==b3){//comienzo
			if (i!=null && i.isAlive()){ //si el hilo está corriendo y vivo no hago nada
					
				b3.setLabel("Continuar1");}
			
			else
			{
				i=new Thread(this);
				i.start();
			}
		} else if (e.getSource()==b4){ //parada
				parar=true;
		}
		
		if (e.getSource()==b5){//comienzo
			b5.setLabel("Continuar2");
			if (j!=null && j.isAlive()){ //si el hilo está corriendo y vivo no hago nada
				
				
			}
			else
			{
				j=new Thread(this);
				j.start();
				
			}
		} else if (e.getSource()==b6){ //parada
				parar=true;
		}
		//b5.setLabel("Continuar2");
		
		
	}//actionperformed
	
	public void stop(){
		
		//h=null;
		i=null;
		//j=null;
	}
}
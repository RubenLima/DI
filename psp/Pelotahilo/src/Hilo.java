

public class Hilo extends Thread{

	//propiedades
	private int contador;
	private boolean derecha=true;
	
	//me declaro vble utilizare de flag 
	private volatile boolean stopRequested = false; //volatile pueden acceder a ella varios hilos
	
	//constructor
	Hilo (int x){
		this.contador=x;
	}
	
	
	//run	
	public void run(){
		try {
			while ((!stopRequested)) {
				if (derecha)
					contador++;
				else 
					contador--;
				Thread.sleep(100);
			}
		}catch (InterruptedException e){
			System.out.println("Ha ocurrido una excepcion");
		}
		
				
	}
	
	public void requestStop() {
		  stopRequested = true;
		}
	
	
	 public void interrumpir(){
		 interrupt();
	 }
	public int getpos_x(){
		return contador;
	}
	


	public void direccion(boolean d) {
		derecha=d;
		
	}
		
}

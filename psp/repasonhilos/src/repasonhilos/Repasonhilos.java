package repasonhilos;

public class Repasonhilos implements Runnable {
	
	//propiedades
	
	private int cont1 ;
	private int cont2;
	
	//constructor
	Repasonhilos(int cont1,int cont2){
		this.cont1=cont1;
		this.cont2=cont2;
	}
	//run
	public void run(){	
		for (int i=0;i<cont1;i++)
			System.out.println("En el hilo..."+i);
		
	}
	// implementar get contador1 y getcontador2
	

}

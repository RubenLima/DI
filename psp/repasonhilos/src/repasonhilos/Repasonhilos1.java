package repasonhilos;

public class Repasonhilos1 {
	public static void main (String[] args){
		Repasonhilos p=new Repasonhilos(10,10); //creo objeto hilo
		new Thread(p).start(); //inicio ejecución
		}


}

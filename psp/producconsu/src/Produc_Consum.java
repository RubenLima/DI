public class Produc_Consum{
	public static void main(String[] args) {
		Cola cola=new Cola();
		Productor p=new Productor(cola,"ping");
		Consumidor c=new Consumidor(cola,"ping");
		p.start();
		c.start();	
		
	}
	


}

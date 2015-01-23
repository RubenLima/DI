class Consumidor extends Thread {
	private Cola cola;
	private String n;

	public Consumidor (Cola c, String n){
		cola=c;
		this.n=n;
	}
	
	public void run(){
		String valor;
		for (int i=0;i<5;i++){
			valor=cola.get();//recoge el numero
			System.out.println(i+"->Consumidor:"+ n + ", consume: "+valor);
	 			
		}
	}

}

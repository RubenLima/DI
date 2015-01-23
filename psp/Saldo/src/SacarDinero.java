class SacarDinero extends Thread{
	private Cuenta c; //declaro objeto cuenta c
	String nom;
	
	//constructor
	public SacarDinero (String n, Cuenta c){
		super(n);
		this.c=c;
	}
	//run
	public void run(){
		for (int x=1;x<=4;x++){
			
			if(c.getSaldo()==0){
				
				System.out.println("no hay saldo");
				
				
			}
		else{
				
			c.RetirarDinero(10,getName());
			
			
		
			}
			}
	}

}

class Productor extends Thread{
	private Cola cola;
	private String n;
	private String a = "ping";

	public Productor (Cola c,String n){
		cola=c;
		this.n=n;
	}
	
	public void run(){
		for (int i=0;i<5;i++){
			
			if(a=="pong"){
				a ="ping";				
			}
			
			else if (a=="ping") {
				a ="pong";	
			}
			cola.put(a); //pone el número
			System.out.println(i	+"->Productor:"+ n + ", produce: "+a);
 			try {
				sleep(100);
			}catch (InterruptedException e){}
		}
	}
}

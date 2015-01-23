
import java.io.* ;
import java.net.* ;
//Servidor espera conexiones a las que atenderá con un segundo socket
//Servidor saludará con frase "Hola cliente"
class Servidor {

//puerto espera conexiones
static final int PUERTO=5000;

	public Servidor( ) {
		
		
		try {
			//crea socket y espera
			ServerSocket skServidor = new ServerSocket( PUERTO );
			System.out.println("Escucho el puerto " + PUERTO );

		while (true){
			
				//skCliente atiene al cliente
				Socket skCliente = skServidor.accept(); // Crea objeto

				System.out.println("Sirvo al cliente " );
											
				//recojo flujo de datos del socket
				InputStream aux = skCliente.getInputStream();

				//asocio flujo de datos flujo de tipo DataInputStream
				DataInputStream flujo = new DataInputStream( aux );
				
				//Capturamos cadena del flujo con readUTF y muestro
				System.out.println( flujo.readUTF() );

				
				//Trato petición ------
				
				//contesto
							
				System.out.println("Contesto al cliente " );
				
				DataOutputStream flujo_salida;
				
				//creo flujo salida y conecto con el del socket
				flujo_salida = new DataOutputStream(skCliente.getOutputStream());
				flujo_salida.writeUTF("Muy bien, gracias!");
				
				skCliente.close(); 
			}//fin while
			
	
		} catch( Exception e ) {

	System.out.println( e.getMessage() );

	}

}

public static void main( String[] arg ) {

new Servidor();

}

}



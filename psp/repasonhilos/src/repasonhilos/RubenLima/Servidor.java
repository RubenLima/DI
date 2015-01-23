package repasonhilos.RubenLima;

import java.io.* ;
import java.net.* ;
//Servidor espera conexiones a las que atenderá con un segundo socket
//Servidor saludará con frase "Hola cliente"
class Servidor {

//puerto espera conexiones
static final int PUERTO=5000;
boolean n = false;

//definir butacas
int preciovip1=250;
int preciovip2=250;
int preciolat1=100;
int preciolat2=100;
int preciocen=80;
int preciogal=150;
int numvip1=3;
int numvip2=3;
int numlat1=4;
int numlat2=4;
int numcen=8;
int numgal=54;

	public Servidor( ) {

		try {
			//crea socket y espera
			ServerSocket skServidor = new ServerSocket( PUERTO );
			System.out.println("Escucho el puerto " + PUERTO );
			
			//for (int numCli=0;numCli<3;numCli++)
			do{
				//Primitiva accept() crea nuevo socket skCliente
				//skCliente atiene al cliente
				Socket skCliente = skServidor.accept(); // Crea objeto

				System.out.println("Sirvo al cliente " );
				//asocio flujo salida de datos al socket
				OutputStream aux = skCliente.getOutputStream();
				InputStream aux2 = skCliente.getInputStream();
				//asocio flujo de datos flujo de tipo DataOutputStream 
				DataOutputStream flujo= new DataOutputStream( aux );
				DataInputStream flujo2= new DataInputStream( aux2 );
				//escribo
				flujo.writeUTF( "Servidor :Hola soy el servidor" );
				System.out.println( flujo2.readUTF() );
				flujo.writeUTF( "Conectado " );
				System.out.println( flujo2.readUTF() );
				flujo.writeUTF( "Hola soy el servidor " );
				System.out.println( flujo2.readUTF() );
				flujo.writeUTF( "Muy bien " );
				System.out.println( flujo2.readUTF() );
				flujo.writeUTF( "Hasta luego " );
				System.out.println( flujo2.readUTF() );
				flujo.writeUTF( "Cerrando conexion " );
				
				//cierro conexión
				skCliente.close();
			}while(n==false);
			System.out.println("Demasiados clientes por hoy");

		} catch( Exception e ) {

	System.out.println( e.getMessage() );

	}

}

public static void main( String[] arg ) {

new Servidor();

}

}



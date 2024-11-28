package ejercicio3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Cliente {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		byte[] bufer = new byte[1024];
		int port= 12349;
		InetAddress destino = InetAddress.getLocalHost();
		DatagramSocket sockete = new DatagramSocket();
		
		String ruta;
		
	//	Programa cliente: solicita al usuario el nombre de un fichero, incluyendo su ruta completa dentro del sistema de archivos del servidor.
		System.out.print("¿Cuál es la ruta completa del fichero que quieres consultar?");
		ruta = sc.nextLine();
		
		
		//Programa cliente: establece la conexión con el servidor  Programa cliente: envía el nombre y la ruta del fichero al servidor
		bufer = ruta.getBytes(); //pa poder mandarlo
		 
		DatagramPacket envio = new DatagramPacket(bufer, bufer.length, destino, port);
		sockete.send(envio);
		
		System.out.println("Esperando datagrama . . . .");
		
		
		//10) Programa cliente: acepta o recibe la entrada del servidor.
		//11) Programa cliente: recibe el contenido del fichero y muestra el contenido por pantalla.
		//12) Programa cliente: cierra conexiones
		byte[] bufer2 = new byte[1024];
		DatagramPacket recibo = new DatagramPacket(bufer2, bufer2.length); 
		sockete.receive(recibo); 
		String textoFichero = new String(recibo.getData(),0, recibo.getLength()); 
		
		System.out.println("Contenido del fichero => "+ textoFichero);
		
		sockete.close();
	}
}

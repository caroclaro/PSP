package ejercicio2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws Exception {
		byte[] bufer = new byte[1024];
		int port= 12349;
		DatagramSocket sockete = new DatagramSocket(port);
		
		System.out.println("Esperando al cliente................");
		
		DatagramPacket recibo = new DatagramPacket(bufer, bufer.length); //receptor del mensaje
		sockete.receive(recibo); //recibe el datagrama
		
		String textoNumerical = new String(recibo.getData(), 0, recibo.getLength()); 
		
		int num = Integer.valueOf(textoNumerical)  ;
		num = num * num;
		textoNumerical = String.valueOf(num);
		
		InetAddress destino = recibo.getAddress();
		int puerto = recibo.getPort();
		
		byte[] bufer2 = new byte[1024];
		bufer2 = textoNumerical.getBytes(); //pa poder mandarlo
		 
		DatagramPacket envio = new DatagramPacket(bufer2, bufer2.length, destino, puerto);
		sockete.send(envio);
		
		sockete.close();
	}

}
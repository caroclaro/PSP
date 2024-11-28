package ejercicio2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {


	public static void main(String[] args) throws IOException {
		
	Scanner sc = new Scanner(System.in);
	byte[] bufer = new byte[1024];
	int port= 12349;
	InetAddress destino = InetAddress.getLocalHost();
	DatagramSocket sockete = new DatagramSocket();
	
	System.out.println("¿De que número quieres calcular su cuadrado?");
	String texto = sc.nextLine();
	
	bufer = texto.getBytes(); //pa poder mandarlo
	 
	DatagramPacket envio = new DatagramPacket(bufer, bufer.length, destino, port);
	sockete.send(envio);
	
	
	System.out.println("El servidor lo está calculando");
	
	
	byte[] bufer2 = new byte[1024];
	DatagramPacket recibo = new DatagramPacket(bufer2, bufer2.length); 
	sockete.receive(recibo); 
	String textoMayus = new String(recibo.getData(),0, recibo.getLength()); 
	
	System.out.println(textoMayus);
	
	sockete.close();
}
}

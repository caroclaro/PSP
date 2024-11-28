package ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) throws IOException {
		byte[] bufer = new byte[1024];
		int port= 12349;
		DatagramSocket sockete = new DatagramSocket(port);
		
		System.out.println("Servidor esperando datagrama..............");
		
		DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
		sockete.receive(recibo);
		
		String texto = new String(recibo.getData(), 0, recibo.getLength()); 
		
		System.out.println("Recibido datagrama.............." + texto);
		
		String textoDelFichero = "";
		try (BufferedReader br = new BufferedReader(new FileReader(texto));){
			String leer;

			while ((leer = br.readLine()) != null) {
				textoDelFichero =textoDelFichero+  leer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("leer fichero conseguido");
		
		
		InetAddress destino = recibo.getAddress();
		int puerto = recibo.getPort();
		
		byte[] bufer2 = new byte[1024];
		bufer2 = textoDelFichero.getBytes(); 
		 
		DatagramPacket envio = new DatagramPacket(bufer2, bufer2.length, destino, puerto);
		sockete.send(envio);
		
		sockete.close();
	}
	}


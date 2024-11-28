package ejercicio1o;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 6006;
		String Host = "localhost";
		
		System.out.println("Programa cliente iniciado");
		Socket CLiente = new Socket(Host, port);
		
		
		// ENVIAR
		DataOutputStream flujoSalida = new DataOutputStream(CLiente.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Que quieres que el servidor convierta a mayusculas??????");
		String cuerda = sc.nextLine();
		
		flujoSalida.writeUTF(cuerda);
		
		
		//RECIBIR
		DataInputStream flujoEntrada = new DataInputStream(CLiente.getInputStream());
		
		System.out.println(flujoEntrada.readUTF());
		
		sc.close();
		flujoEntrada.close();
		flujoSalida.close();
		CLiente.close();
	}
}

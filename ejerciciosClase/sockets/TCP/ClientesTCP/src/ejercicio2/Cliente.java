package ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

	
	public static void main(String[] args) throws UnknownHostException, IOException {
		int port = 6007;
		String Host = "localhost";
		
		System.out.println("CLIENTE INICIADO");
		Socket Cliente = new Socket(Host, port);
		
		
		DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Sobre que num quieres que el server calcule la potencia????");
		int num = sc.nextInt();
		flujoSalida.write(num);
		
		
		//RECIBIR
		DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
		
		System.out.println(flujoEntrada.read());
		
		sc.close();
		flujoEntrada.close();
		flujoSalida.close();
		Cliente.close();
	}
}

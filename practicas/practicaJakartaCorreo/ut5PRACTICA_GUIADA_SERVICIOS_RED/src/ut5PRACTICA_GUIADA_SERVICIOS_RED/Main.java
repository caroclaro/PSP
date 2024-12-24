package ut5PRACTICA_GUIADA_SERVICIOS_RED;

import java.util.Scanner;

import jakarta.mail.MessagingException;

public class Main {
	

	public static void main(String[] args)  {
		
		GestorCorreo gestorCorreo = new GestorCorreo();
		Scanner sc = new Scanner(System.in);
	
		String correo = "caro.car.brm@gmail.com";

		System.out.println("Introduce tu destinatario");
		String destinatario = sc.nextLine();

		System.out.println("Introduce el asunto");
		String asunto = sc.nextLine();

		System.out.println("Introduce el texto del mensaje:");
		String mensaje = sc.nextLine();

			System.out.println("¿Quieres incluir archivo? (SI/NO):");
			String respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("SI")) {
				try {
					gestorCorreo.enviarMensajeTexto(correo, destinatario, asunto, mensaje);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Mensaje enviado");
			}
			else if (respuesta.equalsIgnoreCase("NO")) {
				//adjunto = false;
			}else {
				System.out.println("RESPUESTA INVALIDA");
			}
		
}

}

package practicaMultiproyecto1;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class practicaMultiproceso1 {

	public static final int MAX_OPC=3;
	
	static int menu(int tope_op, Scanner sc)
	{
		int opcion_menu;
		
		System.out.println();
	    System.out.println("\t1. Apagar sistema");
		System.out.println("\t2. Reiniciar sistema");
		System.out.println("\t3. Suspenderlo");
		do
		{
			System.out.print("\n\n\tElija opcion:");
			opcion_menu = Integer.parseInt(sc.nextLine());
		} while (opcion_menu  < 1 || opcion_menu > tope_op);
		
	    return opcion_menu;
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		
	   int opcion=0;
	   int tiempo;
	   
	   Scanner sc = new Scanner(System.in);
	   
	   Process p,p1;
	   Runtime entorno = Runtime.getRuntime();
	   
	   while (opcion != MAX_OPC)
		{
			opcion = menu(MAX_OPC, sc);
			switch (opcion)
	      	{
	         case 1:
	        	 	System.out.println("¿Cuántos segundos quieres dejar antes de realizar esta acción?");
	        	 	tiempo = sc.nextInt();
	 				try {
						p = entorno.exec("C:\\Windows\\System32\\shutdown");
						boolean b = p.waitFor(tiempo,TimeUnit.SECONDS);
						p1= entorno.exec("shutdown -s");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                 break;
	         case 2:
	        	 	System.out.println("¿Cuántos segundos quieres dejar antes de realizar esta acción?");
	        	 	tiempo = sc.nextInt();	
	 				try {
						p = entorno.exec("C:\\Windows\\System32\\shutdown");
	 					boolean b = p.waitFor(tiempo,TimeUnit.SECONDS);
						p1= entorno.exec("shutdown -r");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                 break;
	         case 3:	
	        	 	System.out.println("¿Cuántos segundos quieres dejar antes de realizar esta acción?");
	        	 	tiempo = sc.nextInt();
	 				try {
						p = entorno.exec("C:\\Windows\\System32\\shutdown");
	 					boolean b = p.waitFor(tiempo,TimeUnit.SECONDS);
						p1= entorno.exec("shutdown -h");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                 break;
	     	}
	     }
	     sc.close();
	   }

	

}



package comunicacionProcesos;
 
import java.util.Scanner;
public class LeerNombre {

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		String nombre;
		
		try {
		nombre=sc.nextLine();

		System.out.println("Hola "+ nombre);
//		System.out.println(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(-1);
		}
	}
}




//
//{        
//
//	try {	
//					
//		//numero = Integer.parseInt(br.readLine());
//		numero = sc.nextInt();
//		if (numero % 2 == 0) {
//			System.out.println("El número es par" );
//	    } else {
//	    	System.out.println("El número es impar" );
//	    	System.out.println("El número es impar REPITO" );
//	    }			
//        System.exit(0);
//		}
//	catch (Exception e) {
//		e.printStackTrace();
//		System.exit(-1);			
//		}		
//}	
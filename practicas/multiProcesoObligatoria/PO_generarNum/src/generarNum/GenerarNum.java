package generarNum;

import java.util.ArrayList;

public class GenerarNum {

	public static void main(String[] args) {
		ArrayList<Integer> numerosImpares = new ArrayList<>();
		
		//PARA EL PROGRAMA DE FICHEROS SI QUE LO DEJARÍA PARA QUE SALIESE EN ESTOS , PERO SI NO EN EL PRIMERO DE LLAMAR PROYECTOS ME DA ERROR PORQUE LO 
		//LEE CON EL readLine()) Y DA ERROR Y NO SE ARREGLAR ESO
			//System.out.println("Pintando la salida del programa de la generación de impares");  
		
		for (int i=0; i<10;) {
			int num = (int) (Math.random()*100);  //generacion nums
			
			if (num%2 != 0) { //si es impar
				numerosImpares.add(num);
				i++;
			}
		}
		
		for (int num : numerosImpares) {
			System.out.println(num);
		}
		
		System.exit(0);
	}
}


//Escribe un programa Java que genera 10 números aleatorios impares y los escribe en la
//salida estándar.
//realiza los cambios necesarios para que la salida del primer
//programa sea a un fichero llamado impares.txt. 
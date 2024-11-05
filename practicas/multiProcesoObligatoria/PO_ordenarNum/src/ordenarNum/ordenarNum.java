package ordenarNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ordenarNum {

	public static void main(String[] args) {
		//PARA EL PROGRAMA DE FICHEROS, explicado en GenerarNum, aquí no hace falta pero lo quito para que sean iguales
			//System.out.println("Salida ordenada del segundo programa");
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		//PARA EL PROGRAMA DE FICHEROS, explicado en GenerarNum
			//sc.nextLine(); // pq si no no pilla los números por el encabezado de pintando la salida de....
		
		for(int i=0; i<10; i++) {
			int num = sc.nextInt();
			numeros.add(num);
		}
		

        Collections.sort(numeros);
        
        for (Integer numero : numeros) {
            System.out.println(numero);
        }
        System.exit(0);
        sc.close();}
		
	}



//Escribe otro programa Java que recibe por la entrada estándar 10 números, los ordena de
//menor a mayor y escribe en la salida estándar los 10 números ya ordenados.
//Este fichero será la entrada en el segundo
//programa
package examen;

import java.util.Arrays;

public class Dispensador extends Thread {

	int totalG, totalF;
	Integer[] hueco = new Integer[3];
	
	public Dispensador(Integer[] hueco) {
		super();
		this.hueco = hueco;
		totalG=0;
		totalF=0;
	}
	
//	Queso fresco;
//	Queso Gruyer;
	
	public void dispensadorPrincipal() {
		GenerarQueso();
		queHay();
	}
	
	public void GenerarQueso() {
		int tipoQueso = (int) ((Math.random()*2)+1);
		
		if (tipoQueso ==1) {
			System.out.println("El dispensador ha puesto una bola de queso Gruyere");
			totalG++;
		}
		else if(tipoQueso ==2) {
			System.out.println("El dispensador ha puesto una bola de queso Fresco");
			totalF++;
		}
		
		int generacion = (int) (Math.random()*200);
		try {
			sleep(generacion);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		int controlador = -1;
		while (controlador == -1) {
		controlador = PosicionVacia();
		}
	
		hueco[controlador]= tipoQueso;
		
		if (tipoQueso ==1) {
			System.out.println("Se ha puesto una una bola de queso Gruyere en la posicion "+ controlador);
		}
		else if(tipoQueso ==2) {
		System.out.println("Se ha puesto una una bola de queso Fresco en la posicion "+ controlador);
		}
	}
	
	public synchronized void queHay() {
		System.out.println(Arrays.toString(hueco));
	}
	
	public  synchronized void seLoComieron(int posicion) {
		hueco[posicion]= null;
	}
	
	public int PosicionVacia() {
		for (int i=0; i<hueco.length; i++) {
			if (hueco[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public synchronized int noEstaVacio() {
		if(hueco !=null) {
			return 1;
		}
		return -1;
		
	}

	public synchronized int tenemosGruyer() {
	if (hueco != null) {
			
			for (int i=0; i<hueco.length; i++) { //primero comprobamos si hay Gruyer
				if ((hueco[i] != null && hueco[i].equals(1))) {
					return i;
				}}}
		return -1;
	}
	
	public synchronized int tenemosFresco() {
				for (int i=0; i<hueco.length; i++) { //Después fresco
					if ((hueco[i] != null && hueco[i].equals(2))) {
						return i;
					}}
		return -1;
}
	
	public void seAcabo() {
		System.out.println("SE PARA EL DISPENSADOR");
		System.out.println("-----------------------------------------------------");
		System.out.println("Quedan bolas en los huecos del comedero "+ Arrays.toString(hueco));
		System.out.println("Bolas de queso que han caido en total: "+ (totalF+totalG));
		System.out.println("Recogidos por tipo: [" + totalG + ", "+ totalF + "]");
		System.out.println("-----------------------------------------------------");
	}
	
}

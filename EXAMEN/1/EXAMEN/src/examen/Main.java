package examen;

public class Main {
	
public static void main(String[] args) {
	Integer[] hueco = new Integer[3];
	Dispensador dispensador = new Dispensador(hueco);
	
	Raton pixie = new Raton("Pixie",dispensador);
	Raton dixie = new Raton("Dixie",dispensador);
	
	pixie.start();
	dixie.start();
	
	while (pixie.isAlive()&&dixie.isAlive()) {
		dispensador.dispensadorPrincipal();
	}

	
	dispensador.seAcabo();
}
}

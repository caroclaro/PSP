package BOOm;

public class Main {

	public static void main(String[] args) {
		
		Bomba bomba = new Bomba();
		Artificiero artificiero = new Artificiero();
		
		bomba.start();
		artificiero.start();
		
		do {
			
		}while (bomba.isAlive() && artificiero.isAlive()); 
		
		if (bomba.isAlive() == false ) {  //Si es distinto de vivo, osea si está muert0
			artificiero.interrupt();
		}
		else {
			bomba.interrupt();
		}
		
	}
}

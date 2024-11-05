package relevos;

public class Main {

	public static void main (String args[] ) throws InterruptedException {
		
		Corredor Pepe = new Corredor("España", "Pepe");
		Corredor Ferita = new Corredor("España", "Ferita");
		Corredor Caro = new Corredor("España", "Caro");
		Corredor Manu = new Corredor("España", "Manu");
		Corredor[] jugantes = new Corredor[4];
		jugantes[0]= Pepe;
		jugantes[1]= Ferita;
		jugantes[2]= Caro;
		jugantes[3]= Manu;
		
		Equipos España = new Equipos(jugantes, "España");
		
		
		
		Corredor Josh = new Corredor("EEUU", "Josh");
		Corredor Marc = new Corredor("EEUU", "Marc");
		Corredor Stella = new Corredor("EEUU", "Stella");
		Corredor Liz = new Corredor("EEUU", "Liz");
		Corredor[] jugantasion = new Corredor[4];
		jugantasion[0]= Josh;
		jugantasion[1]= Marc;
		jugantasion[2]= Stella;
		jugantasion[3]= Liz;
		
		Equipos EEUU = new Equipos(jugantasion, "EEUU");
		
		España.start();
		EEUU.start();
	
		
		EEUU.join();
		España.join();
		System.out.println("FIN DEL PROGRAMA");
}

}
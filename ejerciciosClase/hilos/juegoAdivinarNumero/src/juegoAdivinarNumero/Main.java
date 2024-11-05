package juegoAdivinarNumero;

public class Main {
 public static void main(String[] args) {
	Arbitro arbitro = new Arbitro(3);
	
//	Jugador jug1 = new Jugador(0, arbitro);
//	Jugador jug2 = new Jugador(1, arbitro);
//	Jugador jug3 = new Jugador(2, arbitro);
	
	System.out.println("NUMERO A ADIVINAR "+ arbitro.numeroAdivinar);
	
	
	for(int i=0;i<=3;i++) {
		Jugador j= new Jugador(i, arbitro);
		j.start();
	}
	

     
  
}
}

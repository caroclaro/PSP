package juegoAdivinarNumero;

public class Jugador extends Thread{

	int id;
	Arbitro arbitro;
	
	public Jugador(int id, Arbitro arbitro) {
		super();
		this.id = id;
		this.arbitro = arbitro;
	}
	
	public int generarNum () {
		int num = (int) (Math.random() * (10 - 1) + 1);
		return num;
	}
	
	public void jugada() {
		while (!arbitro.getjuegoAcabado()) {
			this.yield();
				if(arbitro.getTurno() == id) {
					int num = generarNum();
					System.out.println("Jugador " + (id+1) + " dice: " +num);
					arbitro.partida(id, num);
				}
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
               
            }
	}
	
	}
	
	@Override
	public void run() {
        this.jugada(); 
}}

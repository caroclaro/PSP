package juegoAdivinarNumero;

public class Arbitro {

	//CONSTRUCTOR
	int numTotalJugadores;
	int turno;
	int numeroAdivinar ;
	
	public Arbitro(int numTotalJugadores) {
		super();
		this.numTotalJugadores = numTotalJugadores;
		turno= 0;
		numeroAdivinar = (int) (Math.random() * (10 - 1) + 1);
	}
	
	
	// DEVUELVE EL TURNO EN EL QUE ESTÁMN
	public int getTurno() {
		return turno;
	}
	
	
	public void setTurno(int turno) {
		this.turno = turno;
	}


	//METODO QUE INDICA SI EL JUEGO ACABÓ O NO
	boolean juegoAcabado = false;
	public boolean getjuegoAcabado() {
		return juegoAcabado;
	}
	
	public synchronized void partida (int ID, int num) {
			if (ID == getTurno()) {
				if (num == numeroAdivinar) {
					System.out.println("¡¡ Jugador " + (ID + 1) + " gana, adivinó el número !!");
					juegoAcabado = true;
				} else {
					turno++;
					if (turno>numTotalJugadores) {
						turno=0;
				}
					System.out.println("                  Le toca a jugador " + (getTurno()+1));
			}
	}

		}}


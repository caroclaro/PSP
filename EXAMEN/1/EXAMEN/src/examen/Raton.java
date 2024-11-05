package examen;

public class Raton extends Thread {

	String nombre;
	int peso;
	int bolasFresco, bolasGruyer;
	Dispensador dispensador;
	
	public Raton(String nombre, Dispensador dispensador) {
		super();
		this.nombre = nombre;
		this.dispensador= dispensador;
		peso=100;
	}
	
	public void principalRaton() {
		int tipoQueso = comprobarComida() ;
		comer(tipoQueso);
		volver();
	}
	
	public int comprobarComida () {
		//primero comprobamos que haya algo
		int comprobante=-1;
		
		while(comprobante==-1) {
			comprobante = dispensador.noEstaVacio();
		}
		
		int cual=-1;
		cual = dispensador.tenemosGruyer();
		if (cual == -1) {
			cual=dispensador.tenemosFresco();
			if (cual != -1) {
				dispensador.seLoComieron(cual);
				bolasFresco++;
				return 2;
			}
		}
		else{
			dispensador.seLoComieron(cual);
			bolasGruyer++;
			return 1;
		}
		return 0;
		}
	
	
	public void comer(int tipoQueso) {
		int tardanza= (int) (Math.random()*100);
		try {
			sleep(tardanza);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//lo que engorda
		if (tipoQueso==1) {
			System.out.println("El ratón "+ nombre + " ha cogido una bola de queso Gruyere ");
			peso++;
		}
		else if (tipoQueso==2) {
			System.out.println("El ratón "+ nombre + " ha cogido una bola de queso Fresco ");
			peso = peso+2;
		}
	}
	
	public void volver() {
		int tardanza= (int) (Math.random()*500);
		try {
			sleep(tardanza);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void satisfecho() {
		System.out.println(nombre + " no tiene más hambre");
		System.out.println("TOTAL "+ nombre + " ha comido " + bolasFresco + " bolas de queso Fresco");
		System.out.println("TOTAL "+ nombre + " ha comido " + bolasGruyer + " bolas de queso Gruyer");
	}
	
	@Override
	public void run() {
		System.out.println("El ratón "+ nombre+ " empieza a buscar bolas de queso");
		 while (peso < 110) {
			 principalRaton() ;
	        }
	        satisfecho();
	}
	
}

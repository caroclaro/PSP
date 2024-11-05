package BOOm;

public class Bomba extends Thread {

	public void cuentaAtras()  {
		for (int contar=10; contar>0; contar--) {
			System.out.println(contar);
			try {
				Thread.sleep((long) 1000);

			} catch (InterruptedException e) {
				System.out.println("La bomba fue desactivada");
				return;
			}
		}
		System.out.println("BOOOOOOOOOOOOM");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.cuentaAtras();
	}

}

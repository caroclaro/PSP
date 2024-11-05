package iron_man;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Ironman Pedro = new Ironman("Pedro", 6, 20, 1000);
		Ironman Juan = new Ironman("Juan", 7, 18, 2000);
		Ironman Vicente = new Ironman("Vicente", 6, 30, 1000);
		
		Pedro.start();
		Juan.start();
		Vicente.start();
	}
}

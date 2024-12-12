package tema2.ejercicio_2_5;

import java.util.Scanner;

public class ejercicio_2_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyHilo hilo = new MyHilo();
		String entrada="";
		hilo.start();
		do {
			System.out.println("Introducir una cadena");
			entrada=sc.nextLine();
			
			if(entrada.equals("S")) {
				hilo.suspende();
			}else if(entrada.equals("R")) {
				hilo.reanuda();
			}else {
				
			}
		} while (!entrada.equals("*"));
	}

}

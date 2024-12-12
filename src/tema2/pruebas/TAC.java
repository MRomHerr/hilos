package tema2.pruebas;

public class TAC extends Thread{
	
	public static void main(String[] args) {
		
 
		TIC hiloTic = new TIC();
		TAC hiloTac = new TAC();
		
		hiloTic.start();
		hiloTac.start();
		
		
	}
}

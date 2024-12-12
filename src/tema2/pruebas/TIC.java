package tema2.pruebas;

public class TIC extends Thread {
	
	public void run() {
		
		while(true) {
			System.out.println("TIC");
			try {
				sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}

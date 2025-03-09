package tema2.ejercicio2_4;

// Clase principal que crea y ejecuta los hilos
public class Ejercicio2_4 {
    public static void main(String[] args) {
        // Creamos 5 hilos
        for (int i = 1; i <= 5; i++) {
            // Creamos un objeto de la clase HolaMundoRunnable
            Runnable runnable = new HolaMundoRunnable("Mensaje " + i);

            // Creamos un hilo y lo iniciamos
            Thread hilo = new Thread(runnable);
            hilo.start();
        }
    }
}

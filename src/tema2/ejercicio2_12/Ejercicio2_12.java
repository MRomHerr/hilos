package tema2.ejercicio2_12;

// Clase principal que inicia el productor y el consumidor
public class Ejercicio2_12 {
    public static void main(String[] args) {
        Cola cola = new Cola(); // Crea la cola compartida

        // Crea el productor y el consumidor
        Productor productor = new Productor(cola);
        Consumidor consumidor = new Consumidor(cola);

        // Inicia el productor y el consumidor
        productor.start();
        consumidor.start();

        // Espera a que ambos hilos terminen
        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFin del programa.");
    }
}
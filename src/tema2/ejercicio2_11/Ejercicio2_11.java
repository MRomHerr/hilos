package tema2.ejercicio2_11;

// Clase principal que inicia el productor y los consumidores
public class Ejercicio2_11 {
    public static void main(String[] args) {
        Cola cola = new Cola(); // Crea la cola compartida

        // Crea el productor
        Productor productor = new Productor(cola, 1);

        // Crea dos consumidores
        Consumidor consumidor1 = new Consumidor(cola, 1);
        Consumidor consumidor2 = new Consumidor(cola, 2);

        // Inicia el productor y los consumidores
        productor.start();
        consumidor1.start();
        consumidor2.start();
    }
}
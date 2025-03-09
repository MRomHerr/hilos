package tema2.ejercicio2_10;

// Clase principal que inicia el productor y el consumidor
public class Ejercicio2_10 {
    public static void main(String[] args) {
        Cola cola = new Cola(); // Crea la cola compartida
        Productor productor = new Productor(cola, 1); // Crea el productor
        Consumidor consumidor = new Consumidor(cola, 1); // Crea el consumidor

        productor.start(); // Inicia el productor
        consumidor.start(); // Inicia el consumidor
    }
}
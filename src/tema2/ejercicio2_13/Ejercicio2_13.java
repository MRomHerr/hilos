package tema2.ejercicio2_13;

// Clase principal que inicia el productor y los consumidores
public class Ejercicio2_13 {
    public static void main(String[] args) {
        Cola cola = new Cola(); // Crea la cola compartida

        // Crea el productor y los consumidores
        Productor productor = new Productor(cola, "archivo.txt"); // Cambia "archivo.txt" por el nombre de tu archivo
        Consumidor consumidor1 = new Consumidor(cola, 1);
        Consumidor consumidor2 = new Consumidor(cola, 2);

        // Inicia el productor y los consumidores
        productor.start();
        consumidor1.start();
        consumidor2.start();

        // Espera a que el productor y los consumidores terminen
        try {
            productor.join();
            consumidor1.join();
            consumidor2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verifica el estado de los consumidores
        System.out.println("Estado del consumidor 1: " + consumidor1.getState());
        System.out.println("Estado del consumidor 2: " + consumidor2.getState());

        System.out.println("Todos los procesos han finalizado.");
    }
}

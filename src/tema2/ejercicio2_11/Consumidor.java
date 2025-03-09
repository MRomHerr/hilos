package tema2.ejercicio2_11;

// Clase Consumidor que obtiene números de la cola y los consume
class Consumidor extends Thread {
    private Cola cola;
    private int id;

    // Constructor que recibe la cola y el ID del consumidor
    public Consumidor(Cola cola, int id) {
        this.cola = cola;
        this.id = id;
    }

    // Método run() que obtiene números de la cola y los consume
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) { // Cada consumidor consume 3 números
            int valor = cola.get(); // Obtiene el número de la cola
            System.out.println("    " + i + "=> Consumidor: " + id + ", consume: " + valor);
        }
    }
}
package tema2.ejercicio2_13;

// Clase Consumidor que obtiene caracteres de la cola y los visualiza
class Consumidor extends Thread {
    private Cola cola;
    private int id;

    // Constructor que recibe la cola y el ID del consumidor
    public Consumidor(Cola cola, int id) {
        this.cola = cola;
        this.id = id;
    }

    // Método run() que obtiene y visualiza los caracteres de la cola
    @Override
    public void run() {
        while (true) {
            char c = cola.get(); // Obtiene el carácter de la cola
            if (c == '\0') { // Si el carácter es nulo, el productor ha terminado
                System.out.println("Consumidor " + id + " ha finalizado.");
                break;
            }
            System.out.println("Consumidor " + id + " consume: " + c);
        }
    }
}
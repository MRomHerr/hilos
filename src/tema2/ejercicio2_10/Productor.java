package tema2.ejercicio2_10;

// Clase Productor que genera números y los coloca en la cola
class Productor extends Thread {
    private Cola cola;
    private int id;

    // Constructor que recibe la cola y el ID del productor
    public Productor(Cola cola, int id) {
        this.cola = cola;
        this.id = id;
    }

    // Método run() que genera números y los coloca en la cola
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            cola.put(i); // Coloca el número en la cola
            System.out.println("Productor " + id + " produce: " + i);
            try {
                Thread.sleep(100); // Simula un retardo en la producción
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package tema2.ejercicio2_12;

// Clase Productor que genera las cadenas "PING" y "PONG" de forma alternativa
class Productor extends Thread {
    private Cola cola;

    // Constructor que recibe la cola
    public Productor(Cola cola) {
        this.cola = cola;
    }

    // Método run() que genera "PING" y "PONG" de forma alternativa
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // Genera 10 pares de "PING" y "PONG"
            if (i % 2 == 0) {
                cola.put("PING"); // Coloca "PING" en la cola
            } else {
                cola.put("PONG"); // Coloca "PONG" en la cola
            }
        }
    }
}
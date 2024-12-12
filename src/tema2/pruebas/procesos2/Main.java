package tema2.pruebas.procesos2;

import tema2.Ejercicio2_14.Arbitro;
import tema2.Ejercicio2_14.Jugador;

public class Main {
    public static void main(String[] args) {

        Hilo proceso1 = new Hilo();
        Thread proceso2 = new Thread (new HiloRunnable());

        proceso1.start();
        try {
            proceso1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        proceso2.start();

    }
}

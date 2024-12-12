package tema2.pruebas.Threads;


import tema2.pruebas.procesos2.Hilo;
import tema2.pruebas.procesos2.HiloRunnable;

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

package tema2.pruebas.Ejemplo;

import tema2.pruebas.procesos2.Hilo;
import tema2.pruebas.procesos2.HiloRunnable;

public class Main {
    public static void main(String[] args) {

        Ejemplo1 hilo1 = new Ejemplo1();
        hilo1.start();

        Thread hilo2 = new Thread (new EjecutableRunnable());
        hilo2.start();
    }
}

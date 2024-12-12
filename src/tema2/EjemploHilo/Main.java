package tema2.EjemploHilo;

public class Main {
    public static void main (String[] args) throws InterruptedException {
        ControlHilos hilo1 = new ControlHilos("Hilo-1");
        hilo1.start();
        hilo1.join();
        ControlHilos hilo2 = new ControlHilos("Hilo-2");
        hilo2.start();
    }
}

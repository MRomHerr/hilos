package tema2.ejercicio2_8;

// Clase principal que crea y ejecuta los hilos
public class Ejercicio2_8 {
    public static void main(String[] args) {
        // Creamos un objeto Saldo con un saldo inicial de 100
        Saldo saldo = new Saldo(100);
        System.out.println("Saldo inicial: " + saldo.getSaldo());

        // Creamos varios hilos que comparten el objeto Saldo
        HiloSaldo hilo1 = new HiloSaldo(saldo, 50, "Hilo 1");
        HiloSaldo hilo2 = new HiloSaldo(saldo, 30, "Hilo 2");
        HiloSaldo hilo3 = new HiloSaldo(saldo, 20, "Hilo 3");

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Esperamos a que todos los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostramos el saldo final
        System.out.println("Saldo final: " + saldo.getSaldo());
    }
}

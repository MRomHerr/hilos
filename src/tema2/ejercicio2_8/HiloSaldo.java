package tema2.ejercicio2_8;

// Clase que extiende Thread y usa el método sincronizado de Saldo
class HiloSaldo extends Thread {
    private Saldo saldo;
    private int cantidad;

    // Constructor que recibe el objeto Saldo y la cantidad a añadir
    public HiloSaldo(Saldo saldo, int cantidad, String nombreHilo) {
        super(nombreHilo);
        this.saldo = saldo;
        this.cantidad = cantidad;
    }

    // Método run() que ejecuta el hilo
    @Override
    public void run() {
        saldo.añadirSaldo(cantidad, getName()); // Llama al método sincronizado
    }
}

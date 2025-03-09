package tema2.ejercicio2_8;

// Clase Saldo que maneja el saldo y tiene métodos sincronizados
class Saldo {
    private int saldo;

    // Constructor que inicializa el saldo
    public Saldo(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Método para obtener el saldo
    public int getSaldo() {
        try {
            Thread.sleep((long) (Math.random() * 100)); // Simula un retardo aleatorio
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return saldo;
    }

    // Método para establecer el saldo
    public void setSaldo(int nuevoSaldo) {
        try {
            Thread.sleep((long) (Math.random() * 100)); // Simula un retardo aleatorio
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.saldo = nuevoSaldo;
    }

    // Método sincronizado para añadir una cantidad al saldo
    public synchronized void añadirSaldo(int cantidad, String nombreHilo) {
        int saldoInicial = getSaldo(); // Obtiene el saldo inicial
        System.out.println(nombreHilo + " está añadiendo " + cantidad + " al saldo.");
        System.out.println("Saldo inicial: " + saldoInicial);

        setSaldo(saldoInicial + cantidad); // Añade la cantidad al saldo

        int saldoFinal = getSaldo(); // Obtiene el saldo final
        System.out.println("Saldo final: " + saldoFinal);
    }
}
package tema2.Ejercicio2_14;

import java.util.Random;

public class Jugador extends Thread {
    private final int id;
    private final Arbitro arbitro;

    public Jugador(int id, Arbitro arbitro) {
        this.id = id;
        this.arbitro = arbitro;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (!arbitro.isJuegoTerminado()) {
            int numero = random.nextInt(10) + 1;
            arbitro.comprobarJugada(id, numero);
            try {
                Thread.sleep(1000); // 1 segundo de espera
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

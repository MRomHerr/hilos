package tema2.pruebas.Synchronized;

public class Main {
    public static void main(String[] args) {

        Contador contador = new Contador();

        Thread hilo1 = new Thread(() ->{
            for (int i=0;i<10000;i++){ //suma el conator 10 veces
                contador.sumar();
            }
        });

        Thread hilo2 = new Thread(() ->{
            for (int i=0;i<10000;i++){ //suma el contador 10 veces
                contador.sumar();
            }
        });

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("suma de hilo1 e hilo2: "+contador.getContador());

    }
}

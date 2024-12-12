package tema2.pruebas.Ejemplo;

import java.util.concurrent.ThreadLocalRandom;

public class Ejemplo1 extends Thread{

    public void run(){
        try {

            int randomNum = ThreadLocalRandom.current().nextInt(2000,5000+1);//espera entre 2 y 5 segundos
            System.out.println("Hola soy hilo1");
            Thread.sleep(randomNum);
            System.out.println("Adios soy hilo1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

package tema2.pruebas.Ejemplo;

public class EjecutableRunnable implements Runnable{

    @Override
    public void run (){

        try {
            System.out.println("Hola soy un ejecutable");
            Thread.sleep(3000);//espera 3 segundos
            System.out.println("Adios soy un ejecutable");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
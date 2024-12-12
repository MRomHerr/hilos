package tema2.pruebas.Threads.Segundo;


public class Main {
    public static void main(String[] args) {

        Thread p1 = new Thread (new Contador("1",10));
        Thread p2 = new Thread (new Contador("2",2));
        Thread p3 = new Thread (new Contador("3",5));
        Thread p4 = new Thread (new Contador("4",3));

        p1.start();
        p2.start();
        p3.start();
        p4.start();

        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fin del programa");
    }
}

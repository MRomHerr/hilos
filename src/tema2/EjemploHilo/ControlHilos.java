package tema2.EjemploHilo;

public class ControlHilos extends Thread {
    boolean a=true;
    String nombre;

    public ControlHilos(String nombre) {
        this.nombre=nombre;
    }


    public void run(){
        while(a==true){
            for(int i=0;i<=5;i++){
                System.out.println(nombre+"bucle "+i);
            }
            a=false;
        }
    }
}

package tema2.pruebas.Synchronized;

public class Contador {

    private int contador =0;

    public synchronized void sumar() {
        contador++;
    }

    /**
     * otra forma
     * public void sumar() {
     *     synchronized(this){
     *            contador++;
     *          }
     *     }
     *
     */

    public int getContador(){
        return contador;
    }
}

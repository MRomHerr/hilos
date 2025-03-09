package tema2.ejercicio2_13;

import java.io.FileReader;
import java.io.IOException;

// Clase Productor que lee caracteres de un archivo y los coloca en la cola
class Productor extends Thread {
    private Cola cola;
    private String nombreArchivo;

    // Constructor que recibe la cola y el nombre del archivo
    public Productor(Cola cola, String nombreArchivo) {
        this.cola = cola;
        this.nombreArchivo = nombreArchivo;
    }

    // Método run() que lee el archivo y coloca los caracteres en la cola
    @Override
    public void run() {
        try (FileReader fr = new FileReader(nombreArchivo)) {
            int c;
            while ((c = fr.read()) != -1) {
                cola.put((char) c); // Coloca el carácter en la cola
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cola.finalizar(); // Indica que el productor ha terminado
            System.out.println("Productor ha finalizado.");
        }
    }
}
package servidores.ejercicio3_13;

import java.io.*;
import java.net.*;

// Clase que implementa Runnable para manejar clientes en un chat.
// Se ejecuta en un hilo separado por cada cliente conectado.
public class ManejadorCliente implements Runnable {
    private Socket socket;

    // Constructor que inicializa el socket del cliente.
    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Se usan flujos para enviar y recibir datos del cliente.
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            String input;
            // Bucle para procesar mensajes hasta recibir "*".
            while (!(input = in.readUTF()).equals("*")) {
                System.out.println("Recibido: " + input);
                // Eliminar vocales de la cadena recibida.
                String processed = input.replaceAll("[AEIOUaeiou]", "");
                // Enviar la cadena procesada de vuelta al cliente.
                out.writeUTF(processed);
            }
            System.out.println("Cliente desconectado.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cerrar el socket al finalizar la conexión.
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

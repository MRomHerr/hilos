package servidores.ejercicio3_13;

import java.io.*;
import java.net.*;
import java.util.Scanner;

// Clase principal del cliente de chat TCP.
public class ChatCliente {
    public static void main(String[] args) {
        String serverName = "localhost"; // Dirección del servidor.
        int port = 11223; // Puerto del servidor.

        // Conexión al servidor y configuración de los flujos.
        try (Socket socket = new Socket(serverName, port);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Conectado al servidor de chat. Introduce texto (\"*\" para salir):");

            String input;
            while (true) {
                // Leer entrada del usuario.
                input = scanner.nextLine();
                // Enviar la entrada al servidor.
                out.writeUTF(input);
                if (input.equals("*")) {
                    break; // Salir si el usuario introduce "*".
                }

                // Recibir la respuesta procesada del servidor.
                String response = in.readUTF();
                System.out.println("Servidor: " + response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

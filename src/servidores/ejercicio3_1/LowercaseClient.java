package servidores.ejercicio3_1;

/*
Crea un programa servidor que envíe un mensaje en mayúsculas a otro programa
cliente y el programa cliente devuelva el mensaje en minúsculas
 */
import java.io.*;
import java.net.*;

public class LowercaseClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(serverName, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = "Hola Servidor";
            System.out.println("Enviando mensaje: " + message);
            out.println(message);

            String response = in.readLine();
            System.out.println("Respuesta del servidor en minúsculas: " + response.toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

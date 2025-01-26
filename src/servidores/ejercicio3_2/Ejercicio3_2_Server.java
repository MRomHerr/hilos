package servidores.ejercicio3_2;

import java.io.*;
import java.net.*;

public class Ejercicio3_2_Server {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor listo para enviar mensajes en mayúsculas");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String input = in.readLine();
                System.out.println("Mensaje recibido: " + input);
                String output = input.toUpperCase();
                out.println(output);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

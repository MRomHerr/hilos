package servidores.ejercicio3_5;

import java.io.*;
import java.net.*;

public class Ejercicio3_5_Server {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor listo para recibir cadenas de texto");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String input;
                while ((input = in.readLine()) != null) {
                    if (input.equals("*")) {
                        break;
                    }
                    System.out.println("Recibido: " + input);
                    out.println(input);
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

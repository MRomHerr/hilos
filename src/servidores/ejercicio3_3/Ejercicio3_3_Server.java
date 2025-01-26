package servidores.ejercicio3_3;

import java.io.*;
import java.net.*;

public class Ejercicio3_3_Server {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor listo para calcular el cuadrado de números");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String input = in.readLine();
                int number = Integer.parseInt(input);
                System.out.println("Número recibido: " + number);
                int squared = number * number;
                out.println(squared);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
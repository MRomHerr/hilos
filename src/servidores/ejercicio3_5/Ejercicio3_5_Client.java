package servidores.ejercicio3_5;

/*
Usando sockets TCP realiza un programa cliente que introduzca cadenas por
teclado hasta introducir un asterisco. Las cadenas se enviarán a un programa
servidor. El programa servidor lo muestra en pantalla y lo devuelve al cliente. El
cliente lo recibe y lo muestra en pantalla.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio3_5_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(serverName, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);

            String input;
            System.out.println("Introduce cadenas de texto (introduce * para salir):");
            while (true) {
                input = scanner.nextLine();
                out.println(input);
                if (input.equals("*")) {
                    break;
                }
                String response = in.readLine();
                System.out.println("Respuesta del servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
